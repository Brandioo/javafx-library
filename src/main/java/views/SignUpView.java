package views;

import LibraryManagementFunctionFactory.EmployeeFactory;
import LibraryManagementFunctionFactory.LibraryManagementOptionsFactory;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Book;
import model.Employee;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class SignUpView {
    private Employee currentUser;
    private Book currentBook;
    public SignUpView(Employee currentUser) {
        this.currentUser = currentUser;
    }

    public SignUpView() {
    }

    public Scene execute(Stage stage) {
        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(10, 10, 10, 10));

        Label firstNameLabel = new Label("First Name");
        firstNameLabel.setTextFill(Color.DEEPSKYBLUE);
        firstNameLabel.setStyle("-fx-font-weight: bold;");
        TextField firstNameField = new TextField();
        root.add(firstNameLabel, 1, 2);
        root.add(firstNameField, 2, 2);

        Label lastNameLabel = new Label("Last Name");
        lastNameLabel.setTextFill(Color.DEEPSKYBLUE);
        lastNameLabel.setStyle("-fx-font-weight: bold;");
        TextField lastNameField = new TextField();
        root.add(lastNameLabel, 1, 3);
        root.add(lastNameField, 2, 3);

        Label dateOfBirthLabel = new Label("DateOfBirth (yyyy-mm-dd):");
        dateOfBirthLabel.setTextFill(Color.DEEPSKYBLUE);
        dateOfBirthLabel.setStyle("-fx-font-weight: bold;");
        TextField dateOfBirthField = new TextField();
        root.add(dateOfBirthLabel, 1, 4);
        root.add(dateOfBirthField, 2, 4);

        Label emailLabel = new Label("Email:");
        emailLabel.setTextFill(Color.DEEPSKYBLUE);
        emailLabel.setStyle("-fx-font-weight: bold;");
        TextField emailField = new TextField();
        root.add(emailLabel, 1, 5);
        root.add(emailField, 2, 5);

        Label phoneNumberLabel = new Label("PhoneNumber:");
        phoneNumberLabel.setTextFill(Color.DEEPSKYBLUE);
        phoneNumberLabel.setStyle("-fx-font-weight: bold;");
        TextField phoneNumberField = new TextField();
        root.add(phoneNumberLabel, 1, 6);
        root.add(phoneNumberField, 2, 6);

        Label professionLabel = new Label("Role");
        professionLabel.setTextFill(Color.DEEPSKYBLUE);
        professionLabel.setStyle("-fx-font-weight: bold;");
        root.add(professionLabel, 1, 7);
        ComboBox professionDropDown = new ComboBox();
        professionDropDown.getItems().add("Manager");
        professionDropDown.getItems().add("Seller");
        root.add(professionDropDown, 2, 7);

        Label userLabel = new Label("User:");
        userLabel.setTextFill(Color.DEEPSKYBLUE);
        userLabel.setStyle("-fx-font-weight: bold;");
        TextField userField = new TextField();
        root.add(userLabel, 1, 8);
        root.add(userField, 2, 8);

        Label passwordLabel = new Label("Password:");
        passwordLabel.setTextFill(Color.DEEPSKYBLUE);
        passwordLabel.setStyle("-fx-font-weight: bold;");
        PasswordField passwordField = new PasswordField();
        root.add(passwordLabel, 1, 9);
        root.add(passwordField, 2, 9);

        Label verifiedpasswordLabel = new Label("Verify Password:");
        verifiedpasswordLabel.setTextFill(Color.DEEPSKYBLUE);
        verifiedpasswordLabel.setStyle("-fx-font-weight: bold;");
        PasswordField verifiedpasswordField = new PasswordField();
        root.add(verifiedpasswordLabel, 1, 10);
        root.add(verifiedpasswordField, 2, 10);


        Label descriptionLabel = new Label("Description");
        descriptionLabel.setTextFill(Color.DEEPSKYBLUE);
        descriptionLabel.setStyle("-fx-font-weight: bold;");
        root.add(descriptionLabel, 1, 14);
        TextArea descriptionArea = new TextArea();
        root.add(descriptionArea, 2, 14);

        Button signupButton = new Button("Sign up");
        signupButton.setStyle("-fx-font-weight: bold;");
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

                EmployeeFactory employeeFactory = new EmployeeFactory();
                boolean isRegistered = employeeFactory.signUp(firstName, lastName, dateOfBirth, email, phoneNumber, role, user, password, verfiedPassword, createdOn);

                if (!isRegistered) {
                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                    errorAlert.setHeaderText("There was an error");
                    errorAlert.setContentText("The password and verify password don't match");
                    errorAlert.showAndWait();
                } else {
                    Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                    successAlert.setHeaderText("The user was registered successfully");
                    successAlert.showAndWait();
                    stage.setScene(new LoginView().showView(stage));
                    successAlert.close();
                }

            }

        });

        BorderPane mainPane = new BorderPane();
        MenuBar menuBar = new MenuBar();

        Label backLabel=new Label("Log-In Page");
        backLabel.setStyle("-fx-font-weight: bold;");
        Menu back=new Menu("", backLabel);

        backLabel.setOnMouseClicked(e->{
            stage.setScene(new LoginView().showView(stage));
        });

        menuBar.getMenus().add(back);
        mainPane.setTop(menuBar);

        root.setStyle("-fx-background-image: url('img_4.png')");
        mainPane.setCenter(root);

        Scene scene = new Scene(mainPane, 599, 700);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.setTitle("Sign up users!");
        stage.show();

        return scene;
    }
}

