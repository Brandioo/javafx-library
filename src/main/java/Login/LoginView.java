package Login;

import LibraryManagementFunctionFactory.LibraryManagementOptionsFactory;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Employee;

public class LoginView {
    public Scene execute(Stage stage) {
        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setAlignment(Pos.CENTER);


        Label userLabel = new Label("Email:");
        TextField userField = new TextField();
        root.add(userLabel, 1, 3);
        root.add(userField, 2, 3);

        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        root.add(passwordLabel, 1, 4);
        root.add(passwordField, 2, 4);

        Button loginButton = new Button("Log in");
        root.add(loginButton, 2, 10);

        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String user = userField.getText();
                String password = passwordField.getText();

                LibraryManagementOptionsFactory uc = new LibraryManagementOptionsFactory();
                Employee loggedIn = uc.logIn(user, password);


                System.out.println("Views.User: " + loggedIn);
                if (loggedIn==null) {
                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                    errorAlert.setHeaderText("There was an error");
                    errorAlert.setContentText("The password or the email don't match");
                    errorAlert.showAndWait();
                } else {
                    Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                    successAlert.setHeaderText("The user was logged in successfully");
                    successAlert.setContentText("The Credentials are okay");
//                    HomeView homeView=new HomeView(loggedIn);
//                    stage.setScene(homeView.execute(stage));
                    successAlert.showAndWait();
                    stage.setScene(new HomeView(loggedIn).execute(stage));
                    successAlert.close();
                }
            }
        });

//        signUp.setOnAction(e->{
//            stage.setScene(new SignUpView().execute(stage));
//        });

        Scene sc = new Scene(root, 400, 350);
        stage.setTitle("Log in");
        return sc;
    }
}
