package ru.baburina.dbapp.ui.screen.crud.common;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

public abstract class AbstractCrudTableBuilder<T> {

    protected abstract List<TableColumn<T, ?>> getColumns();

    public TableView<T> build(BiConsumer<T, ActionEvent> onEdit, BiConsumer<T, Integer> onDelete) {
        var table = new TableView<T>();
        table.setEditable(true);

        table.getColumns().addAll(this.getColumns());

        table.getColumns().addAll(Arrays.asList(
                this.createActionColumn("Edit", (i, e, idx) -> onEdit.accept(i, e)),
                this.createActionColumn("Delete", (i, e, idx) -> onDelete.accept(i, idx))));

        return table;

    }

    protected <V> TableColumn<T, V> createReadonlyColumn(String columnName, String propertyName, double minWidth) {
        var column = new TableColumn<T, V>(columnName);
        column.setMinWidth(minWidth);
        column.setCellValueFactory(new PropertyValueFactory<>(propertyName));
        column.setEditable(false);
        return column;
    }

    private TableColumn<T, Void> createActionColumn(String buttonName, TriConsumer<T, ActionEvent, Integer> onClick) {
        var column = new TableColumn<T, Void>();
        column.setCellFactory(c -> new TableCell<T, Void>() {
            private final Button btn = new Button(buttonName);
            {
                btn.setOnAction(event -> {
                    var idx = getIndex();
                    var item = getTableView().getItems().get(idx);
                    onClick.accept(item, event, idx);
                });
            }
            @Override
            public void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(btn);
                }
            }
        });
        return column;
    }

    private interface TriConsumer<T, R, V> {
        void accept(T t, R r, V v);
    }
}
