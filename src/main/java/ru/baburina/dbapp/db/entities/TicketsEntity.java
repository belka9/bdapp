package ru.baburina.dbapp.db.entities;


import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "tickets", schema = "public", catalog = "postgres")
public class TicketsEntity {

    private int id;
    private int id_timetable;
    private Instant dt;
    private String FIO;
    private List<TimetableEntity> timetables;
    private StationEntity station1;
    private StationEntity station2;


    @ManyToMany()
    @JoinColumn(name = "id_timetable")
    public List<TimetableEntity> getTimetables() {
        return timetables;
    }

    @ManyToOne()
    @JoinColumn(name = "idSt1")
    public StationEntity getStation1() {
        return station1;
    }
    public void setStation1(StationEntity station1) {
        this.station1 = station1;
    }

    @ManyToOne()
    @JoinColumn(name = "idSt2")
    public StationEntity getStation2() {
        return station2;
    }
    public void setStation2(StationEntity station2) {
        this.station2 = station2;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "dt")
    public Instant getDt() { return dt; }
    public void setDt(Instant dt) { this.dt = dt; }

    @Basic
    @Column(name = "FIO")
    public String getFIO() { return FIO; }
    public void setFIO(String FOI) { this.FIO = FOI; }

    public int getId_timetable() { return id_timetable; }
    public void setId_timetable(int id_timetable) { this.id_timetable = id_timetable; }
    public void setTimetables(List<TimetableEntity> tt) { this.timetables = tt;
    }

}
