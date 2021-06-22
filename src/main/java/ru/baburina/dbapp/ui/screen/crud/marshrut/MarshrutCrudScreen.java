package ru.baburina.dbapp.ui.screen.crud.marshrut;

import javafx.scene.Node;
import ru.baburina.dbapp.app.services.MarshrutService;
import ru.baburina.dbapp.app.services.UserService;
import ru.baburina.dbapp.db.repository.UserRepository;
import ru.baburina.dbapp.ui.models.MarshrutViewModel;
import ru.baburina.dbapp.ui.models.UserViewModel;
import ru.baburina.dbapp.ui.screen.crud.common.AbstractCrudScreen;
import ru.baburina.dbapp.ui.screen.crud.users.UserFormBuilder;
import ru.baburina.dbapp.ui.screen.crud.users.UsersTableBuilder;

import java.util.List;
import java.util.stream.Collectors;

public class MarshrutCrudScreen extends AbstractCrudScreen<MarshrutViewModel> {
    public static final String id = "MarshrutCrudScreen";

    private final MarshrutService service;

    public MarshrutCrudScreen() {
        super(new MarshrutCrudTableBuilder(), new MarshrutFormBuilder());
        this.service = new MarshrutService();
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    protected int getTotalCount() {
        return this.service.getCount();
    }

    @Override
    protected List<MarshrutViewModel> getItems(int page, int pageSize) {
        return this.service.getEntitesPage(page, pageSize).stream().map(MarshrutViewModel::new).collect(Collectors.toList());
    }

    @Override
    protected MarshrutViewModel emptyModel() {
        return new MarshrutViewModel();
    }

    @Override
    protected boolean create(MarshrutViewModel model) {
        return this.tryExec(() -> this.service.createMarshrut(model.toAppModel()));
    }

    @Override
    protected boolean update(MarshrutViewModel model) {
        return this.tryExec(() -> this.service.updateMarshrut(model.toAppModel()));
    }

    @Override
    protected boolean delete(MarshrutViewModel model) {
        return this.tryExec(() -> this.service.deleteMarshrut(model.toAppModel()));
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

    @Override
    public Node init1(Object o) {
        return null;
    }
}