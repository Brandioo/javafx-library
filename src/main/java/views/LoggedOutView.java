package views;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoggedOutView {
    public Scene execute(Stage stage) {
        GridPane root1 = new GridPane();
        Button logOutUser = new Button("Log Out");
        root1.add(logOutUser, 7, 11);

        logOutUser.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LoginView loginView = new LoginView();
                loginView.showView(stage);
            }
        });

        Scene scene = new Scene(root1, 700, 750);
        stage.setScene(scene);
        stage.setTitle("Logged Out Users!");
        stage.show();

        return scene;

    }
}
