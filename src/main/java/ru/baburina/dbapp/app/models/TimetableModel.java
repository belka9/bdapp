package ru.baburina.dbapp.app.models;


import java.time.Instant;
import java.util.Date;

public class TimetableModel {
    private int id;
    private int tNum;
    private int stationId;
    private Instant dt1;
    private Instant dt2;
    private int napr;
    private int tickets;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int gettNum() {
        return tNum;
    }

    public void settNum(int tNum) {
        this.tNum = tNum;
    }

    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    public Instant getDt1() {
        return dt1;
    }

    public void setDt1(Instant dt1) {
        this.dt1 = dt1;
    }

    public Instant getDt2() {
        return dt2;
    }

    public void setDt2(Instant dt2) {
        this.dt2 = dt2;
    }

    public int getNapr() {
        return napr;
    }

    public void setNapr(int napr) {
        this.napr = napr;
    }

    public int getTickets() {
        return tickets;
    }

    public void setTickets(int tickets) {
        this.tickets = tickets;
    }
}
