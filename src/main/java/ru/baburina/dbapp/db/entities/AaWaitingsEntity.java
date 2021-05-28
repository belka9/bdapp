package ru.baburina.dbapp.db.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "aa_waitings", schema = "public", catalog = "postgres")
public class AaWaitingsEntity {
    private int id;
    private int category;
    private Date dt;
    private int napr;
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
    @Column(name = "category")
    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    @Basic
    @Column(name = "dt")
    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        this.dt = dt;
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

        AaWaitingsEntity that = (AaWaitingsEntity) o;

        if (id != that.id) return false;
        if (category != that.category) return false;
        if (napr != that.napr) return false;
        if (value != that.value) return false;
        if (dt != null ? !dt.equals(that.dt) : that.dt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + category;
        result = 31 * result + (dt != null ? dt.hashCode() : 0);
        result = 31 * result + napr;
        result = 31 * result + value;
        return result;
    }
}
