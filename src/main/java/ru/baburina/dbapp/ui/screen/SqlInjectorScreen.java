package ru.baburina.dbapp.ui.screen;

import javafx.collections.FXCollections;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import ru.baburina.dbapp.app.services.SQLService;
import ru.baburina.dbapp.db.HibernateUtil;
import ru.baburina.dbapp.ui.MainScene;
import ru.baburina.dbapp.ui.api.AppScreen;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SqlInjectorScreen implements AppScreen {

    public static final String id = "SqlInjectorScreen";

    private TextArea sql;
    private VBox result;
    private final int pageSize = 1;
    private SQLService service = new SQLService();

    @Override
    public Node init() {
        this.sql = new TextArea();
        this.result = new VBox();

        var executeButton = new Button("Execute");
        executeButton.setOnAction(event -> {
            this.onExecute();
        });

        var backButton = new Button("Back");
        backButton.setOnAction(event -> {
            MainScene.popNode();
        });

        var buttonBlock = new VBox();
        buttonBlock.getChildren().add(executeButton);
        buttonBlock.getChildren().add(backButton);

        var line1 = new HBox();
        line1.getChildren().add(this.sql);
        line1.getChildren().add(buttonBlock);

        var stack = new VBox();
        stack.getChildren().add(line1);
        stack.getChildren().add(this.result);

        return stack;
    }

    @Override
    public Node init1(Object o) {
        return null;
    }

    private void onExecute() {
        final var sqlQuery = this.sql.getText();

        try {
            var resultCount = this.service.getCount(sqlQuery);
            var pages = this.countPages(resultCount);

            var pagination = new Pagination(pages);
            pagination.setPageFactory(page -> {
                var items = this.service.getItems(sqlQuery, page + 1, this.pageSize);
                return showResults(items);
            });

            this.result.getChildren().clear();
            this.result.getChildren().add(pagination);
        } catch (Throwable ex) {
            var alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setContentText(ex.getMessage() + "\n" + ex.toString());
            alert.showAndWait();
        }
    }

    private Node showResults(List<Map<String, Object>> items) {
        List<String> columns = new ArrayList<>();
        if (items.size() > 0) {
            var map = items.stream().findFirst();
            columns = new ArrayList<>(map.get().keySet());
        }
        var tableView = new TableView<Map<String, Object>>();
        var tableColumns = columns.stream().map(c -> {
            var column = new TableColumn<Map<String, Object>, Object>(c);
            column.setCellValueFactory(new MapValueFactory(c));
            column.setMinWidth(100);
            return column;
        }).collect(Collectors.toList());

        tableView.getColumns().setAll(tableColumns);
        tableView.setItems(FXCollections.observableList(items));

        var scrollPane = new ScrollPane();
        scrollPane.setContent(tableView);
        return scrollPane;
    }

    private int countPages(int totalResult) {
        if (totalResult == 0) {
            return 0;
        }
        return totalResult / this.pageSize + (totalResult%this.pageSize != 0 ? 1 : 0);
    }
}
