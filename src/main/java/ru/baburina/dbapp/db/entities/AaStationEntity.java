package ru.baburina.dbapp.db.entities;

import javax.persistence.*;

@Entity
@Table(name = "aa_station", schema = "public", catalog = "postgres")
public class AaStationEntity {
    private int idS;
    private String name;

    @Id
    @Column(name = "id_s")
    public int getIdS() {
        return idS;
    }

    public void setIdS(int idS) {
        this.idS = idS;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AaStationEntity that = (AaStationEntity) o;

        if (idS != that.idS) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idS;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
