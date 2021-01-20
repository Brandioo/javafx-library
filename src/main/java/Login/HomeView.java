package Login;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.Employee;

public class HomeView {
    private Employee currentUser;

    public HomeView(Employee currentUser) {
        this.currentUser = currentUser;
    }

    public Scene execute(Stage stage) {
        StackPane root = new StackPane();

        Button getUser=new Button("Get User Info");
        root.getChildren().add(getUser);

        getUser.setOnAction(e->{
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText(this.currentUser.toString());
            alert.setHeaderText("The user Information");
            alert.showAndWait();

        });

        Scene sc=new Scene(root,300,300);
        stage.setTitle("Home");

        return sc;
    }
}
