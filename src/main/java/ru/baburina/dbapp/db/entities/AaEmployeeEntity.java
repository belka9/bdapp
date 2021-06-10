package ru.baburina.dbapp.db.entities;

import javax.persistence.*;

@Entity
@Table(name = "employee", schema = "public", catalog = "postgres")
public class AaEmployeeEntity {
    private int id;
    private String fio;
    private String place;
    private int stationId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "fio")
    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    @Basic
    @Column(name = "place")
    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Basic
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

        AaEmployeeEntity that = (AaEmployeeEntity) o;

        if (id != that.id) return false;
        if (stationId != that.stationId) return false;
        if (fio != null ? !fio.equals(that.fio) : that.fio != null) return false;
        if (place != null ? !place.equals(that.place) : that.place != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fio != null ? fio.hashCode() : 0);
        result = 31 * result + (place != null ? place.hashCode() : 0);
        result = 31 * result + stationId;
        return result;
    }
}
