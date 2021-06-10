package ru.baburina.dbapp.db.entities;

import javax.persistence.*;

@Entity
@Table(name = "trains", schema = "public", catalog = "postgres")
public class TrainEntity {
    private int num;
    private String category;
    private int quantity;

    @ManyToOne
    @JoinColumns(value = {
            @JoinColumn(name = "m_num"),
            @JoinColumn(name = "station_id")
    })
    public MarshrutEntity getMarshrut() {
        return marshrut;
    }
    public void setMarshrut(MarshrutEntity marshrut) { this.marshrut = marshrut; }
    private MarshrutEntity marshrut;


    @Id
    @Column(name = "num")
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }

    @Basic
    @Column(name = "category")
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    @Basic
    @Column(name = "quantity")
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrainEntity that = (TrainEntity) o;

        if (num != that.num) return false;
        if (category != that.category) return false;
        if (quantity != that.quantity) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = num;
        result = 31 * result + category.hashCode();
        result = 31 * result + quantity;
        return result;
    }
}
