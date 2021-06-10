package ru.baburina.dbapp.db.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "marshrut", schema = "public", catalog = "postgres")
public class MarshrutEntity {

    private MarshrutPKEntity marshrutPk;
    private int order;
    private StationEntity station;

    @MapsId("station_id")
    @ManyToOne
    @JoinColumn(name = "station_id")
    public StationEntity getStation() {
        return station;
    }
    public void setStation(StationEntity station) {
        this.station = station;
    }

    @Basic
    @Column(name = "order1")
    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
    @EmbeddedId
    public MarshrutPKEntity getMarshrutPk() {
        return marshrutPk;
    }

    public void setMarshrutPk(MarshrutPKEntity marshrutPk) {
        this.marshrutPk = marshrutPk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarshrutEntity that = (MarshrutEntity) o;
        return order == that.order && Objects.equals(marshrutPk, that.marshrutPk) && Objects.equals(station, that.station);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marshrutPk, order, station);
    }

}
