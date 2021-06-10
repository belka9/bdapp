package ru.baburina.dbapp.db.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;

@Embeddable
public class TimetablePKEntity implements Serializable {
    private int id;
    private int tNum;
    private int stationId;

    @Column(name = "id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "t_num")
    public int gettNum() {
        return tNum;
    }
    public void settNum(int tNum) {
        this.tNum = tNum;
    }

    @Column(name = "station_id")
    public int getStationId() {
        return stationId;
    }
    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TimetablePKEntity that = (TimetablePKEntity) o;

        if (id != that.id) return false;
        if (tNum != that.tNum) return false;
        if (stationId != that.stationId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + tNum;
        result = 31 * result + stationId;
        return result;
    }
}
