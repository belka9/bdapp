package ru.baburina.dbapp.ui.screen.crud.users;

import javafx.scene.control.TableColumn;
import ru.baburina.dbapp.ui.models.UserViewModel;
import ru.baburina.dbapp.ui.screen.crud.common.AbstractCrudTableBuilder;

import java.util.Arrays;
import java.util.List;

public class UsersTableBuilder extends AbstractCrudTableBuilder<UserViewModel> {

    @Override
    protected List<TableColumn<UserViewModel, ?>> getColumns() {
        var idColumn = this.<Integer>createReadonlyColumn("Id", "id", 100);
        idColumn.setEditable(false);
        var nameColumn = this.<String>createReadonlyColumn("Name", "name", 100);
        var passwordColumn = this.<String>createReadonlyColumn("Password", "password", 100);

        return Arrays.asList(idColumn, nameColumn, passwordColumn);
    }
}

