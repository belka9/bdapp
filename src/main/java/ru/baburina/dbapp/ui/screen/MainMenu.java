package ru.baburina.dbapp.ui.screen;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import ru.baburina.dbapp.ui.MainScene;
import ru.baburina.dbapp.ui.api.AppScreen;
import ru.baburina.dbapp.ui.screen.crud.users.UserCrudScreen;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MainMenu implements AppScreen {

    public static final String id = "MainMenu";

    @Override
    public Node init() {
        var VBox = new VBox();
        var vboxChildren = VBox.getChildren();
        this.getButtons().forEach(item -> {
            var button = new Button(item.title);
            button.setOnAction(event -> {
                MainScene.show(item.id);
            });
            vboxChildren.add(button);
        });

        return VBox;
    }

    private List<ButtonDescriptor> getButtons() {
        return Arrays.asList(
                new ButtonDescriptor("SQL", SqlInjectorScreen.id),
                new ButtonDescriptor("Users CRUD", UserCrudScreen.id)
        );
    }

    private static class ButtonDescriptor {
        public final String title;
        public final String id;

        public ButtonDescriptor(String title, String id) {
            this.title = title;
            this.id = id;
        }
    }
}
