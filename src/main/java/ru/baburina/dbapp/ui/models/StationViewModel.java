package ru.baburina.dbapp.ui.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import ru.baburina.dbapp.app.models.StationModel;

public class StationViewModel {

    private final SimpleIntegerProperty id = new SimpleIntegerProperty();
    private final SimpleStringProperty name = new SimpleStringProperty();

    public StationViewModel() {}

    public StationViewModel(StationModel model) {
        this.setId(model.getId());
        this.setName(model.getName());
    }

    public StationModel toAppModel() {
        var model = new StationModel();
        model.setId(this.getId());
        model.setName(this.getName());
        return model;
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

}

