package ru.baburina.dbapp.db.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MarshrutPKEntity implements Serializable {
    private int num;
    private int stationId;

    @Column(name = "num")
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
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
        MarshrutPKEntity that = (MarshrutPKEntity) o;
        return num == that.num && stationId == that.stationId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, stationId);
    }
}
