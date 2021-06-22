package ru.baburina.dbapp.app.services;

import ru.baburina.dbapp.app.models.ScheduledTrainModel;
import ru.baburina.dbapp.app.models.TrainModel;
import ru.baburina.dbapp.db.api.Repository;
import ru.baburina.dbapp.db.entities.MarshrutEntity;
import ru.baburina.dbapp.db.entities.MarshrutPKEntity;
import ru.baburina.dbapp.db.entities.TrainEntity;
import ru.baburina.dbapp.db.repository.TimetableRepository;

import java.time.Instant;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class TrainService extends AbstractEntityService<TrainModel, TrainEntity> {

    private final TimetableRepository timetableRepository = new TimetableRepository();

    public TrainService(Repository<TrainEntity, ?> repository) {
        super(repository);
    }

    @Override
    protected TrainModel mapToModel(TrainEntity entity) {
        var model = new TrainModel();
        model.setNum(entity.getNum());
        model.setQuanity(entity.getQuantity());
        model.setCategory(entity.getCategory());
        model.setStationId(entity.getMarshrut().getStation().getId());
        model.setMarshNum(entity.getMarshrut().getMarshrutPk().getNum());
        return model;
    }

    @Override
    protected TrainEntity mapToEntity(TrainModel model) {
        var entity = new TrainEntity();
        entity.setNum(model.getNum());
        entity.setCategory(model.getCategory());
        entity.setQuantity(model.getQuanity());
        var marshrut =new MarshrutEntity();
        var pk = new MarshrutPKEntity();
        pk.setNum(model.getMarshNum());
        pk.setStationId(model.getStationId());
        marshrut.setMarshrutPk(pk);
        entity.setMarshrut(marshrut);


        return entity;
    }

    public Collection<TrainModel> getTrain() {
        return this.getEntities();
    }

    public void createTrain(TrainModel train) {
        this.createEntity(train);
    }

    public void updateTrain(TrainModel train) {
        this.updateEntity(train);
    }

    public void deleteTrain(TrainModel train) {
        this.deleteEntity(train);
    }

    public List<ScheduledTrainModel> getTrains(int st1, int st2, Instant dt1, Instant dt2) {
        return this.timetableRepository.findTrainsByDauStations(st1, st2, dt1, dt2).stream().map(t -> {
            var m = new ScheduledTrainModel();
            m.setTimetableId(t.getTimetableId());
            m.setTrain(this.mapToModel(t.getTrain()));
            return m;
        }).collect(Collectors.toList());
    }

}
