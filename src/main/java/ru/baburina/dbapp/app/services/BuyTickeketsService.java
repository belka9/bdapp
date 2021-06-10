package ru.baburina.dbapp.app.services;

import ru.baburina.dbapp.app.models.TimetableModel;
import ru.baburina.dbapp.db.api.Repository;
import ru.baburina.dbapp.db.entities.TimetableEntity;

public class BuyTickeketsService extends AbstractEntityService<TimetableModel, TimetableEntity>{


    public BuyTickeketsService(Repository<TimetableEntity, ?> repository) {
        super(repository);
    }

    @Override
    protected TimetableModel mapToModel(TimetableEntity entity) {
        return null;
    }

    @Override
    protected TimetableEntity mapToEntity(TimetableModel model) {
        return null;
    }
}
