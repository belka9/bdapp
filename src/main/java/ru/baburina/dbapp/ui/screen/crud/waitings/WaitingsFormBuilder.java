package ru.baburina.dbapp.ui.screen.crud.waitings;

import ru.baburina.dbapp.ui.models.TimetableViewModel;
import ru.baburina.dbapp.ui.models.WaitingsViewModel;
import ru.baburina.dbapp.ui.screen.crud.common.AbstractModelFormBuilder;

import java.util.Arrays;
import java.util.List;

public class WaitingsFormBuilder extends AbstractModelFormBuilder<WaitingsViewModel> {
    @Override
    protected List<FieldDescriptor<WaitingsViewModel, ?>> getFieldDescriptors() {
        return Arrays.asList(
                new FieldDescriptor<>("Id", "", WaitingsViewModel::idProperty, FieldType.INTEGER_FIELD),
                new FieldDescriptor<>("IdTimetable", "", WaitingsViewModel::idTimetableProperty, FieldType.INTEGER_FIELD),
                new FieldDescriptor<>("Station Id", "", WaitingsViewModel::stationIdProperty, FieldType.INTEGER_FIELD),
                new FieldDescriptor<>("T Num", "", WaitingsViewModel::tNumProperty, FieldType.INTEGER_FIELD),
                new FieldDescriptor<>("Value", "", WaitingsViewModel::valueProperty, FieldType.INTEGER_FIELD)
        );
    }
}
