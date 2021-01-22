package Login;

import LibraryManagementFunctionFactory.LibraryManagementOptionsFactory;
import com.sun.javafx.scene.control.IntegerField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.time.LocalDateTime;

public class BookStockRegistrationView {
    public Scene execute(Stage stage) {
        GridPane root1 = new GridPane();

        root1.setHgap(10);
        root1.setVgap(10);
        root1.setPadding(new Insets(10, 10, 10, 10));

        Label bookNameLabel = new Label("Book Name: ");
        TextField bookNameField = new TextField();
        root1.add(bookNameLabel, 1, 2);
        root1.add(bookNameField, 2, 2);

        Label genereLabel = new Label("Genere: ");
        TextField genereField = new TextField();
        root1.add(genereLabel, 1, 3);
        root1.add(genereField, 2, 3);

        Label isbnLabel = new Label("ISBN Code: ");
        TextField isbnField = new TextField();
        root1.add(isbnLabel, 1, 4);
        root1.add(isbnField, 2, 4);

        Label descriptionLabel = new Label("Description: ");
        root1.add(descriptionLabel, 1, 5);
        TextArea descriptionArea = new TextArea();
        root1.add(descriptionArea, 2, 5);

        // Creates an integer spinner with 1 as min, 10 as max and 2 as initial value
        Spinner<Integer> spinner1 = new Spinner<>(1, 1000, 1);

        Spinner<Integer> spinner2 = new Spinner<>(1, 1000, 1);


// Creates an integer spinner with 0 as min, 100 as max and 10 as initial
// value and 10 as amount to increment or decrement by, per step
       // Spinner<Integer> spinner2 = new Spinner<>(0, 100, 10, 10);

//        Label quantityLabel = new Label("Quantity: ");
//        IntegerField quantityField = new IntegerField();
//        root1.add(quantityLabel, 1, 6);
//        root1.add(quantityField, 2, 6);
//
//        Label priceLabel = new Label("Price: ");
//        IntegerField priceField = new IntegerField();
//        root1.add(priceLabel, 1, 7);
//        root1.add(priceField, 2, 7);

//
//        Label quantityLabel=new Label("Quantity: ");
//        root1.add(spinner1,1,6);


        root1.add(new Label("Quantity: "),1,6);
        root1.add(spinner1,2,6);
//        TextField quantityField = new TextField();
//        root1.add(quantityField, 2, 8);


        root1.add(new Label("Price: "),1,7);
        root1.add(spinner2,2,7);
//        TextField priceField = new TextField();
//        root1.add(priceField, 2, 8);


        Label createdOnLabel = new Label("Created On: ");
        TextField createdOnField = new TextField();
        root1.add(createdOnLabel, 1, 8);
        root1.add(createdOnField, 2, 8);

        Button createClientButton = new Button("-Book Creation-");
        root1.add(createClientButton, 2, 18);

        createClientButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                String bookName = bookNameField.getText();
                String genere = genereField.getText();
                String isbn = isbnField.getText();
                String description = descriptionArea.getText();
                Integer quantity = spinner1.getValue();
                Integer price = spinner2.getValue();
                LocalDateTime createdOn = LocalDateTime.now();
                //String description = descriptionArea.getText();
                // boolean isRememberMe = remember.isSelected();

                LibraryManagementOptionsFactory libraryManagementOptionsFactory = new LibraryManagementOptionsFactory();
                boolean isRegistered = libraryManagementOptionsFactory.createBookButton(bookName, genere, isbn, description, quantity, price, createdOn);

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
        stage.setTitle("Register Books");
        stage.show();

        return scene;

    }
}
