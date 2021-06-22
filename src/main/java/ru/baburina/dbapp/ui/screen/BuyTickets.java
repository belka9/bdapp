package ru.baburina.dbapp.ui.screen;

import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import ru.baburina.dbapp.app.models.TicketsCreateModel;
import ru.baburina.dbapp.app.services.StationService;
import ru.baburina.dbapp.app.services.TicketsService;
import ru.baburina.dbapp.db.repository.StationRepository;
import ru.baburina.dbapp.db.repository.TimetableRepository;
import ru.baburina.dbapp.ui.MainScene;
import ru.baburina.dbapp.ui.api.AppScreen;
import ru.baburina.dbapp.ui.models.BuyTicketsParams;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class BuyTickets implements AppScreen {

    private TextField fioField;
    public static final String id = "BuyTickets";

    private final TicketsService ticketsService = new TicketsService();
    private final StationService stationService = new StationService(new StationRepository());

    private BuyTicketsParams params;

    @Override
    public Node init() {
        throw new RuntimeException("Not Implemented");
    }

    @Override
    public Node init1(Object o) {
        this.params = (BuyTicketsParams)o;
        var back = new Button("Back");
        back.setOnAction(e -> MainScene.popNode());
        var vbox = new VBox();
        vbox.getChildren().addAll(back);
        var timetableRepository = new TimetableRepository();
        var T = timetableRepository.getIdForBuy(this.params.getId(), this.params.getSt1());
        Instant time1 = T.getDt2();
        String l = time1.toString();
        var timeL = new Label(l);
        vbox.getChildren().addAll(timeL);

        var fioLabel = new Label("Enter FIO");
        this.fioField = new TextField();
        var vvbox = new VBox();
        vvbox.getChildren().addAll(vbox);
        var hbox = new HBox();
        hbox.getChildren().addAll(fioLabel, fioField);

        var buy = new Button("Buy!");
        buy.setOnAction(e -> {
                    var t = new TicketsCreateModel();
                    t.setId_timetable(params.getId());
                    if (fioField.getText().length() == 0) {
                        var alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setContentText("Заполните поле FIO!");
                        alert.showAndWait();
                        return;
                    }
                    t.setFio(fioField.getText());
                    t.setSt1(params.getSt1());
                    t.setSt2(params.getSt2());
                    var result = ticketsService.createTicket(t);
                    if (result) {
                        var alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Покупка");
                        DateTimeFormatter formatter =
                                DateTimeFormatter.ofLocalizedDateTime( FormatStyle.SHORT )
                                        .withLocale( Locale.UK )
                                        .withZone( ZoneId.systemDefault() );
                        alert.setContentText("Вы купили билет на" + formatter.format(time1));
                        alert.showAndWait();
                    } else {
                        var alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Покупка невозможна");
                        alert.setContentText("На этот поезд нельзя купить билет");
                        alert.showAndWait();
                    }
                });

        var resultt = new VBox();
        var resultPane = new ScrollPane();
        resultPane.setContent(resultt);

        var box = new VBox();
        box.getChildren().addAll(vvbox, hbox, buy);
        return box;
    }
}
