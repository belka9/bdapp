package ru.baburina.dbapp.ui.screen.crud.common;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import ru.baburina.dbapp.ui.api.AppScreen;

import java.util.List;

public abstract class AbstractCrudScreen<VM> implements AppScreen {

    private final AbstractCrudTableBuilder<VM> abstractTableBuilder;

    private Node node;
    private ObservableList<VM> items;

    public AbstractCrudScreen(AbstractCrudTableBuilder<VM> abstractTableBuilder) {
        this.abstractTableBuilder = abstractTableBuilder;
    }

    public abstract String getId();

    @Override
    public Node init() {
        if (this.node != null) {
            return this.node;
        }
        var table = this.abstractTableBuilder.build(
                (item, idx) -> System.out.println("On edit cliecked" + idx),
                (item, idx) -> System.out.println("On delete clicked" + idx)
        );

        this.items = FXCollections.observableList(this.getItems());
        table.setItems(items);

        this.node = table;
        return this.node;

    }

    protected abstract List<VM> getItems();

}
