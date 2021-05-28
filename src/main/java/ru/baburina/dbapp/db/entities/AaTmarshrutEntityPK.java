package ru.baburina.dbapp.db.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class AaTmarshrutEntityPK implements Serializable {
    private int mNum;
    private int stationId;
    private int pmNum;

    @Column(name = "m_num")
    @Id
    public int getmNum() {
        return mNum;
    }

    public void setmNum(int mNum) {
        this.mNum = mNum;
    }

    @Column(name = "station_id")
    @Id
    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    @Column(name = "pm_num")
    @Id
    public int getPmNum() {
        return pmNum;
    }

    public void setPmNum(int pmNum) {
        this.pmNum = pmNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AaTmarshrutEntityPK that = (AaTmarshrutEntityPK) o;

        if (mNum != that.mNum) return false;
        if (stationId != that.stationId) return false;
        if (pmNum != that.pmNum) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mNum;
        result = 31 * result + stationId;
        result = 31 * result + pmNum;
        return result;
    }
}
