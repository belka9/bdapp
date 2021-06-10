package ru.baburina.dbapp.app.services;

import ru.baburina.dbapp.app.models.StationModel;
import ru.baburina.dbapp.db.api.Repository;
import ru.baburina.dbapp.db.entities.StationEntity;

import java.util.Collection;

public class StationService extends AbstractEntityService<StationModel, StationEntity>{

    public StationService(Repository<StationEntity, ?> repository) {
        super(repository);
    }

    @Override
    protected StationModel mapToModel(StationEntity entity) {
        var model = new StationModel();
        model.setId(entity.getId());
        model.setName(entity.getName());
        return model;
    }

    @Override
    protected StationEntity mapToEntity(StationModel model) {
        var entity = new StationEntity();
        entity.setId(model.getId());
        entity.setName(model.getName());
        return entity;
    }

    public Collection<StationModel> getStation() {
        return this.getEntities();
    }

    public void createStation(StationModel station) {
        this.createEntity(station);
    }

    public void updateStation(StationModel station) {
        this.updateEntity(station);
    }

    public void deleteStation(StationModel station) {
        this.deleteEntity(station);
    }
}
