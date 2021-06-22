package ru.baburina.dbapp.ui.screen.crud.waitings;
import javafx.scene.Node;
import ru.baburina.dbapp.app.services.WaitingsService;
import ru.baburina.dbapp.ui.models.WaitingsViewModel;
import ru.baburina.dbapp.ui.screen.crud.common.AbstractCrudScreen;
import java.util.List;
import java.util.stream.Collectors;

public class WaitingsCrudScreen extends AbstractCrudScreen<WaitingsViewModel> {

    public static final String id = "WaitingsCrudScreen";

    private final WaitingsService service;

    public WaitingsCrudScreen() {
        super(new WaitingsCrudTableBuilder(), new WaitingsFormBuilder());
        this.service = new WaitingsService();
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
    protected List getItems(int page, int pageSize) {
        return this.service.getEntitesPage(page, pageSize).stream().map(WaitingsViewModel::new).collect(Collectors.toList());
    }

    @Override
    protected WaitingsViewModel emptyModel() {
        return new WaitingsViewModel();
    }


    @Override
    protected boolean create(WaitingsViewModel model) {
        return this.tryExec(() -> this.service.createWaitings(model.toAppModel()));
    }

    @Override
    protected boolean update(WaitingsViewModel model) {
        return this.tryExec(() -> this.service.updateWaitings(model.toAppModel()));
    }

    @Override
    protected boolean delete(WaitingsViewModel model) {
        return this.tryExec(() -> this.service.deleteWaitings(model.toAppModel()));
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
