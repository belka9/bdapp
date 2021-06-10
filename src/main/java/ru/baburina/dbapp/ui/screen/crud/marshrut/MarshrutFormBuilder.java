package ru.baburina.dbapp.ui.screen.crud.marshrut;

import ru.baburina.dbapp.ui.models.MarshrutViewModel;
import ru.baburina.dbapp.ui.screen.crud.common.AbstractModelFormBuilder;

import java.util.Arrays;
import java.util.List;

public class MarshrutFormBuilder extends AbstractModelFormBuilder<MarshrutViewModel>{

    @Override
    protected List<FieldDescriptor<MarshrutViewModel, ?>> getFieldDescriptors() {
        return Arrays.asList(
                new FieldDescriptor<>("num", "", MarshrutViewModel::numProperty, FieldType.INTEGER_FIELD),
                new FieldDescriptor<>("stationId", "", MarshrutViewModel::stationIdProperty, FieldType.INTEGER_FIELD),
                new FieldDescriptor<>("order", "", MarshrutViewModel::orderProperty, FieldType.INTEGER_FIELD)
                );
    }
}
