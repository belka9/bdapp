package ru.baburina.dbapp.db.entities;

import javax.persistence.*;

@Entity
@Table(name = "aa_marshrut", schema = "public", catalog = "postgres")
@IdClass(AaMarshrutEntityPK.class)
public class AaMarshrutEntity {
    private int mNum;
    private int stationId;
    private int order1;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AaMarshrutEntity that = (AaMarshrutEntity) o;

        if (mNum != that.mNum) return false;
        if (stationId != that.stationId) return false;
        if (order1 != that.order1) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mNum;
        result = 31 * result + stationId;
        result = 31 * result + order1;
        return result;
    }
}
