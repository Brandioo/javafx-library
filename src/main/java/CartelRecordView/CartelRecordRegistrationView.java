package CartelRecordView;

import BookView.BookFindingView;
import BookView.BuyBookView;
import CartelView.CartelRegistrationView;
import ClientView.ClientFindingView;
import EmployeesView.FindEmployeeView;
import LibraryManagementFunctionFactory.*;
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
import model.CartelRecord;
import model.Employee;
import views.HomeView;
import views.PaymentTypeView;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CartelRecordRegistrationView {
    private Employee currentUser;
    private Book currentBook;
    private Cartel currentCartel;

    public CartelRecordRegistrationView(Cartel currentCartel) {
        this.currentCartel = currentCartel;
    }

    public CartelRecordRegistrationView() {
    }

    public Scene execute(Stage stage) {
        GridPane root1 = new GridPane();
        root1.setHgap(10);
        root1.setVgap(10);
        root1.setPadding(new Insets(10, 10, 10, 10));
        root1.setAlignment(Pos.TOP_CENTER);


        Menu userMenu = new Menu("User Control");
//        userMenu.setStyle("-fx-font-weight: bold;");

//        Label priceLabel = new Label("Price: ");
//        priceLabel.setTextFill(Color.web("white"));
//        priceLabel.setStyle("-fx-font-weight: bold;");
//        root1.add(quantityLabel, 1, 7);
//        root1.add(spinner2,2,7);
//        TextField priceField = new TextField();
//        root1.add(priceField, 2, 8);

        Spinner<Integer> spinner1 = new Spinner<>(1, 3000, 2021);

        Spinner<Integer> spinner2 = new Spinner<>(1, 12, 1);

        Spinner<Integer> spinner3 = new Spinner<>(1, 31, 1);

        Spinner<Integer> spinner4 = new Spinner<>(1, 23, 0);

        Spinner<Integer> spinner5 = new Spinner<>(1, 59, 0);

        Spinner<Integer> spinner6 = new Spinner<>(1, 2000, 1);

        Spinner<Integer> spinner7 = new Spinner<>(1, 2000, 1);

        Label yearLabel = new Label("Return Year:");
        yearLabel.setTextFill(Color.DEEPSKYBLUE);
        yearLabel.setStyle("-fx-font-weight: bold;");
        root1.add(yearLabel, 1, 1);
        root1.add(spinner1, 2, 1);

        Label returnMonthLabel = new Label("Return Month:");
        returnMonthLabel.setTextFill(Color.DEEPSKYBLUE);
        returnMonthLabel.setStyle("-fx-font-weight: bold;");
        root1.add(returnMonthLabel, 1, 2);
        root1.add(spinner2, 2, 2);

        Label returnDayLabel = new Label("Return Day:");
        returnDayLabel.setTextFill(Color.DEEPSKYBLUE);
        returnDayLabel.setStyle("-fx-font-weight: bold;");
        root1.add(returnDayLabel, 1, 3);
        root1.add(spinner3, 2, 3);

        Label returnHourLabel = new Label("Hour:");
        returnHourLabel.setTextFill(Color.DEEPSKYBLUE);
        returnHourLabel.setStyle("-fx-font-weight: bold;");
        root1.add(returnHourLabel, 1, 4);
        root1.add(spinner4, 2, 4);

        Label returnMinuteLabel = new Label("Minute:");
        returnMinuteLabel.setTextFill(Color.DEEPSKYBLUE);
        returnMinuteLabel.setStyle("-fx-font-weight: bold;");
        root1.add(returnMinuteLabel, 1, 5);
        root1.add(spinner5, 2, 5);

        Label bookIDLabel = new Label("Book ID: ");
        bookIDLabel.setTextFill(Color.DEEPSKYBLUE);
        bookIDLabel.setStyle("-fx-font-weight: bold;");
        root1.add(bookIDLabel, 1, 6);
        root1.add(spinner6, 2, 6);

        Label clientID=new Label("Cartel ID (ID of Last Cartel): ");
        clientID.setTextFill(Color.DEEPSKYBLUE);
        clientID.setStyle("-fx-font-weight: bold;");
        root1.add(clientID,1,7);
        root1.add(spinner7,2,7);

        Label createdOnLabel = new Label("Created On (Auto Calc Now): ");
        createdOnLabel.setTextFill(Color.DEEPSKYBLUE);
        createdOnLabel.setStyle("-fx-font-weight: bold;");
        TextField createdOnField = new TextField();
        root1.add(createdOnLabel, 1, 8);
        root1.add(createdOnField, 2, 8);

        Button createCartelButton = new Button("-Cartel Record Registration-");
        createCartelButton.setStyle("-fx-font-weight: bold;"); //letters are written in bold type
        createCartelButton.setTextFill(Color.DEEPSKYBLUE); //Letters of findButton is LIGHTBLUE
        createCartelButton.setId("createCartelButton-button");
        createCartelButton.setStyle("-fx-background-color:#000000;"); //Background is Black
        HBox h1 = new HBox(); //Declare h box
        h1.getChildren().add(createCartelButton); //Adding button inside the hBox
        root1.add(createCartelButton, 2, 9);

        createCartelButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                //String description = descriptionArea.getText();
                // boolean isRememberMe = remember.isSelected();

                CartelFactory cartelFactory = new CartelFactory();
                CartelRecordFactory cartelRecordFactory = new CartelRecordFactory();
                ClientFactory clientFactory = new ClientFactory();
                BookFactory bookFactory = new BookFactory();
                EmployeeFactory employeeFactory = new EmployeeFactory();
                CartelRecord cartelRecord = new CartelRecord();

                LocalDateTime dataStarted = LocalDateTime.now();
                cartelRecord.setDataStarted(dataStarted);

                Integer returnYear = spinner1.getValue();
                Integer returnMonth = spinner2.getValue();
                Integer returnDay = spinner3.getValue();
                Integer returnHour = spinner4.getValue();
                Integer returnMinute = spinner5.getValue();

                cartelRecord.setEndData(LocalDateTime.of(returnYear, returnMonth, returnDay, returnHour, returnMinute));

                Integer bookID = spinner6.getValue();
                cartelRecord.setBook(bookFactory.findBookByID(bookID));

                Integer cartelID = spinner7.getValue();
                cartelRecord.setCartel(cartelFactory.findCartelsByID(cartelID));

//                cartelRecord.setCartel(currentCartel);
//
//                cartelRecord.setBook(currentBook);

                LocalDateTime createdOn = LocalDateTime.now();
                cartelRecord.setCreatedOn(createdOn);

                cartelRecordFactory.createCartelRecord(cartelRecord);

                if (currentBook == null && currentCartel == null) {
                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                    errorAlert.setHeaderText("There was an error");
                    errorAlert.setContentText("Register Book With It's ID At Buy Book Section! " + "\n"
                            + "Register Cartel At Cartel Registration Section! ");
                    errorAlert.showAndWait();
                } else {
                    //Employee currentEmployee=new Employee();
                    Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                    successAlert.setHeaderText("The Cartel Record was registered successfully");
                    successAlert.showAndWait();
                    stage.setScene(new HomeView(currentUser).execute(stage));
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
            CartelRegistrationView cartelRegistrationView = new CartelRegistrationView(currentBook);
            stage.setScene(cartelRegistrationView.execute(stage));
        });

        menuBar.getMenus().add(back);
        mainPane.setTop(menuBar);

        Label buyBookView1 = new Label("Buy Book View");
//        buyBookView1.setStyle("-fx-font-weight: bold;");
        Menu buyBook = new Menu("", buyBookView1);
        buyBookView1.setOnMouseClicked(e -> {
            BuyBookView buyBookView = new BuyBookView(currentUser);
            stage.setScene(buyBookView.execute(stage));
        });

        menuBar.getMenus().add(buyBook);
        mainPane.setTop(menuBar);

        Label homeViewLabel = new Label("Home View");
//        homeViewLabel.setStyle("-fx-font-weight: bold;");
        Menu homeview = new Menu("", homeViewLabel);
        homeViewLabel.setOnMouseClicked(e -> {
            HomeView homeView = new HomeView(currentUser);
            stage.setScene(homeView.execute(stage));
        });

        menuBar.getMenus().add(homeview);
        mainPane.setTop(menuBar);

        Label findBookByIDLabel = new Label("Find Book ID");
//        findEmployeeViewLabel.setStyle("-fx-font-weight: bold;");
        Menu findBookID = new Menu("", findBookByIDLabel);
        findBookByIDLabel.setOnMouseClicked(e -> {
            BookFindingView findBookView = new BookFindingView(currentBook);
            stage.setScene(findBookView.execute(stage));
        });

        menuBar.getMenus().add(findBookID);
        mainPane.setTop(menuBar);

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

        userMenu.getItems().addAll(getAllCartels);
        mainPane.setTop(menuBar);

        menuBar.getMenus().add(userMenu);
        mainPane.setTop(menuBar);

//
//        Label findClientViewLabel=new Label("Find Client ID");
//        findClientViewLabel.setStyle("-fx-font-weight: bold;");
//        Menu findClientID=new Menu("", findClientViewLabel);
//        findClientViewLabel.setOnMouseClicked(e->{
//            FindClient findEmployeeView1= new FindEmployeeView(currentUser);
//            stage.setScene(findEmployeeView1.execute(stage));
//        });
//
//        menuBar.getMenus().add(findClientID);
//        mainPane.setTop(menuBar);

        root1.setStyle("-fx-background-image: url('img_17.png')");
        mainPane.setCenter(root1);
        Scene scene = new Scene(mainPane, 960, 350);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.setTitle("Register Cartel Records");
        stage.show();

        return scene;
    }
}
