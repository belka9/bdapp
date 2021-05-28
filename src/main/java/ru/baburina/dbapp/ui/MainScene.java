package ru.baburina.dbapp.ui;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import ru.baburina.dbapp.ui.api.AppScreen;
import ru.baburina.dbapp.ui.screen.Login;
import ru.baburina.dbapp.ui.screen.MainMenu;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class MainScene {

    private static Scene scene;
    private static StackPane baseLayer;
    private static Map<String, Supplier<AppScreen>> screens = new HashMap<>();

    static {
        baseLayer = new StackPane();
        scene = new Scene(baseLayer, 600, 600);

        initScreens();
    }

    private static void initScreens() {
        screens.put(Login.id, Login::new);
        screens.put(MainMenu.id, MainMenu::new);
    }

    public static Scene getScene() {
        return scene;
    }

    public static void show(String id) {
        if (!screens.containsKey(id)) {
            return;
        }
        var node = screens.get(id).get();
        putNode(node.init());
    }

    public static void putNode(Node node) {
        baseLayer.getChildren().add(node);
    }

    public static void popNode() {
        var length = baseLayer.getChildren().size();
        if (length <= 0) {
            return;
        }
        baseLayer.getChildren().remove(length - 1);
    }
}
