package ru.baburina.dbapp.ui.screen.crud.common;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Pagination;
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
    private Pagination pagination;

    public AbstractCrudScreen(AbstractCrudTableBuilder<VM> abstractTableBuilder, AbstractModelFormBuilder<VM> abstractModelFormBuilder) {
        this.abstractTableBuilder = abstractTableBuilder;
        this.abstractModelFormBuilder = abstractModelFormBuilder;
    }

    public abstract String getId();

    private final int itemsPerPage = 10;
    private int totalItems = 0;

    @Override
    public Node init() {
        if (this.node != null) {//собирает и строит экран
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

        this.totalItems = this.getTotalCount();
        this.pagination = new Pagination(this.getPageCounts());
        pagination.setPageFactory(page -> {
            var pageItems = this.getItems(page + 1, this.itemsPerPage);
            var table = this.abstractTableBuilder.build(
                    (item, event) -> this.showForm(item, false, this.getRoot(event)),
                    this::deleteItem
            );

            this.items = FXCollections.observableList(pageItems);
            table.setItems(this.items);

            return new ScrollPane(table);
        });

        var vBox = new VBox();
        vBox.getChildren().addAll(backBtn, newEntityBtn, this.pagination);
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
            this.totalItems--;
            this.pagination.setPageCount(this.getPageCounts());
            var page = this.pagination.getCurrentPageIndex() >= this.getPageCounts() ? this.pagination.getCurrentPageIndex() - 1 : this.pagination.getCurrentPageIndex();
            page = Math.max(page, 0);
            this.pagination.setCurrentPageIndex(page);
        }
    }

    private boolean createItem(VM model) {
        var result = this.create(model);
        if (result) {
            this.totalItems++;
            this.pagination.setPageCount(this.getPageCounts());
            this.pagination.setCurrentPageIndex(this.pagination.getCurrentPageIndex());
        }
        return result;
    }

    private int getPageCounts() {
        if (this.totalItems == 0) {
            return 0;
        }
        return this.totalItems / this.itemsPerPage + (this.totalItems%this.itemsPerPage != 0 ? 1 : 0);
    }

    protected abstract int getTotalCount();
    protected abstract List<VM> getItems(int page, int pageSize);
    protected abstract VM emptyModel();
    protected abstract boolean create(VM model);
    protected abstract boolean update(VM model);
    protected abstract boolean delete(VM model);

}
