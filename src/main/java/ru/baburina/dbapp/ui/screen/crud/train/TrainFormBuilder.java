package ru.baburina.dbapp.ui.screen.crud.train;

import ru.baburina.dbapp.ui.models.TrainViewModel;
import ru.baburina.dbapp.ui.screen.crud.common.AbstractModelFormBuilder;

import java.util.Arrays;
import java.util.List;

public class TrainFormBuilder extends AbstractModelFormBuilder<TrainViewModel> {

    @Override
    protected List<FieldDescriptor<TrainViewModel, ?>> getFieldDescriptors() {
        return Arrays.asList(
                new FieldDescriptor<>("Number", "", TrainViewModel::numProperty, FieldType.INTEGER_FIELD),
                new FieldDescriptor<>("Category", "", TrainViewModel::categoryProperty, FieldType.STRING_FIELD),
                new FieldDescriptor<>("Quantity", "", TrainViewModel::quanityProperty, FieldType.INTEGER_FIELD),
                new FieldDescriptor<>("Station Id", "", TrainViewModel::stationIdProperty, FieldType.INTEGER_FIELD),
                new FieldDescriptor<>("Marshrut #", "", TrainViewModel::marshNumProperty, FieldType.INTEGER_FIELD)
        );
    }
}
