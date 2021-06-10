package ru.baburina.dbapp.ui.screen.crud.timetable;

import javafx.scene.control.TableColumn;
import ru.baburina.dbapp.ui.models.TimetableViewModel;
import ru.baburina.dbapp.ui.screen.crud.common.AbstractCrudTableBuilder;

import java.util.Arrays;
import java.util.List;

public class TimetableCrudTableBuilder extends AbstractCrudTableBuilder<TimetableViewModel> {
    @Override
    protected List<TableColumn<TimetableViewModel, ?>> getColumns() {
        return Arrays.asList(
                this.createReadonlyColumn("Id", "id", 100),
                this.createReadonlyColumn("TNum", "tNum", 100),
                this.createReadonlyColumn("Station Id", "stationId", 100),
                this.createReadonlyColumn("Dt 1", "dt1", 100),
                this.createReadonlyColumn("Dt 2", "dt2", 100),
                this.createReadonlyColumn("Napr", "napr", 100),
                this.createReadonlyColumn("Tickets", "tickets", 100)
        );
    }
}
