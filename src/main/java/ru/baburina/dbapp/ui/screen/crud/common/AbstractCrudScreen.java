package ru.baburina.dbapp.ui.screen.crud.common;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import ru.baburina.dbapp.ui.MainScene;
import ru.baburina.dbapp.ui.api.AppScreen;

import java.util.List;

public abstract class AbstractCrudScreen<VM> implements AppScreen {

    private final AbstractCrudTableBuilder<VM> abstractTableBuilder;
    private final AbstractModelFormBuilder<VM> abstractModelFormBuilder;

    private Node node;
    private ObservableList<VM> items;

    public AbstractCrudScreen(AbstractCrudTableBuilder<VM> abstractTableBuilder, AbstractModelFormBuilder<VM> abstractModelFormBuilder) {
        this.abstractTableBuilder = abstractTableBuilder;
        this.abstractModelFormBuilder = abstractModelFormBuilder;
    }

    public abstract String getId();

    @Override
    public Node init() {
        if (this.node != null) {
            return this.node;
        }

        var backBtn = new Button("Back");
        backBtn.setOnAction(event -> {
            MainScene.popNode();
        });

        var newEntityBtn = new Button("Create");
        newEntityBtn.setOnAction(event -> {
            this.showForm(this.emptyModel(), true, this.getRoot(event));
        });


        var table = this.abstractTableBuilder.build(
                (item, event) -> this.showForm(item, false, this.getRoot(event)),
                this::deleteItem
        );

        this.items = FXCollections.observableList(this.getItems());
        table.setItems(items);

        var scrollPane = new ScrollPane(table);

        var vBox = new VBox();
        vBox.getChildren().addAll(backBtn, newEntityBtn, scrollPane);

        this.node = vBox;
        return this.node;

    }

    private void showForm(VM model, boolean isNew, Window root) {
        var stage = new Stage();

        var form = this.createForm(model, isNew, stage::close);

        var baseLayer = new StackPane();
        baseLayer.getChildren().add(form);

        stage.setScene(new Scene(baseLayer, 600, 600));
        stage.setTitle("Create entity");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(root);
        stage.showAndWait();
    }

    private Node createForm(VM model, final boolean isNew, Runnable onSuccess) {
        return this.abstractModelFormBuilder.build(model, item -> {
            var result = false;
            if (isNew) {
                result = this.createItem(model);
            } else {
                result = this.update(model);
            }
            if (result) {
                onSuccess.run();
            }
        }, item -> {
            System.out.println("cancelled");
            onSuccess.run();
        });
    }

    private Window getRoot(ActionEvent event) {
        return ((Node)event.getSource()).getScene().getWindow();
    }

    private void deleteItem(VM model, int idx) {
        if (this.delete(model)) {
            this.items.remove(idx);
        }
    }

    private boolean createItem(VM model) {
        var result = this.create(model);

        var newItems = this.getItems();
        this.items.clear();
        this.items.addAll(newItems);

        return result;
    }

    protected abstract List<VM> getItems();
    protected abstract VM emptyModel();
    protected abstract boolean create(VM model);
    protected abstract boolean update(VM model);
    protected abstract boolean delete(VM model);

}
