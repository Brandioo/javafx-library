//Brand Citozi SDA-Academy
//My Group: Xhoi Hysa, Stivi Koko, Hysnije Agalliu
import views.FirstView;
import javafx.application.Application;
import javafx.stage.Stage;
import util.HibernateUtils;

public class LibraryApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
//        GridPane root = new GridPane();
//        root.setHgap(10);
//        root.setVgap(10);
//        root.setPadding(new Insets(10, 10, 10, 10));
//
//        Label firstNameLabel= new Label("First Name");
//        TextField firstNameField = new TextField();
//        root.add(firstNameLabel, 1, 1);
//        root.add(firstNameField, 2, 1);
//
//        Label lastNameLabel= new Label("Last Name");
//        TextField lastNameField = new TextField();
//        root.add(lastNameLabel, 1, 2);
//        root.add(lastNameField, 2, 2);
//
//        Label emailLabel= new Label("Email:");
//        TextField emailField = new TextField();
//        root.add(emailLabel, 1, 3);
//        root.add(emailField, 2, 3);
//
//        Label passwordLabel = new Label("Password:");
//        PasswordField passwordField= new PasswordField();
//        root.add(passwordLabel, 1, 4);
//        root.add(passwordField, 2, 4);
//
//        Label verifyLabel = new Label("Verify Password:");
//        PasswordField verifyField= new PasswordField();
//        root.add(verifyLabel, 1, 5);
//        root.add(verifyField, 2, 5);
//
//        Label gender = new Label("Gender");
//        root.add(gender, 1, 6);
//        RadioButton male= new RadioButton("Male");
//        RadioButton female= new RadioButton("Female");
//        RadioButton other = new RadioButton("Other");
//        HBox h = new HBox();
//        h.getChildren().addAll(male, female);
//        VBox v= new VBox();
//        v.getChildren().addAll(h, other);
//        root.add(v, 2, 6);
//
//        Label descriptionLabel= new Label("Description");
//        root.add(descriptionLabel, 1, 7);
//        TextArea  descriptionArea= new TextArea();
//        root.add(descriptionArea, 2, 7);
//
//        Label professionLabel= new Label("Profession");
//        root.add(professionLabel, 1, 8);
//        ComboBox  professionDropDown= new ComboBox();
//        professionDropDown.getItems().add("Student");
//        professionDropDown.getItems().add("Teacher");
//        root.add(professionDropDown, 2, 8);
//
//        CheckBox remember = new CheckBox("Rember me?");
//        root.add(remember, 2, 9);
//
//        Button signupButton= new Button("Sing up");
//        root.add(signupButton, 2, 10);
//
//        signupButton.setOnAction(new EventHandler<ActionEvent>(){
//
//            @Override
//            public void handle(ActionEvent arg0) {
//                String firstName= firstNameField.getText();
//                String lastName= lastNameField.getText();
//                String email= emailField.getText();
//                String password= passwordField.getText();
//                String verifyPassword= verifyField.getText();
//                String gender="";
//                if(male.isSelected()){
//                    gender=male.getText();
//                    // same as gender="Male"
//                }else{
//                    if(female.isSelected()){
//                        gender=female.getText();
//                    }else{
//                        gender=other.getText();
//                    }
//                }
//                String description=descriptionArea.getText();
//                String profession = (String)professionDropDown.getValue();
//                boolean isRememberMe= remember.isSelected();
//
//                Views.UserController uc= new Views.UserController();
//                boolean isRegistered = uc.signUp(firstName, lastName, email, password, verifyPassword,gender, description, profession, isRememberMe);
//
//                if(!isRegistered){
//                    Alert errorAlert= new Alert(AlertType.ERROR);
//                    errorAlert.setHeaderText("There was an error");
//                    errorAlert.setContentText("The password and verify password don't match");
//                    errorAlert.showAndWait();
//                }else{
//                    Alert successAlert= new Alert(AlertType.CONFIRMATION);
//                    successAlert.setHeaderText("The user was registered successfully");
//                    successAlert.showAndWait();
//                }
//
//            }
//
//        });
//
//        Scene scene = new Scene(root, 700, 750);
//        primaryStage.setScene(scene);
//        primaryStage.setTitle("Sign up users!");
//        primaryStage.show();
//
//        primaryStage.setScene(new LoginView().execute(primaryStage));
//       // primaryStage.setTitle("Views.User Signing Up");

       // ClassCall.rendering();

        HibernateUtils.getSessionFactory().openSession();
        FirstView firstView=new FirstView();
        primaryStage.setScene(firstView.showView(primaryStage));
        primaryStage.show();


    }


    public static void main(String[] args) throws Exception {
        HibernateUtils.getSessionFactory();
        launch(args);

//        new AdministratorFactory();
    }
}
