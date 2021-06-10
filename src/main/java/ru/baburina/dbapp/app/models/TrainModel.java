package ru.baburina.dbapp.app.models;

public class TrainModel {
    private int num;
    private String category;
    private int quanity;
    private int stationId;
    private int marshNum;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuanity() {
        return quanity;
    }

    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }

    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    public int getMarshNum() {
        return marshNum;
    }

    public void setMarshNum(int marshNum) {
        this.marshNum = marshNum;
    }
}
