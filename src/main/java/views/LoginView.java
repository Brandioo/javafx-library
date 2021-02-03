package views;

import LibraryManagementFunctionFactory.EmployeeFactory;
import LibraryManagementFunctionFactory.LibraryManagementOptionsFactory;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Employee;

public class LoginView {
    public Scene showView(Stage stage) {


        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setAlignment(Pos.CENTER);


        Label userLabel = new Label("Username:");
        userLabel.setTextFill(Color.web("white"));
        userLabel.setStyle("-fx-font-weight: bold;");
        TextField userField = new TextField();
        root.add(userLabel, 1, 3);
        root.add(userField, 2, 3);

        Label passwordLabel = new Label("Password:");
        passwordLabel.setTextFill(Color.web("white"));
        passwordLabel.setStyle("-fx-font-weight: bold;");
        PasswordField passwordField = new PasswordField();
        root.add(passwordLabel, 1, 4);
        root.add(passwordField, 2, 4);

        Button loginButton = new Button("Log in");
        //loginButton.setStyle("-fx-font-weight: bold;");
        loginButton.setId("loginButton-button");
        loginButton.setStyle("-fx-background-color:#95ff00;");
        HBox h=new HBox();
        h.getChildren().add(loginButton);
        root.add(loginButton, 2, 10);

        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String user = userField.getText();
                String password = passwordField.getText();

                EmployeeFactory uc = new EmployeeFactory();
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

        Button signUp = new Button("Sign up");
        signUp.setStyle("-fx-font-weight: bold;");
        signUp.setId("signUp-button");
        signUp.setStyle("-fx-background-color:#95ff00;");
        HBox h1=new HBox();
        h1.getChildren().add(signUp);
        root.add(signUp, 2, 11);

        signUp.setOnAction(e->{
            stage.setScene(new SignUpView().execute(stage));
        });

        BorderPane mainPane = new BorderPane();
        MenuBar menuBar = new MenuBar();

        Label backLabel=new Label("Back");
        backLabel.setStyle("-fx-font-weight: bold;");
        Menu back=new Menu("", backLabel);
        backLabel.setOnMouseClicked(e->{
            SecondView secondView= new SecondView();
            stage.setScene(secondView.showView(stage));
        });

        menuBar.getMenus().add(back);
        mainPane.setTop(menuBar);

        root.setStyle("-fx-background-image: url('library.png')");
        mainPane.setCenter(root);
        Scene scene = new Scene(mainPane, 693, 426);
        scene.getStylesheets().add("style.css");
        stage.setTitle("Log in");
        return scene;
    }
}
