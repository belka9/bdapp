package ru.baburina.dbapp.ui.screen.crud.common;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.converter.DateStringConverter;
import javafx.util.converter.NumberStringConverter;

import java.util.Date;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public abstract class AbstractModelFormBuilder<VM> {

    public Node build(VM model, Consumer<VM> onUpdate, Consumer<VM> onCancel) {
        var updateBtn = new Button("Update");
        updateBtn.setOnAction(event -> onUpdate.accept(model));

        var deleteBtn = new Button("Cancel");
        deleteBtn.setOnAction(event -> onCancel.accept(model));

        var vBoxFields = new VBox();
        vBoxFields.getChildren().addAll(this.createFields(model, this.getFieldDescriptors()));

        var vBoxButtons = new VBox();
        vBoxButtons.getChildren().addAll(updateBtn, deleteBtn);

        var hBox = new HBox();
        hBox.getChildren().addAll(vBoxFields, vBoxButtons);

        return hBox;
    }

    protected abstract List<FieldDescriptor<VM, ?>> getFieldDescriptors();

    private List<Node> createFields(final VM model, List<FieldDescriptor<VM, ?>> descriptors) {
        return descriptors.stream().map(d -> {
            var label = new Label(d.label);
            var field = this.createField(model, d);

            var hbox = new HBox();
            hbox.getChildren().addAll(label, field);

            return hbox;
        }).collect(Collectors.toList());
    }

    private Node createField(final VM model, FieldDescriptor<VM, ?> descriptor) {
        switch (descriptor.fieldType) {
            case STRING_FIELD:
                return this.createStringField(descriptor.placeholder, () -> (StringProperty) descriptor.getter.apply(model));
            case INTEGER_FIELD:
                return this.createIntegerField(descriptor.placeholder, () -> (IntegerProperty) descriptor.getter.apply(model));
            case NUMBER_FIELD:
                return this.createNumberField(descriptor.placeholder, () -> (DoubleProperty) descriptor.getter.apply(model));
            case DATE_FIELD:
                return this.createDateField(descriptor.placeholder, () -> (ObjectProperty<Date>) descriptor.getter.apply(model));
            default:
                throw new RuntimeException("not supported");
        }
    }

    private Node createStringField(String placeholder, Supplier<StringProperty> getter) {
        var textField = new TextField();
        if (placeholder != null) {
            textField.setPromptText(placeholder);
        }
        textField.textProperty().bindBidirectional(getter.get());
        return textField;
    }

    private Node createIntegerField(String placeholder, Supplier<IntegerProperty> getter) {
        var textField = new TextField();
        if (placeholder != null) {
            textField.setPromptText(placeholder);
        }
        textField.setTextFormatter(new TextFormatter<>(new NumberStringConverter()));
        textField.textProperty().bindBidirectional(getter.get(), new NumberStringConverter());
        return textField;
    }

    private Node createNumberField(String placeholder, Supplier<DoubleProperty> getter) {
        var textField = new TextField();
        if (placeholder != null) {
            textField.setPromptText(placeholder);
        }
        textField.setTextFormatter(new TextFormatter<>(new NumberStringConverter()));
        textField.textProperty().bindBidirectional(getter.get(), new NumberStringConverter());
        return textField;
    }

    private Node createDateField(String placeholder, Supplier<ObjectProperty<Date>> getter) {
        var textField = new TextField();
        if (placeholder != null) {
            textField.setPromptText(placeholder);
        }
        textField.setTextFormatter(new TextFormatter<>(new DateStringConverter()));
        textField.textProperty().bindBidirectional(getter.get(), new DateStringConverter());
        return textField;
    }



    protected static class FieldDescriptor<VM, P> {
        private final String label;
        private final String placeholder;
        private final Function<VM, P> getter;
        private final FieldType fieldType;

        public FieldDescriptor(String label, String placeholder, Function<VM, P> getter, FieldType fieldType) {
            this.label = label;
            this.placeholder = placeholder;
            this.getter = getter;
            this.fieldType = fieldType;
        }
    }

    protected enum FieldType {
        STRING_FIELD,
        INTEGER_FIELD,
        NUMBER_FIELD,
        DATE_FIELD
    }
}
