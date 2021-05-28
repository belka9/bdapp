package ru.baburina.dbapp.db.entities;

import javax.persistence.*;

@Entity
@Table(name = "aa_tmarshrut", schema = "public", catalog = "postgres")
@IdClass(AaTmarshrutEntityPK.class)
public class AaTmarshrutEntity {
    private int mNum;
    private int stationId;
    private int order1;
    private int pmNum;

    @Id
    @Column(name = "m_num")
    public int getmNum() {
        return mNum;
    }

    public void setmNum(int mNum) {
        this.mNum = mNum;
    }

    @Id
    @Column(name = "station_id")
    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    @Basic
    @Column(name = "order1")
    public int getOrder1() {
        return order1;
    }

    public void setOrder1(int order1) {
        this.order1 = order1;
    }

    @Id
    @Column(name = "pm_num")
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

        AaTmarshrutEntity that = (AaTmarshrutEntity) o;

        if (mNum != that.mNum) return false;
        if (stationId != that.stationId) return false;
        if (order1 != that.order1) return false;
        if (pmNum != that.pmNum) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mNum;
        result = 31 * result + stationId;
        result = 31 * result + order1;
        result = 31 * result + pmNum;
        return result;
    }
}
