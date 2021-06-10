package ru.baburina.dbapp.ui.screen.crud.station;

import ru.baburina.dbapp.ui.models.StationViewModel;
import ru.baburina.dbapp.ui.models.UserViewModel;
import ru.baburina.dbapp.ui.screen.crud.common.AbstractModelFormBuilder;

import java.util.Arrays;
import java.util.List;

public class StationFormBuilder extends AbstractModelFormBuilder<StationViewModel> {
    @Override
    protected List<FieldDescriptor<StationViewModel, ?>> getFieldDescriptors() {
        return Arrays.asList(
                new FieldDescriptor<>("Name", "Name", vm -> vm.nameProperty(), FieldType.STRING_FIELD)
        );
    }
}
