package ru.baburina.dbapp.db.entities;

import javax.persistence.*;

@Entity
@Table(name = "waitings", schema = "public", catalog = "postgres")
public class WaitingsEntity {
    private int value;
    private int id;
    private TimetableEntity timetable;



    @ManyToOne
    @JoinColumns(value = {
            @JoinColumn(name = "idTimetable"),
            @JoinColumn(name = "tNum"),
            @JoinColumn(name = "stationId")
    })
    public TimetableEntity getTimetable() { return timetable; }
    public void setTimetable(TimetableEntity timetable) { this.timetable = timetable; }

    @Basic
    @Column(name = "value")
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WaitingsEntity that = (WaitingsEntity) o;
        if (value != that.value) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = Math.toIntExact(id);
        result = 31 * result + value;
        return result;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
}
