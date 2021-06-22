package ru.baburina.dbapp.ui.screen.crud.station;

import javafx.scene.Node;
import ru.baburina.dbapp.app.services.StationService;
import ru.baburina.dbapp.app.services.UserService;
import ru.baburina.dbapp.db.repository.StationRepository;
import ru.baburina.dbapp.db.repository.UserRepository;
import ru.baburina.dbapp.ui.models.StationViewModel;
import ru.baburina.dbapp.ui.models.UserViewModel;
import ru.baburina.dbapp.ui.screen.crud.common.AbstractCrudScreen;
import ru.baburina.dbapp.ui.screen.crud.users.UserFormBuilder;
import ru.baburina.dbapp.ui.screen.crud.users.UsersTableBuilder;

import java.util.List;
import java.util.stream.Collectors;

public class StationCrudScreen extends AbstractCrudScreen<StationViewModel> {

    public static final String id = "StationCrudScreen";

    private final StationService service;

    public StationCrudScreen() {
        super(new StationTableBuilder(), new StationFormBuilder());
        this.service = new StationService(new StationRepository());
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
    protected List<StationViewModel> getItems(int page, int pageSize) {
        return this.service.getEntitesPage(page, pageSize).stream().map(StationViewModel::new).collect(Collectors.toList());
    }

    @Override
    protected StationViewModel emptyModel() {
        return new StationViewModel();
    }

    @Override
    protected boolean create(StationViewModel model) {
        return this.tryExec(() -> this.service.createStation(model.toAppModel()));
    }

    @Override
    protected boolean update(StationViewModel model) {
        return this.tryExec(() -> this.service.updateStation(model.toAppModel()));
    }

    @Override
    protected boolean delete(StationViewModel model) {
        return this.tryExec(() -> this.service.deleteStation(model.toAppModel()));
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
