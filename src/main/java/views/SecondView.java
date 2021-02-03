package views;

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

public class SecondView {
    public Scene showView(Stage stage) {
        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setAlignment(Pos.CENTER_RIGHT);



        Button administratorButton = new Button("Administrator Entrance");
        administratorButton.setTextFill(Color.DEEPSKYBLUE);
        //loginButton.setStyle("-fx-font-weight: bold;");
        administratorButton.setId("administratorButton-button");
        administratorButton.setStyle("-fx-background-color:#000000;");
        HBox h = new HBox();
        h.getChildren().add(administratorButton);
        root.add(administratorButton, 5, 1);

        administratorButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                successAlert.setHeaderText("Success Click");
                successAlert.setContentText("The Administrator Section Is Clicked");
//                    HomeView homeView=new HomeView(loggedIn);
//                    stage.setScene(homeView.execute(stage));
                successAlert.showAndWait();
                stage.setScene(new LoginView().showView(stage));
                successAlert.close();

            }
        });

        Button operatorButton = new Button("   Operator Entrance   ");
        operatorButton.setTextFill(Color.DEEPSKYBLUE);
        //loginButton.setStyle("-fx-font-weight: bold;");
        operatorButton.setId("operatorButton-button");
        operatorButton.setStyle("-fx-background-color:#000000;");
        HBox h1 = new HBox();
        h1.getChildren().add(operatorButton);
        root.add(operatorButton, 5, 2);

        operatorButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                successAlert.setHeaderText("Success Click");
                successAlert.setContentText("The Operator Section Is Clicked");
//                    HomeView homeView=new HomeView(loggedIn);
//                    stage.setScene(homeView.execute(stage));
                successAlert.showAndWait();
                stage.setScene(new LoginView().showView(stage));
                successAlert.close();

            }
        });

        BorderPane mainPane = new BorderPane();
        MenuBar menuBar = new MenuBar();

        Label backLabel=new Label("Back");
        backLabel.setStyle("-fx-font-weight: bold;");
        Menu back=new Menu("", backLabel);
        backLabel.setOnMouseClicked(e->{
            FirstView firstView= new FirstView();
            stage.setScene(firstView.showView(stage));
        });

        menuBar.getMenus().add(back);
        mainPane.setTop(menuBar);

        root.setStyle("-fx-background-image: url('allSet.png')");
        mainPane.setCenter(root);
        Scene scene = new Scene(mainPane, 499, 325);
       // scene.getStylesheets().add("style.css");
        stage.setTitle("Welcome To Library Art");
        return scene;
    }
}
