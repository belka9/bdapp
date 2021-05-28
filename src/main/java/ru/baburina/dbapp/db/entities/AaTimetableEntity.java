package ru.baburina.dbapp.db.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "aa_timetable", schema = "public", catalog = "postgres")
@IdClass(AaTimetableEntityPK.class)
public class AaTimetableEntity {
    private int id;
    private int tNum;
    private int stationId;
    private Date dt1;
    private Date dt2;
    private int napr;
    private int tickets;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    @Column(name = "t_num")
    public int gettNum() {
        return tNum;
    }

    public void settNum(int tNum) {
        this.tNum = tNum;
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
    @Column(name = "dt1")
    public Date getDt1() {
        return dt1;
    }

    public void setDt1(Date dt1) {
        this.dt1 = dt1;
    }

    @Basic
    @Column(name = "dt2")
    public Date getDt2() {
        return dt2;
    }

    public void setDt2(Date dt2) {
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

        AaTimetableEntity that = (AaTimetableEntity) o;

        if (id != that.id) return false;
        if (tNum != that.tNum) return false;
        if (stationId != that.stationId) return false;
        if (napr != that.napr) return false;
        if (tickets != that.tickets) return false;
        if (dt1 != null ? !dt1.equals(that.dt1) : that.dt1 != null) return false;
        if (dt2 != null ? !dt2.equals(that.dt2) : that.dt2 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + tNum;
        result = 31 * result + stationId;
        result = 31 * result + (dt1 != null ? dt1.hashCode() : 0);
        result = 31 * result + (dt2 != null ? dt2.hashCode() : 0);
        result = 31 * result + napr;
        result = 31 * result + tickets;
        return result;
    }
}
