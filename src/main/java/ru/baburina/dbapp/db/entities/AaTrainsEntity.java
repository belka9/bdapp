package ru.baburina.dbapp.db.entities;

import javax.persistence.*;

@Entity
@Table(name = "aa_trains", schema = "public", catalog = "postgres")
public class AaTrainsEntity {
    private int num;
    private int category;
    private int quantity;
    private int stationId;
    private int mNum;

    @Id
    @Column(name = "num")
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Basic
    @Column(name = "category")
    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    @Basic
    @Column(name = "quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "station_id")
    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    @Basic
    @Column(name = "m_num")
    public int getmNum() {
        return mNum;
    }

    public void setmNum(int mNum) {
        this.mNum = mNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AaTrainsEntity that = (AaTrainsEntity) o;

        if (num != that.num) return false;
        if (category != that.category) return false;
        if (quantity != that.quantity) return false;
        if (stationId != that.stationId) return false;
        if (mNum != that.mNum) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = num;
        result = 31 * result + category;
        result = 31 * result + quantity;
        result = 31 * result + stationId;
        result = 31 * result + mNum;
        return result;
    }
}
