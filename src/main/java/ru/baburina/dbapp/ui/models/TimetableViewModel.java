package ru.baburina.dbapp.ui.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import ru.baburina.dbapp.app.models.TimetableModel;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;


public class TimetableViewModel {
    private final SimpleIntegerProperty id = new SimpleIntegerProperty();
    private final SimpleIntegerProperty tNum = new SimpleIntegerProperty();
    private final SimpleIntegerProperty stationId = new SimpleIntegerProperty();
    private final SimpleObjectProperty<LocalDateTime> dt1 = new SimpleObjectProperty<>();
    private final SimpleObjectProperty<LocalDateTime> dt2 = new SimpleObjectProperty<>();
    private final SimpleIntegerProperty napr = new SimpleIntegerProperty();
    private final SimpleIntegerProperty tickets = new SimpleIntegerProperty();

    public TimetableViewModel(TimetableModel model) {
        this.setId(model.getId());
        this.settNum(model.gettNum());
        this.setStationId(model.getStationId());
        this.setDt1(LocalDateTime.ofInstant(model.getDt1(), ZoneId.systemDefault()));
        this.setDt2(LocalDateTime.ofInstant(model.getDt2(), ZoneId.systemDefault()));
        this.setNapr(model.getNapr());
        this.setTickets(model.getTickets());
    }

    public TimetableModel toAppModel() {
        var model = new TimetableModel();
        model.setId(this.getId());
        model.settNum(this.gettNum());
        model.setStationId(this.getStationId());
        model.setDt1(this.getDt1().toInstant(ZoneOffset.UTC));
        model.setDt2(this.getDt2().toInstant(ZoneOffset.UTC));
        model.setNapr(this.getNapr());
        model.setTickets(this.getTickets());
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

    public void setDt1(LocalDateTime dt1) {
        this.dt1.set(dt1);
    }

    public LocalDateTime getDt1() {
        return dt1.get();
    }

    public SimpleObjectProperty<LocalDateTime> dt1Property() {
        return dt1;
    }

    public LocalDateTime getDt2() {
        return dt2.get();
    }

    public SimpleObjectProperty<LocalDateTime> dt2Property() {
        return dt2;
    }

    public void setDt2(LocalDateTime dt2) {
        this.dt2.set(dt2);
    }

    public int getNapr() {
        return napr.get();
    }

    public SimpleIntegerProperty naprProperty() {
        return napr;
    }

    public void setNapr(int napr) {
        this.napr.set(napr);
    }

    public int getTickets() {
        return tickets.get();
    }

    public SimpleIntegerProperty ticketsProperty() {
        return tickets;
    }

    public void setTickets(int tickets) {
        this.tickets.set(tickets);
    }

    public TimetableViewModel() {
    }

}
