package ru.baburina.dbapp.app.models;

import java.time.Instant;

public class TicketsCreateModel {
    private int id_timetable;
    private int st1;
    private int st2;
    private String fio;

    public int getId_timetable() {
        return id_timetable;
    }

    public void setId_timetable(int id_timetable) {
        this.id_timetable = id_timetable;
    }

    public int getSt1() {
        return st1;
    }

    public void setSt1(int st1) {
        this.st1 = st1;
    }

    public int getSt2() {
        return st2;
    }

    public void setSt2(int st2) {
        this.st2 = st2;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }
}
