package ru.baburina.dbapp.app.models;

public class StationModel {
    private int id_s;
    private String name;

    public int getId() {
        return id_s;
    }

    public void setId(int id) {
        this.id_s = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
