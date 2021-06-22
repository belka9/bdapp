package ru.baburina.dbapp.ui.screen;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import ru.baburina.dbapp.app.models.TicketsCreateModel;
import ru.baburina.dbapp.app.services.StationService;
import ru.baburina.dbapp.app.services.TicketsService;
import ru.baburina.dbapp.db.repository.StationRepository;
import ru.baburina.dbapp.db.repository.TimetableRepository;
import ru.baburina.dbapp.ui.MainScene;
import ru.baburina.dbapp.ui.api.AppScreen;

public class DeleteTickets implements AppScreen {

    private TextField idField;
    public static final String id = "DeleteTickets";

    private final TicketsService ticketsService = new TicketsService();
    private final StationService stationService = new StationService(new StationRepository());


    @Override
    public Node init() {
        var back = new Button("Back");
        back.setOnAction(e -> MainScene.popNode());
        var vbox = new VBox();
        vbox.getChildren().addAll(back);

        var idLabel = new Label("Enter id tickets");
        this.idField = new TextField();

        var hbox = new HBox();
        hbox.getChildren().addAll(idLabel, idField);

        var drop = new Button("Drop tickets!");
        drop.setOnAction(e -> {
            String idstr = idField.getText();
            int idtxt = Integer.parseInt(idstr);
            var id =
                    ticketsService.deleteTicket(idtxt);
        });

        var result = new VBox();
        var resultPane = new ScrollPane();
        resultPane.setContent(result);

        var box = new VBox();
        box.getChildren().addAll(vbox, hbox, drop);
        return box;

    }

    @Override
    public Node init1(Object o) {
        throw new RuntimeException("Not Implemented");
    }
}
