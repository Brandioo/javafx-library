package views;

import LibraryManagementFunctionFactory.LibraryManagementOptionsFactory;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Employee;

public class FirstView {
    public Scene showView(Stage stage) {
        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setAlignment(Pos.BOTTOM_CENTER);


        Button enterButton = new Button(" ENTER To The Library Management - Art ");
        enterButton.setTextFill(Color.web("white"));
        enterButton.setStyle("-fx-font-weight: bold;");
        enterButton.setId("enterButton-button");
        enterButton.setStyle("-fx-background-color:#405f1a;");
        HBox h = new HBox();
        h.getChildren().add(enterButton);
        root.add(enterButton, 0, 0);

        enterButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                successAlert.setHeaderText("Successful Click");
                successAlert.setContentText("Second Stage");
//                    HomeView homeView=new HomeView(loggedIn);
//                    stage.setScene(homeView.execute(stage));
                successAlert.showAndWait();
                stage.setScene(new SecondView().showView(stage));
                successAlert.close();

            }
        });

        root.setStyle("-fx-background-image: url('untitledDesign2.png')");
        Scene scene = new Scene(root, 500, 500);
        scene.getStylesheets().add("style.css");
        stage.setTitle("Welcome To Our Company");
        return scene;
    }
}
