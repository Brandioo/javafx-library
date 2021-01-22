package Login;

import LibraryManagementFunctionFactory.LibraryManagementOptionsFactory;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.Employee;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class HomeView {
    private Employee currentUser;

    public HomeView(Employee currentUser) {
        this.currentUser = currentUser;
    }

    public Scene execute(Stage stage) {
        //StackPane root = new StackPane();
        GridPane root1 = new GridPane();


        Button getAllCartelRecord = new Button("-Get All Cartel-Record Info-");
        root1.add(getAllCartelRecord, 7, 1);

        getAllCartelRecord.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                LibraryManagementOptionsFactory libraryManagementOptionsFactory = new LibraryManagementOptionsFactory();
                Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                successAlert.setHeaderText("All Cartels-Record Information");
                successAlert.setContentText(libraryManagementOptionsFactory.findAllCartelRecord());
                successAlert.showAndWait();
                System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
            }

        });

        Button getAllUser = new Button("-Get All User Info-");
        root1.add(getAllUser, 7, 2);

        getAllUser.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {

                LibraryManagementOptionsFactory libraryManagementOptionsFactory = new LibraryManagementOptionsFactory();
                Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                successAlert.setHeaderText("All Users Information");
                successAlert.setContentText(libraryManagementOptionsFactory.findAllEmployees());
                successAlert.showAndWait();
                System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
            }

        });

        Button getAllClients = new Button("-Get All Client Info-");
        root1.add(getAllClients, 7, 3);

        getAllClients.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {

                LibraryManagementOptionsFactory libraryManagementOptionsFactory = new LibraryManagementOptionsFactory();
                Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                successAlert.setHeaderText("All Clients Information");
                successAlert.setContentText(libraryManagementOptionsFactory.findAllClient());
                successAlert.showAndWait();
                System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
            }

        });

        Button getAllCartels = new Button("-Get All Cartel Info-");
        root1.add(getAllCartels, 7, 4);

        getAllCartels.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                LibraryManagementOptionsFactory libraryManagementOptionsFactory = new LibraryManagementOptionsFactory();
                Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                successAlert.setHeaderText("All Cartels Information");
                successAlert.setContentText(libraryManagementOptionsFactory.findAllCartels());
                successAlert.showAndWait();
                System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
            }

        });


        Button getAllBooks = new Button("-Get All Books Info-");
        root1.add(getAllBooks, 7, 5);
//        root.getChildren().add(getAllUser);

        getAllBooks.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                LibraryManagementOptionsFactory libraryManagementOptionsFactory = new LibraryManagementOptionsFactory();
                Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                successAlert.setHeaderText("All Books Information");
                successAlert.setContentText(libraryManagementOptionsFactory.findAllBook());
                successAlert.showAndWait();
                System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
            }

        });


        Button getUser = new Button("-Get User Info-");
        root1.add(getUser, 7, 6);

        getUser.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText(this.currentUser.toString());
            alert.setHeaderText("The user Information");
            alert.showAndWait();

        });

        Button getVerificationStatus = new Button("-Verification Status-");
        root1.add(getVerificationStatus, 7, 7);

        getVerificationStatus.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Your Account Is Verified*");
            alert.setHeaderText("The user Information");
            alert.showAndWait();

        });

        Button createClientButton = new Button("-Create Client Button-");
        root1.add(createClientButton, 7, 8);

        createClientButton.setOnAction(e->{
            stage.setScene(new ClientSignUpView().execute(stage));
        });

        Button createBookButton = new Button("-Create Book Button-");
        root1.add(createBookButton, 7, 9);

        createBookButton.setOnAction(e->{
            stage.setScene(new BookStockRegistrationView().execute(stage));
        });

        Button logOutButton = new Button("Log-Out");
        root1.add(logOutButton, 7, 11);

        logOutButton.setOnAction(e->{
            stage.setScene(new LoginView().execute(stage));
        });

        Scene sc = new Scene(root1, 500, 500);
        stage.setTitle("Home");

        return sc;
    }

}
