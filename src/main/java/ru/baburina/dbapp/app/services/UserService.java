package ru.baburina.dbapp.app.services;

import ru.baburina.dbapp.app.models.UserModel;
import ru.baburina.dbapp.db.api.Repository;
import ru.baburina.dbapp.db.entities.UserEntity;

import java.util.Collection;

public class UserService extends AbstractEntityService<UserModel, UserEntity> {

    public UserService(Repository<UserEntity, ?> repository) {
        super(repository);
    }

    @Override
    protected UserModel mapToModel(UserEntity entity) {
        var model = new UserModel();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setPassword(entity.getPassword());
        return model;
    }

    @Override
    protected UserEntity mapToEntity(UserModel model) {
        var entity = new UserEntity();
        entity.setId(model.getId());
        entity.setName(model.getName());
        entity.setPassword(model.getPassword());
        return entity;
    }

    public Collection<UserModel> getUsers() {
        return this.getEntities();
    }

    public void createUser(UserModel user) {
        this.createEntity(user);
    }

    public void updateUser(UserModel user) {
        this.updateEntity(user);
    }

    public void deleteUser(UserModel user) {
        this.deleteEntity(user);
    }
}
