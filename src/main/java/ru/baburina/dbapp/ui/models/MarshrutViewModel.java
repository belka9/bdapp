package ru.baburina.dbapp.ui.models;

import javafx.beans.property.SimpleIntegerProperty;
import ru.baburina.dbapp.app.models.MarshrutModel;
import ru.baburina.dbapp.app.models.StationModel;

public class MarshrutViewModel {
    private final SimpleIntegerProperty num = new SimpleIntegerProperty();
    private final SimpleIntegerProperty  stationId = new SimpleIntegerProperty();
    private final SimpleIntegerProperty  order = new SimpleIntegerProperty();

    public MarshrutViewModel() {}

    public MarshrutViewModel(MarshrutModel model) {
        this.setNum(model.getNum());
        this.setStationId(model.getStationId());
        this.setOrder(model.getOrder());
    }

    public MarshrutModel toAppModel() {
        var model = new MarshrutModel();
        model.setNum(this.getNum());
        model.setStationId(this.getStationId());
        model.setOrder(this.getOrder());
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

    public int getStationId() {
        return stationId.get();
    }

    public SimpleIntegerProperty stationIdProperty() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId.set(stationId);
    }

    public int getOrder() {
        return order.get();
    }

    public SimpleIntegerProperty orderProperty() {
        return order;
    }

    public void setOrder(int order) {
        this.order.set(order);
    }
}
