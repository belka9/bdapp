package ru.baburina.dbapp.app;

import ru.baburina.dbapp.db.entities.AaUsersEntity;
import ru.baburina.dbapp.db.entities.UserEntity;

public class AppState {

    private static AppState instance;

    public static AppState getInstance() {
        if (instance == null) {
            synchronized (AppState.class) {
                if (instance == null) {
                    instance = new AppState();
                }
            }
        }
        return instance;
    }

    private AppState() {}

    private UserEntity user;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
