package ru.baburina.dbapp.ui.screen;

import javafx.collections.FXCollections;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import ru.baburina.dbapp.app.models.StationModel;
import ru.baburina.dbapp.app.services.StationService;
import ru.baburina.dbapp.app.services.TrainService;
import ru.baburina.dbapp.db.repository.StationRepository;
import ru.baburina.dbapp.db.repository.TrainRepository;
import ru.baburina.dbapp.ui.MainScene;
import ru.baburina.dbapp.ui.api.AppScreen;
import ru.baburina.dbapp.ui.models.BuyTicketsParams;

import java.time.ZoneOffset;
import java.util.stream.Collectors;

public class SearchTrain implements AppScreen {

    public static final String id = "SearchTrain";
    private final StationService stationService = new StationService(new StationRepository());
    private final TrainService trainService = new TrainService(new TrainRepository());

    public SearchTrain() {
    }

    @Override
    public Node init() {

        var back = new Button("Back");
        back.setOnAction(e -> MainScene.popNode());

        var stations = stationService.getStation();
        var stationNames = FXCollections.observableList(stations.stream().map(StationModel::getName).collect(Collectors.toList()));

        var stationFrom = new ComboBox<String>();
        stationFrom.setItems(stationNames);

        var stationTo = new ComboBox<String>();
        stationTo.setItems(stationNames);

        var stationLine1 = new HBox();
        stationLine1.getChildren().addAll(new Label("From: "), stationFrom);

        var stationLine2 = new HBox();
        stationLine2.getChildren().addAll(new Label("To: "), stationTo);

        var stationsBlock = new VBox();
        stationsBlock.getChildren().addAll(stationLine1, stationLine2);

        var dateFrom = new DatePicker();
        var dateTo = new DatePicker();

        var dateLine1 = new HBox();
        dateLine1.getChildren().addAll(new Label("Start date: "), dateFrom);

        var dateLine2 = new HBox();
        dateLine2.getChildren().addAll(new Label("End date: "), dateTo);

        var datesBlock = new VBox();
        datesBlock.getChildren().addAll(dateLine1, dateLine2);

        var controls = new HBox();
        controls.getChildren().addAll(stationsBlock, datesBlock);

        var searchButton = new Button("Search");

        var controlsBlock = new VBox();
        controlsBlock.getChildren().addAll(controls, searchButton);

        var result = new VBox();
        var resultPane = new ScrollPane();
        resultPane.setContent(result);

        var vbox = new VBox();
        vbox.getChildren().addAll(back, controlsBlock, resultPane);

        searchButton.setOnAction(event -> {
            var st1 = stations.stream().filter(s -> s.getName().equals(stationFrom.getValue())).findFirst();
            var st2 = stations.stream().filter(s -> s.getName().equals(stationTo.getValue())).findFirst();
            var dt1 = dateFrom.getValue().atStartOfDay().toInstant(ZoneOffset.UTC);
            var dt2 = dateTo.getValue().atStartOfDay().toInstant(ZoneOffset.UTC);

            result.getChildren().clear();

            if (st1.isEmpty() || st2.isEmpty()) {
                return;
            }

            var trains = trainService.getTrains(st1.get().getId(), st2.get().getId(), dt1, dt2);


            result.getChildren().addAll(
                    trains.stream().map(x -> {
                        var btn = new Button("Train #" + x.getTrain().getNum() + " Marsh: " + x.getTrain().getMarshNum());
                        btn.setOnAction(e -> {
                            var params = new BuyTicketsParams();
                            params.setId(x.getTimetableId());
                            params.setSt1(st1.get().getId());
                            params.setSt2(st2.get().getId());

                            MainScene.show(BuyTickets.id, params);
                        });
                        return btn;
                    }).collect(Collectors.toList())
            );
        });

        return vbox;
    }

    @Override
    public Node init1(Object o) {
        throw new RuntimeException("Not implemented");
    }
}
