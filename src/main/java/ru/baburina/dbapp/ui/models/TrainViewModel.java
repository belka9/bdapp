package ru.baburina.dbapp.ui.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import ru.baburina.dbapp.app.models.TrainModel;
import ru.baburina.dbapp.app.models.UserModel;

public class TrainViewModel {

    private final SimpleIntegerProperty num = new SimpleIntegerProperty();
    private final SimpleStringProperty category = new SimpleStringProperty();
    private final SimpleIntegerProperty quanity = new SimpleIntegerProperty();
    private final SimpleIntegerProperty stationId = new SimpleIntegerProperty();
    private final SimpleIntegerProperty marshNum = new SimpleIntegerProperty();

    public TrainViewModel() {
    }

    public TrainViewModel(TrainModel model) {
        this.setNum(model.getNum());
        this.setCategory(model.getCategory());
        this.setQuanity(model.getQuanity());
        this.setStationId(model.getStationId());
        this.setMarshNum(model.getMarshNum());
    }

    public TrainModel toAppModel() {
        var model = new TrainModel();
        model.setNum(this.getNum());
        model.setCategory(this.getCategory());
        model.setQuanity(this.getQuanity());
        model.setStationId(this.getStationId());
        model.setMarshNum(this.getMarshNum());
        return model;
    }

    public int getNum() {
        return num.get();
    }

    public SimpleIntegerProperty numProperty() {
        return num;
    }

    public void setNum(int num) {
        this.num.set(num);
    }

    public String getCategory() {
        return category.get();
    }

    public SimpleStringProperty categoryProperty() {
        return category;
    }

    public void setCategory(String category) {
        this.category.set(category);
    }

    public int getQuanity() {
        return quanity.get();
    }

    public SimpleIntegerProperty quanityProperty() {
        return quanity;
    }

    public void setQuanity(int quanity) {
        this.quanity.set(quanity);
    }

    public int getStationId() {
        return stationId.get();
    }

    public SimpleIntegerProperty stationIdProperty() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId.set(stationId);
    }

    public int getMarshNum() {
        return marshNum.get();
    }

    public SimpleIntegerProperty marshNumProperty() {
        return marshNum;
    }

    public void setMarshNum(int marshNum) {
        this.marshNum.set(marshNum);
    }
}
