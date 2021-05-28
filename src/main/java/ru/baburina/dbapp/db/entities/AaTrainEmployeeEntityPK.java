package ru.baburina.dbapp.db.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class AaTrainEmployeeEntityPK implements Serializable {
    private int num;
    private int id;

    @Column(name = "num")
    @Id
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Column(name = "id")
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AaTrainEmployeeEntityPK that = (AaTrainEmployeeEntityPK) o;

        if (num != that.num) return false;
        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = num;
        result = 31 * result + id;
        return result;
    }
}
