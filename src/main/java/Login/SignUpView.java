package Login;

import LibraryManagementFunctionFactory.LibraryManagementOptionsFactory;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class SignUpView {
    public Scene execute(Stage stage) {
        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(10, 10, 10, 10));

        Label firstNameLabel = new Label("First Name");
        TextField firstNameField = new TextField();
        root.add(firstNameLabel, 1, 2);
        root.add(firstNameField, 2, 2);

        Label lastNameLabel = new Label("Last Name");
        TextField lastNameField = new TextField();
        root.add(lastNameLabel, 1, 3);
        root.add(lastNameField, 2, 3);

        Label dateOfBirthLabel = new Label("DateOfBirth (yyyy-mm-dd):");
        TextField dateOfBirthField = new TextField();
        root.add(dateOfBirthLabel, 1, 4);
        root.add(dateOfBirthField, 2, 4);

        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();
        root.add(emailLabel, 1, 5);
        root.add(emailField, 2, 5);

        Label phoneNumberLabel = new Label("PhoneNumber:");
        TextField phoneNumberField = new TextField();
        root.add(phoneNumberLabel, 1, 6);
        root.add(phoneNumberField, 2, 6);

        Label professionLabel = new Label("Role");
        root.add(professionLabel, 1, 7);
        ComboBox professionDropDown = new ComboBox();
        professionDropDown.getItems().add("Manager");
        professionDropDown.getItems().add("Seller");
        root.add(professionDropDown, 2, 7);

        Label userLabel = new Label("User:");
        TextField userField = new TextField();
        root.add(userLabel, 1, 8);
        root.add(userField, 2, 8);

        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        root.add(passwordLabel, 1, 9);
        root.add(passwordField, 2, 9);

        Label verifiedpasswordLabel = new Label("Verify Password:");
        PasswordField verifiedpasswordField = new PasswordField();
        root.add(verifiedpasswordLabel, 1, 10);
        root.add(verifiedpasswordField, 2, 10);


        Label descriptionLabel = new Label("Description");
        root.add(descriptionLabel, 1, 14);
        TextArea descriptionArea = new TextArea();
        root.add(descriptionArea, 2, 14);

        Button signupButton = new Button("Sing up");
        root.add(signupButton, 2, 16);

        signupButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                LocalDate dateOfBirth = LocalDate.parse(dateOfBirthField.getText());
                String email = emailField.getText();
                String phoneNumber = phoneNumberField.getText();
                String role = (String) professionDropDown.getValue();
                String user = userField.getText();
                String password = passwordField.getText();
                String verfiedPassword = verifiedpasswordField.getText();
                LocalDateTime createdOn = LocalDateTime.now();
                //String description = descriptionArea.getText();
               // boolean isRememberMe = remember.isSelected();

                LibraryManagementOptionsFactory libraryManagementOptionsFactory = new LibraryManagementOptionsFactory();
                boolean isRegistered = libraryManagementOptionsFactory.signUp(firstName, lastName, dateOfBirth, email, phoneNumber, role, user, password, verfiedPassword, createdOn);

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

        Button logOutButton = new Button("Log-In Page");
        root.add(logOutButton, 2, 18);

        logOutButton.setOnAction(e->{
            stage.setScene(new LoginView().execute(stage));
        });

        Scene scene = new Scene(root, 700, 750);
        stage.setScene(scene);
        stage.setTitle("Sign up users!");
        stage.show();

        return scene;
    }
}

