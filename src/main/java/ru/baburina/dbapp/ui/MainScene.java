package ru.baburina.dbapp.ui;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import ru.baburina.dbapp.db.HibernateUtil;
import ru.baburina.dbapp.ui.api.AppScreen;
import ru.baburina.dbapp.ui.screen.Login;
import ru.baburina.dbapp.ui.screen.MainMenu;
import ru.baburina.dbapp.ui.screen.SearchTrain;
import ru.baburina.dbapp.ui.screen.SqlInjectorScreen;
import ru.baburina.dbapp.ui.screen.crud.marshrut.MarshrutCrudScreen;
import ru.baburina.dbapp.ui.screen.crud.station.StationCrudScreen;
import ru.baburina.dbapp.ui.screen.crud.timetable.TimetableCrudScreen;
import ru.baburina.dbapp.ui.screen.crud.train.TrainCrudScreen;
import ru.baburina.dbapp.ui.screen.crud.users.UserCrudScreen;
import ru.baburina.dbapp.ui.screen.crud.waitings.WaitingsCrudScreen;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.Supplier;

//Управление экранами, инициализация приложения
public class MainScene {

    private static Scene scene;
    private static StackPane baseLayer;
    private static Map<String, Supplier<AppScreen>> screens = new HashMap<>();
    private static Stack<Node> nodeStack = new Stack<>();

    static {
        baseLayer = new StackPane();
        scene = new Scene(baseLayer, 600, 600);

        initDatabase();
        initScreens();
    }

    private static void initScreens() {
        screens.put(Login.id, Login::new);
        screens.put(MainMenu.id, MainMenu::new);
        screens.put(SqlInjectorScreen.id, SqlInjectorScreen::new);
        screens.put(UserCrudScreen.id, UserCrudScreen::new);
        screens.put(StationCrudScreen.id, StationCrudScreen::new);
        screens.put(TrainCrudScreen.id, TrainCrudScreen::new);
        screens.put(MarshrutCrudScreen.id, MarshrutCrudScreen::new);
        screens.put(TimetableCrudScreen.id, TimetableCrudScreen::new);
        screens.put(WaitingsCrudScreen.id, WaitingsCrudScreen::new);
        screens.put(SearchTrain.id, SearchTrain::new);
    }

    private static void initDatabase() {
        try(var session = HibernateUtil.getSessionFactory().openSession()) {}
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

    private static void putNode(Node node) {

        var children = baseLayer.getChildren();
        if (children.size() > 0) {
            nodeStack.push(children.get(0));
            children.remove(0);
        }
        baseLayer.getChildren().add(node);
    }

    public static void popNode() {
        var children = baseLayer.getChildren();
        if (children.size() > 0) {
            children.remove(0);
        }
        if (nodeStack.size() > 0) {
            var prevNode = nodeStack.pop();
            children.add(prevNode);
        }
    }
}
