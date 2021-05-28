package ru.baburina.dbapp.main;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ru.baburina.dbapp.ui.MainScene;
import ru.baburina.dbapp.ui.screen.Login;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setScene(MainScene.getScene());
        primaryStage.show();

        MainScene.show(Login.id);
    }
}

