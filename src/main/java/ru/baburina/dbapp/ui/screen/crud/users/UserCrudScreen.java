package ru.baburina.dbapp.ui.screen.crud.users;

import ru.baburina.dbapp.app.services.UserService;
import ru.baburina.dbapp.db.repository.UserRepository;
import ru.baburina.dbapp.ui.models.UserViewModel;
import ru.baburina.dbapp.ui.screen.crud.common.AbstractCrudScreen;

import java.util.List;
import java.util.stream.Collectors;

public class UserCrudScreen extends AbstractCrudScreen<UserViewModel> {

    public static final String id = "UserCrudScreen";

    private final UserService service;

    public UserCrudScreen() {
        super(new UsersTableBuilder());
        this.service = new UserService(new UserRepository());
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    protected List<UserViewModel> getItems() {
        return this.service.getUsers().stream().map(UserViewModel::new).collect(Collectors.toList());
    }
}
