package ru.baburina.dbapp.ui.screen.crud.station;

import javafx.scene.control.TableColumn;
import ru.baburina.dbapp.ui.models.StationViewModel;
import ru.baburina.dbapp.ui.screen.crud.common.AbstractCrudTableBuilder;

import java.util.Arrays;
import java.util.List;

public class StationTableBuilder extends AbstractCrudTableBuilder<StationViewModel> {
    @Override
    protected List<TableColumn<StationViewModel, ?>> getColumns() {
        var idColumn = this.<Integer>createReadonlyColumn("Id", "id", 100);
        idColumn.setEditable(false);
        var nameColumn = this.<String>createReadonlyColumn("Name", "name", 100);

        return Arrays.asList(idColumn, nameColumn);
    }
}
