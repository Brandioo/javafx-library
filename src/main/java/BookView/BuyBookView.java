package BookView;

import BookView.AllBookView;
import BookView.BookFindingView;
import LibraryManagementFunctionFactory.BookFactory;
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
import views.HomeView;

public class BuyBookView {
    private Employee currentUser;
    private Book currentBook;

    public BuyBookView(Employee currentUser) {
        this.currentUser = currentUser;
    }
//    public BookFindingView(Book currentBook) {
//        this.currentBook = currentBook;
//    }


    public BuyBookView() {
    }

    public Scene execute(Stage stage) {

        GridPane root1 = new GridPane();

        root1.setHgap(10);
        root1.setVgap(10);
        root1.setPadding(new Insets(10, 10, 10, 10));
        root1.setAlignment(Pos.TOP_CENTER);

        Label bookISBNLabel = new Label("ISBN Of Book: ");
        bookISBNLabel.setTextFill(Color.web("white"));
        bookISBNLabel.setStyle("-fx-font-weight: bold;");
        TextField bookISBNField = new TextField();
        root1.add(bookISBNLabel, 3, 1);
        root1.add(bookISBNField, 4, 1);

        Button buyBookButton = new Button("-Buy-");
        buyBookButton.setTextFill(Color.web("black"));
        buyBookButton.setStyle("-fx-font-weight: bold;");
        buyBookButton.setId("buyBookButton-button");
        buyBookButton.setStyle("-fx-background-color:#09eab6;");
        HBox h = new HBox();
        h.getChildren().add(buyBookButton);
        root1.add(buyBookButton, 4, 6);

        buyBookButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                String isbn = bookISBNField.getText();
                //String description = descriptionArea.getText();
                // boolean isRememberMe = remember.isSelected();

                BookFactory bookFactory = new BookFactory();
                Book findBook = bookFactory.findBooksByISBN(isbn);

                if (findBook == null && currentBook.getQuantity() <= 0) {
                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                    errorAlert.setHeaderText("There was an error");
                    errorAlert.setContentText("Book not available");
                    errorAlert.showAndWait();
                } else {
                    Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                    successAlert.setHeaderText("Book Found");
                    successAlert.setContentText("The Credentials are okay");
                    if (findBook.getQuantity() <= 5) {
                        successAlert.setContentText("Time To Buy New Books ! " + "\n" + "Quantity Left Is Limited: " + findBook.getQuantity() + "\n" + "Price To Pay: "
                                + findBook.getPrice());
                    } else {
                        successAlert.setContentText("Book Is Registered..." + "\n" + "Quantity Left: " + findBook.getQuantity() + "\n" + "Price To Pay: "
                                + findBook.getPrice());
                    }
                    successAlert.showAndWait();
                    successAlert.close();
                }
            }

        });

        BorderPane mainPane = new BorderPane();
        MenuBar menuBar = new MenuBar();

        Label backLabel = new Label("Back");
        backLabel.setStyle("-fx-font-weight: bold;");
        Menu back = new Menu("", backLabel);
        backLabel.setOnMouseClicked(e -> {
            HomeView homeView = new HomeView(currentUser);
            stage.setScene(homeView.execute(stage));
        });

        menuBar.getMenus().add(back);
        mainPane.setTop(menuBar);

        Label allBooksViewLabel = new Label("All Books");
        Menu allBookViews = new Menu("", allBooksViewLabel);
        allBooksViewLabel.setOnMouseClicked(e -> {
            AllBookView allBookView = new AllBookView(currentUser);
            stage.setScene(allBookView.showView(stage));
        });

        menuBar.getMenus().add(allBookViews);
        mainPane.setTop(menuBar);


        Label findBookViewLabel = new Label("Find Books");
        Menu findBook = new Menu("", findBookViewLabel);
        findBookViewLabel.setOnMouseClicked(e -> {
            BookFindingView bookFindingView = new BookFindingView(currentUser);
            stage.setScene(bookFindingView.execute(stage));
        });

        menuBar.getMenus().add(findBook);
        mainPane.setTop(menuBar);

        root1.setStyle("-fx-background-image: url('buyBackGround.png')");
        mainPane.setCenter(root1);
        Scene scene = new Scene(mainPane, 563, 209);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.setTitle("Welcome to GONLINE Vending Machine");
        stage.show();

        return scene;

    }
}
