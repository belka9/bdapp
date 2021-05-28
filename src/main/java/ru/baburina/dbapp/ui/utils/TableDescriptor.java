package ru.baburina.dbapp.ui.utils;

import javafx.beans.property.SimpleStringProperty;

import java.util.List;

public class TableDescriptor<T> {

    private final Class<T> clazz;


    public TableDescriptor(Class<T> clazz) {
        this.clazz = clazz;
    }


}
