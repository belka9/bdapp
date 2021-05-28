package ru.baburina.dbapp.ui.screen;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import ru.baburina.dbapp.ui.api.AppScreen;

public class MainMenu implements AppScreen {

    public static final String id = "MainMenu";

    @Override
    public Node init() {
        var label = new Label("MainMenu");

        var pane = new StackPane();
        pane.getChildren().add(label);

        return pane;
    }
}
