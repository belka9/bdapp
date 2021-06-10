package ru.baburina.dbapp.app.models;

public class WaitingsModel{
    private int id;
    private int idTimetable;
    private int tNum;
    private int stationId;
    private int value;

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTimetable() {
        return idTimetable;
    }

    public void setIdTimetable(int idTimetable) { this.idTimetable = idTimetable; }

    public int gettNum() {
        return tNum;
    }

    public void settNum(int tNum) { this.tNum = tNum; }

    public int getStationId() { return stationId; }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
