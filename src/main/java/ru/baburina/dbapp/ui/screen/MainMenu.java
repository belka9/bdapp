package ru.baburina.dbapp.ui.screen;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import ru.baburina.dbapp.ui.MainScene;
import ru.baburina.dbapp.ui.api.AppScreen;

public class MainMenu implements AppScreen {

    public static final String id = "MainMenu";

    @Override
    public Node init() {
        var sqlInjector = new Button("SQL");
        sqlInjector.setOnAction(event -> {
            MainScene.show(SqlInjectorScreen.id);
        });

        var VBox = new VBox();
        VBox.getChildren().add(sqlInjector);

        return VBox;
    }
}
