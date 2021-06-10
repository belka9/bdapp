package ru.baburina.dbapp.ui.models;

import javafx.beans.property.SimpleIntegerProperty;
import ru.baburina.dbapp.app.models.WaitingsModel;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class WaitingsViewModel{
    private final SimpleIntegerProperty id = new SimpleIntegerProperty();
    private final SimpleIntegerProperty idTimetable = new SimpleIntegerProperty();
    private final SimpleIntegerProperty tNum = new SimpleIntegerProperty();
    private final SimpleIntegerProperty stationId = new SimpleIntegerProperty();
    private final SimpleIntegerProperty value = new SimpleIntegerProperty();


    public WaitingsViewModel(WaitingsModel model) {
        this.setId(model.getId());
        this.settNum(model.gettNum());
        this.setStationId(model.getStationId());
        this.setIdTimetable(model.getIdTimetable());
        this.setValue(model.getValue());
    }

    public WaitingsViewModel() { }

    public WaitingsModel toAppModel() {
        var model = new WaitingsModel();
        model.setId(this.getId());
        model.settNum(this.gettNum());
        model.setStationId(this.getStationId());
        model.setIdTimetable(this.getIdTimetable());
        model.setValue(this.getValue());
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

    public int getIdTimetable() {
        return idTimetable.get();
    }

    public SimpleIntegerProperty idTimetableProperty() {
        return idTimetable;
    }

    public void setIdTimetable(int idTimetable) {
        this.idTimetable.set(idTimetable);
    }

    public int gettNum() {
        return tNum.get();
    }

    public SimpleIntegerProperty tNumProperty() {
        return tNum;
    }

    public void settNum(int tNum) {
        this.tNum.set(tNum);
    }

    public int getStationId() {
        return stationId.get();
    }

    public SimpleIntegerProperty stationIdProperty() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId.set(stationId);
    }

    public int getValue() {
        return value.get();
    }

    public SimpleIntegerProperty valueProperty() {
        return value;
    }

    public void setValue(int value) {
        this.value.set(value);
    }


}
