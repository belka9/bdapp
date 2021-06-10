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
        super(new UsersTableBuilder(), new UserFormBuilder());
        this.service = new UserService(new UserRepository());
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    protected List<UserViewModel> getItems(int page, int pageSize) {
        return this.service.getEntitesPage(page, pageSize).stream().map(UserViewModel::new).collect(Collectors.toList());
    }

    @Override
    protected int getTotalCount() {
        return this.service.getCount();
    }

    @Override
    protected UserViewModel emptyModel() {
        return new UserViewModel();
    }

    @Override
    protected boolean create(UserViewModel model) {
        return this.tryExec(() -> this.service.createUser(model.toAppModel()));
    }

    @Override
    protected boolean update(UserViewModel model) {
        return this.tryExec(() -> this.service.updateUser(model.toAppModel()));
    }

    @Override
    protected boolean delete(UserViewModel model) {
        return this.tryExec(() -> this.service.deleteUser(model.toAppModel()));
    }

    private boolean tryExec(Runnable action) {
        try {
            action.run();
            return true;
        } catch (Throwable ex) {
            System.err.println(ex);
            return false;
        }
    }
}
