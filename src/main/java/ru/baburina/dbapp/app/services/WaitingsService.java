package ru.baburina.dbapp.app.services;

import ru.baburina.dbapp.app.models.WaitingsModel;
import ru.baburina.dbapp.db.api.Repository;
import ru.baburina.dbapp.db.entities.*;
import ru.baburina.dbapp.db.repository.WaitingsRepository;

import java.util.Collection;

public class WaitingsService extends AbstractEntityService<WaitingsModel, WaitingsEntity>{

    public WaitingsService(Repository<WaitingsEntity, ?> repository) {

        super(repository);
    }

    @Override
    protected WaitingsModel mapToModel(WaitingsEntity entity) {
        var model = new WaitingsModel();
        model.setId(entity.getId());
        model.setStationId(entity.getTimetable().getPkEntity().getStationId());
        model.settNum(entity.getTimetable().getPkEntity().gettNum());
        model.setValue(entity.getValue());
        model.setIdTimetable(entity.getTimetable().getPkEntity().getId());
        return model;
    }

    @Override
    protected WaitingsEntity mapToEntity(WaitingsModel model) {
        var entity = new WaitingsEntity();
        var tt = new TimetableEntity();
        var ttpk = new TimetablePKEntity();
        ttpk.setId(model.getIdTimetable());
        ttpk.settNum(model.gettNum());
        ttpk.setStationId(model.getStationId());
        tt.setPkEntity(ttpk);
        entity.setTimetable(tt);
        entity.setId(model.getId());
        entity.setValue(model.getValue());
        return entity;
    }

    protected WaitingsEntity mapToEntity(WaitingsModel model, TimetableEntity timetable) {
        var entity = new WaitingsEntity();
        entity.setTimetable(timetable);
        entity.setId(model.getId());
        entity.setValue(model.getValue());
        return entity;
    }

    public WaitingsService() { super(new WaitingsRepository()); }

    public Collection<WaitingsModel> getAll() {
        return this.getEntities();
    }

    public void createWaitings(WaitingsModel waitings) {
        this.createEntity(waitings);
    }

    public void updateWaitings(WaitingsModel waitings) {
        this.updateEntity(waitings);
    }

    public void deleteWaitings(WaitingsModel waitings) {
        this.deleteEntity(waitings);
    }
}
