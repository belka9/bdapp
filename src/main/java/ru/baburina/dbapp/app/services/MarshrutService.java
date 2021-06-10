package ru.baburina.dbapp.app.services;

import ru.baburina.dbapp.app.models.MarshrutModel;
import ru.baburina.dbapp.db.entities.MarshrutEntity;
import ru.baburina.dbapp.db.entities.MarshrutPKEntity;
import ru.baburina.dbapp.db.repository.MarshrutRepository;

import java.util.Collection;

public class MarshrutService extends AbstractEntityService<MarshrutModel, MarshrutEntity>{

    @Override
    protected MarshrutModel mapToModel(MarshrutEntity entity) {
        var model = new MarshrutModel();
        model.setNum(entity.getMarshrutPk().getNum());
        model.setStationId(entity.getStation().getId());
        model.setOrder(entity.getOrder());
        return model;
    }

    @Override
    protected MarshrutEntity mapToEntity(MarshrutModel model) {
        var entity = new MarshrutEntity();
        var pk = new MarshrutPKEntity();
        pk.setStationId(model.getStationId());
        pk.setNum(model.getNum());
        entity.setMarshrutPk(pk);
        entity.setOrder(model.getOrder());
        return entity;
    }

    public MarshrutService() { super(new MarshrutRepository()); }

    public Collection<MarshrutModel> getMarshrut() {
        return this.getEntities();
    }

    public void createMarshrut(MarshrutModel marshrut) {
        this.createEntity(marshrut);
    }

    public void updateMarshrut(MarshrutModel marshrut) {
        this.updateEntity(marshrut);
    }

    public void deleteMarshrut(MarshrutModel marshrut) {
        this.deleteEntity(marshrut);
    }
}
