package ru.baburina.dbapp.db.entities;

import javax.persistence.*;

@Entity
@Table(name = "aa_distance", schema = "public", catalog = "postgres")
public class AaDistanceEntity {
    private int id;
    private int idSt1;
    private int idSt2;
    private int value;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_st1")
    public int getIdSt1() {
        return idSt1;
    }

    public void setIdSt1(int idSt1) {
        this.idSt1 = idSt1;
    }

    @Basic
    @Column(name = "id_st2")
    public int getIdSt2() {
        return idSt2;
    }

    public void setIdSt2(int idSt2) {
        this.idSt2 = idSt2;
    }

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

        AaDistanceEntity that = (AaDistanceEntity) o;

        if (id != that.id) return false;
        if (idSt1 != that.idSt1) return false;
        if (idSt2 != that.idSt2) return false;
        if (value != that.value) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idSt1;
        result = 31 * result + idSt2;
        result = 31 * result + value;
        return result;
    }
}
