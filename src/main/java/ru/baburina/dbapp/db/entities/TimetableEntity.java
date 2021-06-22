package ru.baburina.dbapp.db.entities;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "timetable", schema = "public", catalog = "postgres")
public class TimetableEntity {

    private TimetablePKEntity pkEntity;
    private TrainEntity train;
    private StationEntity station;

    private Instant dt1;
    private Instant dt2;
    private int napr;
    private int tickets;

    @EmbeddedId
    public TimetablePKEntity getPkEntity() {
        return pkEntity;
    }
    public void setPkEntity(TimetablePKEntity pkEntity) {
        this.pkEntity = pkEntity;
    }

    @MapsId("t_num")
    @ManyToOne()
    @JoinColumn(name = "t_num")
    public TrainEntity getTrain() {
        return train;
    }
    public void setTrain(TrainEntity train) {
        this.train = train;
    }

    @MapsId("station_id")
    @ManyToOne()
    @JoinColumn(name = "station_id")
    public StationEntity getStation() {
        return station;
    }
    public void setStation(StationEntity station) {
        this.station = station;
    }


    @Basic
    @Column(name = "dt1")
    public Instant getDt1() {
        return dt1;
    }
    public void setDt1(Instant dt1) {
        this.dt1 = dt1;
    }

    @Basic
    @Column(name = "dt2")
    public Instant getDt2() {
        return dt2;
    }
    public void setDt2(Instant dt2) {
        this.dt2 = dt2;
    }

    @Basic
    @Column(name = "napr")
    public int getNapr() {
        return napr;
    }
    public void setNapr(int napr) {
        this.napr = napr;
    }

    @Basic
    @Column(name = "tickets")
    public int getTickets() {
        return tickets;
    }
    public void setTickets(int tickets) {
        this.tickets = tickets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimetableEntity that = (TimetableEntity) o;
        return napr == that.napr && tickets == that.tickets && pkEntity.equals(that.pkEntity) && train.equals(that.train) && station.equals(that.station) && dt1.equals(that.dt1) && dt2.equals(that.dt2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pkEntity, train, station, dt1, dt2, napr, tickets);
    }
}
