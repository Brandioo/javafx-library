package Login;

import LibraryManagementFunctionFactory.LibraryManagementOptionsFactory;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.time.LocalDateTime;

public class ClientSignUpView {
    public Scene execute(Stage stage){
        GridPane root1 = new GridPane();

        root1.setHgap(10);
        root1.setVgap(10);
        root1.setPadding(new Insets(10, 10, 10, 10));

        Label firstNameLabel = new Label("First Name");
        TextField firstNameField = new TextField();
        root1.add(firstNameLabel, 1, 2);
        root1.add(firstNameField, 2, 2);

        Label lastNameLabel = new Label("Last Name");
        TextField lastNameField = new TextField();
        root1.add(lastNameLabel, 1, 3);
        root1.add(lastNameField, 2, 3);

        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();
        root1.add(emailLabel, 1, 4);
        root1.add(emailField, 2, 4);

        Label phoneNumberLabel = new Label("PhoneNumber:");
        TextField phoneNumberField = new TextField();
        root1.add(phoneNumberLabel, 1, 5);
        root1.add(phoneNumberField, 2, 5);

        Label addressLabel = new Label("Address");
        TextField addressField = new TextField();
        root1.add(addressLabel, 1, 6);
        root1.add(addressField, 2, 6);

        Label createdOnLabel = new Label("Created On");
        TextField createdOnField = new TextField();
        root1.add(createdOnLabel, 1, 7);
        root1.add(createdOnField, 2, 7);

        Button createClientButton = new Button("-Client Creation-");
        root1.add(createClientButton, 2, 18);

        createClientButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String email = emailField.getText();
                String phoneNumber = phoneNumberField.getText();
                String address = addressField.getText();
                LocalDateTime createdOn = LocalDateTime.now();
                //String description = descriptionArea.getText();
                // boolean isRememberMe = remember.isSelected();

                LibraryManagementOptionsFactory libraryManagementOptionsFactory = new LibraryManagementOptionsFactory();
                boolean isRegistered = libraryManagementOptionsFactory.createClientButton(firstName, lastName, email, phoneNumber, address, createdOn);

                if (!isRegistered) {
                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                    errorAlert.setHeaderText("There was an error");
                    errorAlert.setContentText("The password and verify password don't match");
                    errorAlert.showAndWait();
                } else {
                    Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                    successAlert.setHeaderText("The user was registered successfully");
                    successAlert.showAndWait();
                    stage.setScene(new LoginView().execute(stage));
                    successAlert.close();
                }

            }

        });


        Scene scene = new Scene(root1, 700, 750);
        stage.setScene(scene);
        stage.setTitle("Sign Up Clients");
        stage.show();

        return scene;

    }

}
