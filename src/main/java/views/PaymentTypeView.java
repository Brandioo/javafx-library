package views;

import BookView.BuyBookView;
import CartelRecordView.CartelRecordRegistrationView;
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
import model.Cartel;
import model.Employee;

public class PaymentTypeView {
    private Employee currentUser;
    private Cartel currentCartel;
    public Scene showView(Stage stage) {
        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setAlignment(Pos.BOTTOM_LEFT);



        Button creditCardPaymentButton = new Button("Credit Card Payment");
        creditCardPaymentButton.setTextFill(Color.FIREBRICK);
        creditCardPaymentButton.setId("creditCardPaymentButton-button");
        creditCardPaymentButton.setStyle("-fx-background-color:#ffffff;");
        HBox h = new HBox();
        h.getChildren().add(creditCardPaymentButton);
        root.add(creditCardPaymentButton, 2, 1);

        creditCardPaymentButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                successAlert.setHeaderText("Success Click");
                successAlert.setContentText("The Credit Card Payment Section Is Clicked");
//                    HomeView homeView=new HomeView(loggedIn);
//                    stage.setScene(homeView.execute(stage));
                successAlert.showAndWait();
                BuyBookView buyBookView=new BuyBookView();
                buyBookView.execute(stage);
                successAlert.close();

            }
        });

        Button cashPaymentButton = new Button("Cash Payment");
        cashPaymentButton.setTextFill(Color.FIREBRICK);
        //loginButton.setStyle("-fx-font-weight: bold;");
        cashPaymentButton.setId("cashPaymentButton-button");
        cashPaymentButton.setStyle("-fx-background-color:#ffffff;");
        HBox h1 = new HBox();
        h1.getChildren().add(cashPaymentButton);
        root.add(cashPaymentButton, 2, 2);

        cashPaymentButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                successAlert.setHeaderText("Success Click");
                successAlert.setContentText("The Cash Payment Section Is Clicked");
//                    HomeView homeView=new HomeView(loggedIn);
//                    stage.setScene(homeView.execute(stage));
                BuyBookView buyBookView=new BuyBookView();
                buyBookView.execute(stage);
                successAlert.showAndWait();
                successAlert.close();

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

        root.setStyle("-fx-background-image: url('img_16.png')");
        mainPane.setCenter(root);
        Scene scene = new Scene(mainPane, 300, 199);
        // scene.getStylesheets().add("style.css");
        stage.setTitle("Payment");
        return scene;
    }
}
