package ru.baburina.dbapp.ui.screen.crud.marshrut;

import javafx.scene.control.TableColumn;
import ru.baburina.dbapp.ui.models.MarshrutViewModel;
import ru.baburina.dbapp.ui.screen.crud.common.AbstractCrudTableBuilder;

import java.util.Arrays;
import java.util.List;

public class MarshrutCrudTableBuilder extends AbstractCrudTableBuilder<MarshrutViewModel> {

    @Override
    protected List<TableColumn<MarshrutViewModel, ?>> getColumns() {
        return Arrays.asList(
                this.createReadonlyColumn("num", "num"),
                this.createReadonlyColumn("stationId", "stationId"),
                this.createReadonlyColumn("order", "order")
        );
    }
}
