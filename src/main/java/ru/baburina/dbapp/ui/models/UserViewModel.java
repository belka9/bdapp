package ru.baburina.dbapp.ui.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import ru.baburina.dbapp.app.models.UserModel;

public class UserViewModel {

    private final SimpleIntegerProperty id = new SimpleIntegerProperty();
    private final SimpleStringProperty name = new SimpleStringProperty();
    private final SimpleStringProperty password = new SimpleStringProperty();

    public UserViewModel() {}

    public UserViewModel(UserModel model) {
        this.setId(model.getId());
        this.setName(model.getName());
        this.setPassword(model.getPassword());
    }

    public UserModel toAppModel() {
        var model = new UserModel();
        model.setId(this.getId());
        model.setName(this.getName());
        model.setPassword(this.getPassword());
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

    public String getPassword() {
        return password.get();
    }

    public SimpleStringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }
}
