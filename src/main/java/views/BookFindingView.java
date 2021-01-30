package views;

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
import model.Employee;

import java.time.LocalDateTime;

public class BookFindingView {
    private Employee currentUser;
    private Book currentBook;
    public BookFindingView(Employee currentUser) {
        this.currentUser = currentUser;
    }
//    public BookFindingView(Book currentBook) {
//        this.currentBook = currentBook;
//    }


    public BookFindingView() {
    }

    public Scene execute(Stage stage) {

        GridPane root1 = new GridPane();

        root1.setHgap(10);
        root1.setVgap(10);
        root1.setPadding(new Insets(10, 10, 10, 10));
        root1.setAlignment(Pos.CENTER);

        Label bookNameLabel = new Label("Book Name: ");
        bookNameLabel.setTextFill(Color.web("white"));
        bookNameLabel.setStyle("-fx-font-weight: bold;");
        TextField bookNameField = new TextField();
        root1.add(bookNameLabel, 1, 1);
        root1.add(bookNameField, 2, 1);

        Button findBookButton = new Button("-Find-");
        findBookButton.setTextFill(Color.web("black"));
        findBookButton.setStyle("-fx-font-weight: bold;");
        findBookButton.setId("loginButton-button");
        findBookButton.setStyle("-fx-background-color:#09eab6;");
        HBox h=new HBox();
        h.getChildren().add(findBookButton);
        root1.add(findBookButton, 2, 5);

        findBookButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                String bookName = bookNameField.getText();
                //String description = descriptionArea.getText();
                // boolean isRememberMe = remember.isSelected();

                LibraryManagementOptionsFactory libraryManagementOptionsFactory = new LibraryManagementOptionsFactory();
                Book findBook = libraryManagementOptionsFactory.findBooksByName(bookName);

                if (findBook==null && currentBook.getQuantity()<=0) {
                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                    errorAlert.setHeaderText("There was an error");
                    errorAlert.setContentText("Book not available");
                    errorAlert.showAndWait();
                } else {
                    Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                    successAlert.setHeaderText("Book Found");
                    successAlert.setContentText("The Credentials are okay");
                    successAlert.setContentText(findBook.toString());
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


        root1.setStyle("-fx-background-image: url('img_2.png')");
        mainPane.setCenter(root1);
        Scene scene = new Scene(mainPane, 473, 473);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.setTitle("Find Books");
        stage.show();

        return scene;

    }
}
