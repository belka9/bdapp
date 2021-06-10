package ru.baburina.dbapp.app.services;

import ru.baburina.dbapp.app.models.UserModel;
import ru.baburina.dbapp.db.api.Repository;
import ru.baburina.dbapp.db.entities.UserEntity;
import ru.baburina.dbapp.db.repository.UserRepository;

import java.util.Collection;

public class UserService extends AbstractEntityService<UserModel, UserEntity> {

    private final UserRepository userRepository;

    public UserService(UserRepository repository) {
        super(repository);
        this.userRepository = repository;
    }

    @Override
    protected UserModel mapToModel(UserEntity entity) {
        if (entity == null) {
            return null;
        }
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
    public UserModel find(String name, String password){
        return this.mapToModel(
                this.userRepository.find(name, password)
        );
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
