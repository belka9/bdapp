package ru.baburina.dbapp.ui.screen.crud.timetable;
import ru.baburina.dbapp.ui.models.MarshrutViewModel;
import ru.baburina.dbapp.ui.models.TimetableViewModel;
import ru.baburina.dbapp.ui.screen.crud.common.AbstractModelFormBuilder;

import java.util.Arrays;
import java.util.List;

public class TimetableFormBuilder extends AbstractModelFormBuilder<TimetableViewModel> {
    @Override
    protected List<FieldDescriptor<TimetableViewModel, ?>> getFieldDescriptors() {
        return Arrays.asList(
                new FieldDescriptor<>("Id", "", TimetableViewModel::idProperty, FieldType.INTEGER_FIELD),
                new FieldDescriptor<>("TNum", "", TimetableViewModel::tNumProperty, FieldType.INTEGER_FIELD),
                new FieldDescriptor<>("Dt1", "", TimetableViewModel::dt1Property, FieldType.DATE_FIELD),
                new FieldDescriptor<>("Dt2", "", TimetableViewModel::dt2Property, FieldType.DATE_FIELD),
                new FieldDescriptor<>("Station Id", "", TimetableViewModel::stationIdProperty, FieldType.INTEGER_FIELD),
                new FieldDescriptor<>("Napr", "", TimetableViewModel::naprProperty, FieldType.INTEGER_FIELD),
                new FieldDescriptor<>("Tickets", "", TimetableViewModel::ticketsProperty, FieldType.INTEGER_FIELD)
        );
    }
}
