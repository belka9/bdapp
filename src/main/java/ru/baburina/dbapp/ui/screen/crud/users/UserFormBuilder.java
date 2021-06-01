package ru.baburina.dbapp.ui.screen.crud.users;

import ru.baburina.dbapp.ui.models.UserViewModel;
import ru.baburina.dbapp.ui.screen.crud.common.AbstractModelFormBuilder;

import java.util.Arrays;
import java.util.List;

public class UserFormBuilder extends AbstractModelFormBuilder<UserViewModel> {

    @Override
    protected List<FieldDescriptor<UserViewModel, ?>> getFieldDescriptors() {
        return Arrays.asList(
                new FieldDescriptor<>("Name", "Name", vm -> vm.nameProperty(), FieldType.STRING_FIELD),
                new FieldDescriptor<>("Password", "Password", vm -> vm.passwordProperty(), FieldType.STRING_FIELD)
        );
    }
}
