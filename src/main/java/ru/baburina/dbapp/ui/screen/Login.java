package ru.baburina.dbapp.ui.screen;

import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import ru.baburina.dbapp.app.services.UserService;
import ru.baburina.dbapp.db.repository.UserRepository;
import ru.baburina.dbapp.ui.MainScene;
import ru.baburina.dbapp.ui.api.AppScreen;

public class Login implements AppScreen {

    public static final String id = "Login";
    private final UserService service = new UserService(new UserRepository());

    private TextField loginField;
    private PasswordField passwordField;

    @Override
    public Node init() {

        var loginLabel = new Label("Логин");
        this.loginField = new TextField();

        var line1 = new HBox();
        line1.getChildren().add(loginLabel);
        line1.getChildren().add(loginField);

        var passwordLabel = new Label("Пароль");
        this.passwordField = new PasswordField();

        var line2 = new HBox();
        line2.getChildren().add(passwordLabel);
        line2.getChildren().add(passwordField);

        var loginButton = new Button("Войти");
        loginButton.setOnAction(event -> this.onLogin());
        var line3 = new HBox();
        line3.getChildren().add(loginButton);


        var inputBlock = new VBox();
        inputBlock.getChildren().add(line1);
        inputBlock.getChildren().add(line2);
        inputBlock.getChildren().add(line3);

        var stackPane = new StackPane();
        stackPane.getChildren().add(inputBlock);

        return inputBlock;
    }

    private void onLogin() {
        var login = this.loginField.getText();
        var password = this.passwordField.getText();
        var user = service.find(login, password);

        if (user == null) {
            var alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Логин");
            alert.setContentText("Невалидная пара логин\\пароль");
            alert.showAndWait().filter(a -> a == ButtonType.OK)
                    .ifPresent(a -> {
                        this.loginField.clear();
                        this.passwordField.clear();
                    });
            return;
        }

        MainScene.popNode();
        MainScene.show(MainMenu.id);


    }
}
