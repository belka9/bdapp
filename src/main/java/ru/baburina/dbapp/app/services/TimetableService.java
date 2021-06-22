package ru.baburina.dbapp.app.services;
import ru.baburina.dbapp.app.models.TimetableModel;
import ru.baburina.dbapp.db.entities.TimetableEntity;
import ru.baburina.dbapp.db.entities.TimetablePKEntity;
import ru.baburina.dbapp.db.repository.TimetableRepository;
import java.util.Collection;

public class TimetableService extends AbstractEntityService<TimetableModel, TimetableEntity>{

    @Override
    protected TimetableModel mapToModel(TimetableEntity entity) {
        var model = new TimetableModel();
        model.setId(entity.getPkEntity().getId());
        model.setStationId(entity.getPkEntity().getStationId());
        model.settNum(entity.getPkEntity().gettNum());
        model.setDt1(entity.getDt1());
        model.setDt2(entity.getDt2());
        model.setNapr(entity.getNapr());
        model.setTickets(entity.getTickets());
        return model;
    }

    @Override
    protected TimetableEntity mapToEntity(TimetableModel model) {
        var entity = new TimetableEntity();
        var pk = new TimetablePKEntity();
        pk.setId(model.getId());
        pk.setStationId(model.getStationId());
        pk.settNum(model.gettNum());
        entity.setPkEntity(pk);
        entity.setDt1(model.getDt1());
        entity.setDt2(model.getDt2());
        entity.setNapr(model.getNapr());
        entity.setTickets(model.getTickets());
        return entity;
    }

    public TimetableModel getModelBuyTickets(int id, int id_station){
        var tt = new TimetableRepository();
        var i = tt.getIdForBuy(id, id_station);
        return this.mapToModel(i);
    }

    public Collection<TimetableModel> getAll() {
        return this.getEntities();
    }

    public TimetableService() { super(new TimetableRepository()); }

    public void createTimetable(TimetableModel timetable) {
        this.createEntity(timetable);
    }

    public void updateTimetable(TimetableModel timetable) {
        this.updateEntity(timetable);
    }

    public void deleteTimetable(TimetableModel timetable) { this.deleteEntity(timetable); }



}
