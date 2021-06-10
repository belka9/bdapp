package ru.baburina.dbapp.ui.screen.crud.train;

import ru.baburina.dbapp.app.services.TrainService;
import ru.baburina.dbapp.db.repository.TrainRepository;
import ru.baburina.dbapp.ui.models.TrainViewModel;
import ru.baburina.dbapp.ui.screen.crud.common.AbstractCrudScreen;

import java.util.List;
import java.util.stream.Collectors;

public class TrainCrudScreen extends AbstractCrudScreen<TrainViewModel> {

    public static final String id = "TrainCrudScreen";

    private final TrainService service;

    public TrainCrudScreen() {
        super(new TrainCrudTableBuilder(), new TrainFormBuilder());
        this.service = new TrainService(new TrainRepository());
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
    protected List<TrainViewModel> getItems(int page, int pageSize) {
        return this.service.getEntitesPage(page, pageSize).stream().map(TrainViewModel::new).collect(Collectors.toList());
    }

    @Override
    protected TrainViewModel emptyModel() {
        return new TrainViewModel();
    }

    @Override
    protected boolean create(TrainViewModel model) {
        return this.tryExec(() -> this.service.createTrain(model.toAppModel()));
    }

    @Override
    protected boolean update(TrainViewModel model) {
        return this.tryExec(() -> this.service.updateTrain(model.toAppModel()));
    }

    @Override
    protected boolean delete(TrainViewModel model) {
        return this.tryExec(() -> this.service.deleteTrain(model.toAppModel()));
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

