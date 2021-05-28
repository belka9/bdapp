package ru.baburina.dbapp.app;

import ru.baburina.dbapp.db.entities.AaUsersEntity;

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

    private AaUsersEntity user;

    public AaUsersEntity getUser() {
        return user;
    }

    public void setUser(AaUsersEntity user) {
        this.user = user;
    }
}
