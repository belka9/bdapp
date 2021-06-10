package ru.baburina.dbapp.ui.screen.crud.train;

import javafx.scene.control.TableColumn;
import ru.baburina.dbapp.ui.models.TrainViewModel;
import ru.baburina.dbapp.ui.screen.crud.common.AbstractCrudTableBuilder;

import java.util.Arrays;
import java.util.List;

public class TrainCrudTableBuilder extends AbstractCrudTableBuilder<TrainViewModel> {

    @Override
    protected List<TableColumn<TrainViewModel, ?>> getColumns() {
        return Arrays.asList(
                this.createReadonlyColumn("Num", "num", 100),
                this.createReadonlyColumn("Category", "category", 100),
                this.createReadonlyColumn("Quantity", "quanity", 100),
                this.createReadonlyColumn("Station Id", "stationId", 100),
                this.createReadonlyColumn("Marshrut", "marshNum", 100)
        );
    }
}

