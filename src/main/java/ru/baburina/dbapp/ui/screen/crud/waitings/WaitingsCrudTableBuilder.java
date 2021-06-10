package ru.baburina.dbapp.ui.screen.crud.waitings;

import javafx.scene.control.TableColumn;
import ru.baburina.dbapp.ui.models.TimetableViewModel;
import ru.baburina.dbapp.ui.models.WaitingsViewModel;
import ru.baburina.dbapp.ui.screen.crud.common.AbstractCrudTableBuilder;

import java.util.Arrays;
import java.util.List;

public class WaitingsCrudTableBuilder extends AbstractCrudTableBuilder<WaitingsViewModel> {
    @Override
    protected List<TableColumn<WaitingsViewModel, ?>> getColumns() {
        return Arrays.asList(
                this.createReadonlyColumn("Id", "id", 100),
                this.createReadonlyColumn("Id Timetable", "idTimetable", 100),
                this.createReadonlyColumn("Station Id", "stationId", 100),
                this.createReadonlyColumn("T Num", "tNum", 100),
                this.createReadonlyColumn("Value", "value", 100)
        );
    }
}
