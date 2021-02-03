package ClientView;

import LibraryManagementFunctionFactory.ClientFactory;
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
import model.Book;
import model.Client;
import model.Employee;
import views.HomeView;

public class ClientFindingView {
    private Employee currentUser;
    private Client currentClient;
    public ClientFindingView(Employee currentUser) {
        this.currentUser = currentUser;
    }
//    public BookFindingView(Book currentBook) {
//        this.currentBook = currentBook;
//    }


    public ClientFindingView() {
    }

    public Scene execute(Stage stage) {

        GridPane root1 = new GridPane();

        root1.setHgap(10);
        root1.setVgap(10);
        root1.setPadding(new Insets(10, 10, 10, 10));
        root1.setAlignment(Pos.CENTER);

        Label clinetNameLabel = new Label("Client Name: ");
        clinetNameLabel.setTextFill(Color.web("black"));
        clinetNameLabel.setStyle("-fx-font-weight: bold;");
        TextField clientNameField = new TextField();
        root1.add(clinetNameLabel, 1, 1);
        root1.add(clientNameField, 2, 1);

        Button findClientButton = new Button("-Find-");
        findClientButton.setTextFill(Color.web("black"));
        findClientButton.setStyle("-fx-font-weight: bold;");
        findClientButton.setId("loginButton-button");
        findClientButton.setStyle("-fx-background-color:#09eab6;");
        HBox h=new HBox();
        h.getChildren().add(findClientButton);
        root1.add(findClientButton, 2, 5);

        findClientButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                String firstName = clientNameField.getText();
                //String description = descriptionArea.getText();
                // boolean isRememberMe = remember.isSelected();

                ClientFactory clientFactory = new ClientFactory();
                Client findClient = clientFactory.findClientsByName(firstName);

                if (findClient==null) {
                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                    errorAlert.setHeaderText("There was an error");
                    errorAlert.setContentText("Client not available");
                    errorAlert.showAndWait();
                } else {
                    Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                    successAlert.setHeaderText("Client Found");
                    successAlert.setContentText("The Credentials are okay");
                    successAlert.setContentText("Client First Name: " + findClient.getFirstName() + "\n"
                            + "Client Last Name: " + findClient.getLastName() + "\n"
                            + "Client Email: " + findClient.getEmail() + "\n"
                            + "Client Phone Number: " + findClient.getPhoneNumber() + "\n"
                            + "Client Address: " + findClient.getAddress());
                    successAlert.showAndWait();
                    successAlert.close();
                }

            }

        });

        BorderPane mainPane = new BorderPane();
        MenuBar menuBar = new MenuBar();

        Label backLabel=new Label("Back");
        backLabel.setStyle("-fx-font-weight: bold;");
        Menu back=new Menu("", backLabel);
        backLabel.setOnMouseClicked(e->{
            HomeView homeView= new HomeView(currentUser);
            stage.setScene(homeView.execute(stage));
        });

        menuBar.getMenus().add(back);
        mainPane.setTop(menuBar);

        root1.setStyle("-fx-background-image: url('img_3.png')");
        mainPane.setCenter(root1);
        Scene scene = new Scene(mainPane, 1200, 469);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.setTitle("Find Clients");
        stage.show();

        return scene;

    }
}
