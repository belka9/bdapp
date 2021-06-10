package ru.baburina.dbapp.ui.screen.crud.timetable;

import ru.baburina.dbapp.app.services.TimetableService;
import ru.baburina.dbapp.db.repository.TimetableRepository;
import ru.baburina.dbapp.ui.models.TimetableViewModel;
import ru.baburina.dbapp.ui.screen.crud.common.AbstractCrudScreen;
import java.util.List;
import java.util.stream.Collectors;

public class TimetableCrudScreen extends AbstractCrudScreen<TimetableViewModel> {

    public static final String id = "TimetableCrudScreen";

    private final TimetableService service;

    public TimetableCrudScreen() {
        super(new TimetableCrudTableBuilder(), new TimetableFormBuilder());
        this.service = new TimetableService();
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    protected int getTotalCount() {
        return this.service.getCount();
    }

    @Override
    protected List<TimetableViewModel> getItems(int page, int pageSize) {
        return this.service.getEntitesPage(page, pageSize).stream().map(TimetableViewModel::new).collect(Collectors.toList());
    }

    @Override
    protected TimetableViewModel emptyModel() {
        return new TimetableViewModel();
    }

    @Override
    protected boolean create(TimetableViewModel model) {
        return this.tryExec(() -> this.service.createTimetable(model.toAppModel()));
    }

    @Override
    protected boolean update(TimetableViewModel model) {
        return this.tryExec(() -> this.service.updateTimetable(model.toAppModel()));

    }

    @Override
    protected boolean delete(TimetableViewModel model) {
        return this.tryExec(() -> this.service.deleteTimetable(model.toAppModel()));
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
