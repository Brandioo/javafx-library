package views;

import BookView.AllBookView;
import BookView.BookFindingView;
import BookView.BookStockRegistrationView;
import BookView.BuyBookView;
import ClientView.AllClientView;
import ClientView.ClientFindingView;
import ClientView.ClientSignUpView;
import EmployeesView.AllUsersView;
import EmployeesView.FindEmployeeView;
import LibraryManagementFunctionFactory.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Employee;

public class HomeView {
    private Employee currentUser;

    public HomeView(Employee currentUser) {
        this.currentUser = currentUser;
    }

    public Scene execute(Stage stage) {
        //StackPane root = new StackPane();

        BorderPane mainPane = new BorderPane();
        MenuBar menuBar = new MenuBar();
        Menu userMenu = new Menu("User Control");
        userMenu.setStyle("-fx-font-weight: bold;");
        Menu createMenu = new Menu("Registration");
        createMenu.setStyle("-fx-font-weight: bold;");
        Menu findBookOrClient = new Menu("Find-Options");
        findBookOrClient.setStyle("-fx-font-weight: bold;");

        GridPane root1 = new GridPane();
        root1.setAlignment(Pos.CENTER);

        MenuItem getAllCartelRecord = new MenuItem("-Get All Cartel-Record Info-");
        getAllCartelRecord.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                CartelRecordFactory cartelRecordFactory = new CartelRecordFactory();
                Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                successAlert.setHeaderText("All Cartels-Record Information");
                successAlert.setContentText(cartelRecordFactory.findAllCartelRecord());
                successAlert.showAndWait();
                System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
            }

        });

        MenuItem getAllUser = new MenuItem("-Get All User Info-");
        getAllUser.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {

                EmployeeFactory employeeFactory = new EmployeeFactory();
                Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                successAlert.setHeaderText("All Users Information");
                successAlert.setContentText(employeeFactory.findAllEmployees());
                successAlert.showAndWait();
                System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
            }

        });

        MenuItem getAllUserTable = new MenuItem("-Get All User Table-");
        getAllUserTable.setStyle("-fx-font-weight: bold;");
        getAllUserTable.setId("findBook-button");
        getAllUserTable.setStyle("-fx-background-color:#01FFFF;");
        getAllUserTable.setOnAction(event -> {
            AllUsersView av= new AllUsersView(currentUser);
            Scene scene= av.showView(stage);
            stage.setScene(scene);
        });


        MenuItem getAllClients = new MenuItem("-Get All Client Info-");
        getAllClients.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {

                ClientFactory clientFactory = new ClientFactory();
                Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                successAlert.setHeaderText("All Clients Information");
                successAlert.setContentText(clientFactory.findAllClient());
                successAlert.showAndWait();
                System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
            }

        });

        MenuItem getAllClientTable = new MenuItem("-Get All Client Table-");
        getAllClientTable.setStyle("-fx-font-weight: bold;");
        getAllClientTable.setId("getAllClientTable-button");
        getAllClientTable.setStyle("-fx-background-color:#01FFFF;");
        getAllClientTable.setOnAction(event -> {
            AllClientView av= new AllClientView(currentUser);
            Scene scene= av.showView(stage);
            stage.setScene(scene);
        });


        MenuItem getAllCartels = new MenuItem("-Get All Cartel Info-");
        getAllCartels.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                CartelFactory cartelFactory = new CartelFactory();
                Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                successAlert.setHeaderText("All Cartels Information");
                successAlert.setContentText(cartelFactory.findAllCartels());
                successAlert.showAndWait();
                System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
            }

        });


        MenuItem getAllBooks = new MenuItem("-Get All Books Info-");
//        root.getChildren().add(getAllUser);

        getAllBooks.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                BookFactory bookFactory = new BookFactory();
                Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                successAlert.setHeaderText("All Books Information");
                successAlert.setContentText(bookFactory.findAllBook());
                successAlert.showAndWait();
                System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
            }

        });

        MenuItem getAllBookTable = new MenuItem("-Get All Book Table-");
        getAllBookTable.setStyle("-fx-font-weight: bold;");
        getAllBookTable.setId("getAllBookTable-button");
        getAllBookTable.setStyle("-fx-background-color:#01FFFF;");
        getAllBookTable.setOnAction(event -> {
            AllBookView av= new AllBookView(currentUser);
            Scene scene= av.showView(stage);
            stage.setScene(scene);
        });

        MenuItem getUser = new MenuItem("-Get Current User Info-");
        getUser.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText(this.currentUser.toString());
            alert.setHeaderText("The user Information");
            alert.showAndWait();

        });

        userMenu.getItems().addAll(getUser, getAllUser, getAllUserTable, getAllClients, getAllClientTable, getAllBooks,
                getAllBookTable, getAllCartels, getAllCartelRecord);

        Label logOutLabel=new Label("Log Out");
        Menu logout=new Menu("", logOutLabel);
        logOutLabel.setOnMouseClicked(e->{
            LoginView lv= new LoginView();
            stage.setScene(lv.showView(stage));
        });

        menuBar.getMenus().add(userMenu);
        mainPane.setTop(menuBar);


        Button buyBook = new Button("-Buy Book-");
        buyBook.setStyle("-fx-font-weight: bold;");
        root1.add(buyBook, 2, 3);
//        root.getChildren().add(getAllUser);

        buyBook.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
//                VendingMachine vendingMachine=new VendingMachine();
//                vendingMachine.start();
                BuyBookView buyBookView=new BuyBookView();
                buyBookView.execute(stage);
                Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                successAlert.setHeaderText("Buying Book");
                successAlert.showAndWait();
                System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
            }

        });

        MenuItem findBook = new MenuItem("-Find Book-");
        findBook.setStyle("-fx-font-weight: bold;");
        findBook.setId("findBook-button");
        findBook.setStyle("-fx-background-color:#01FFFF;");
        findBook.setOnAction(e->{
            stage.setScene(new BookFindingView().execute(stage));
        });

        MenuItem findEmployee = new MenuItem("-Find Employee-");
        findEmployee.setStyle("-fx-font-weight: bold;");
        findEmployee.setId("findBook-button");
        findEmployee.setStyle("-fx-background-color:#01FFFF;");
        findEmployee.setOnAction(e->{
            stage.setScene(new FindEmployeeView().execute(stage));
        });

        findBookOrClient.getItems().addAll(findBook, findEmployee);
        mainPane.setTop(menuBar);

        MenuItem findClients = new MenuItem("-Find Clients-");
        findClients.setStyle("-fx-font-weight: bold;");
        findClients.setId("findClients-button");
        findClients.setStyle("-fx-background-color:#01FFFF;");
        findClients.setOnAction(e->{
            stage.setScene(new ClientFindingView().execute(stage));
        });

        findBookOrClient.getItems().addAll(findClients);
        mainPane.setTop(menuBar);


        MenuItem getVerificationStatus = new MenuItem("-Verification Status-");
        getVerificationStatus.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Your Account Is Verified*");
            alert.setHeaderText("The user Information");
            alert.showAndWait();

        });

        MenuItem createClientButton = new MenuItem("-Create Client Button-");
        createClientButton.setOnAction(e->{
            stage.setScene(new ClientSignUpView().execute(stage));
        });

        MenuItem createBookButton = new MenuItem("-Create Book Button-");
        createBookButton.setOnAction(e->{
            stage.setScene(new BookStockRegistrationView().execute(stage));
        });

        createMenu.getItems().addAll(getVerificationStatus, createClientButton, createBookButton);

        menuBar.getMenus().add(createMenu);
        menuBar.getMenus().add(findBookOrClient);
        menuBar.getMenus().add(logout);
        mainPane.setTop(menuBar);

        mainPane.setCenter(root1);

        HBox hBox=new HBox();

        // create a background fill
        BackgroundFill background_fill = new BackgroundFill(Color.ROSYBROWN,
                CornerRadii.EMPTY, Insets.EMPTY);

        // create Background
        Background background = new Background(background_fill);

        // set background
        root1.setBackground(background);



        root1.setStyle("-fx-background-image: url('img_1.png')");
        Scene sc = new Scene(mainPane, 1000, 729);
        sc.getStylesheets().add("style.css");
        stage.setTitle("Home");

        return sc;
    }

}
