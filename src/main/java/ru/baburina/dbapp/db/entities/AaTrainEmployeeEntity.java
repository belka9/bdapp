package ru.baburina.dbapp.db.entities;

import javax.persistence.*;

@Entity
@Table(name = "train_employee", schema = "public", catalog = "postgres")
@IdClass(AaTrainEmployeeEntityPK.class)
public class AaTrainEmployeeEntity {
    private int num;
    private int id;

    @Id
    @Column(name = "num")
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Id
    @Column(name = "id")
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

        AaTrainEmployeeEntity that = (AaTrainEmployeeEntity) o;

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
