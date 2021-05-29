package ru.baburina.dbapp.ui.screen;

import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import ru.baburina.dbapp.db.HibernateUtil;
import ru.baburina.dbapp.ui.MainScene;
import ru.baburina.dbapp.ui.api.AppScreen;

import java.util.List;

public class SqlInjectorScreen implements AppScreen {

    public static final String id = "SqlInjectorScreen";

    private TextArea sql;
    private TextArea sqlResult;

    @Override
    public Node init() {
        this.sql = new TextArea();
        this.sqlResult = new TextArea();
        sqlResult.setEditable(false);

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

        var line2 = new HBox();
        line2.getChildren().add(this.sqlResult);

        var stack = new VBox();
        stack.getChildren().add(line1);
        stack.getChildren().add(line2);

        return stack;
    }

    private void onExecute() {
        var sqlQuery = this.sql.getText();

        if (sqlQuery == null || sqlQuery.length() == 0) {
            return;
        }

        try(var session = HibernateUtil.getSessionFactory().openSession()) {
            var query = session.createSQLQuery(sqlQuery);
            var result = (List<Object[]>)query.list();
            this.showResult(result);
        } catch (Throwable ex) {
            var alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setContentText(ex.getMessage() + "\n" + ex.toString());
            alert.showAndWait();
        }
    }

    private void showResult(List<Object[]> resultList) {
        if (resultList == null || resultList.size() == 0) {
            this.sqlResult.setText("[]");
            return;
        }
        var sb = new StringBuilder();
        for (var a : resultList) {
            for (var b: a) {
                sb.append(b.toString());
                sb.append("\n");
            }
        }
        this.sqlResult.setText(sb.toString());
    }
}
