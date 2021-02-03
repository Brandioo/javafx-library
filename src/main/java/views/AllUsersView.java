package views;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


import LibraryManagementFunctionFactory.EmployeeFactory;
import LibraryManagementFunctionFactory.LibraryManagementOptionsFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.DateStringConverter;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.LocalDateStringConverter;
import model.Employee;

public class AllUsersView {
    private Employee currentEmployee;

    public AllUsersView(Employee u){
        this.currentEmployee = u;
    }

    public Scene showView(Stage stage) {

        VBox root= new VBox();
        EmployeeFactory employeeFactory= new EmployeeFactory();
        List<Employee> employees =employeeFactory.findAllEmployeeList();
        ObservableList<Employee> list=FXCollections.observableArrayList(employees);

        TableView<Employee> table = new TableView();
        table.setItems(list);
        table.setEditable(true);

        TableColumn firstNameColumn = new TableColumn("First Name");
        firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        firstNameColumn.setCellValueFactory(new PropertyValueFactory("firstName"));
        firstNameColumn.setOnEditCommit(new EventHandler<CellEditEvent>(){

            @Override
            public void handle(CellEditEvent t) {
                // TODO Auto-generated method stub

                Employee currentEmployee= (Employee) t.getTableView().getItems().get(t.getTablePosition().getRow());
                int pos= table.getSelectionModel().getSelectedIndex();
                String newFirstName=(String) t.getNewValue();

                currentEmployee.setFirstName(newFirstName);
                employeeFactory.editEmployee(currentEmployee, pos);
            }

        });



        TableColumn lastNameColumn = new TableColumn("Last Name");
        lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        lastNameColumn.setCellValueFactory(new PropertyValueFactory("lastName"));
        lastNameColumn.setOnEditCommit(new EventHandler<CellEditEvent>(){

            @Override
            public void handle(CellEditEvent t) {
                // TODO Auto-generated method stub

                Employee currentUser= (Employee) t.getTableView().getItems().get(t.getTablePosition().getRow());
                int pos= table.getSelectionModel().getSelectedIndex();
                String newLastName=(String) t.getNewValue();

                currentUser.setLastName(newLastName);
                employeeFactory.editEmployee(currentUser, pos);
            }

        });

        TableColumn dateOfBirth = new TableColumn("Date Of Birth");
        dateOfBirth.setCellFactory(TextFieldTableCell.forTableColumn(new LocalDateStringConverter()));
        dateOfBirth.setCellValueFactory(new PropertyValueFactory("dateOfBirth"));
        dateOfBirth.setOnEditCommit(new EventHandler<CellEditEvent>(){

            @Override
            public void handle(CellEditEvent t) {
                // TODO Auto-generated method stub

                Employee currentUser= (Employee) t.getTableView().getItems().get(t.getTablePosition().getRow());
                int pos= table.getSelectionModel().getSelectedIndex();
                LocalDate newDateOfBirth= (LocalDate) t.getNewValue();

                currentUser.setDateOfBirth(newDateOfBirth);
                employeeFactory.editEmployee(currentUser, pos);
            }

        });

        TableColumn emailColumn = new TableColumn("Email");
        emailColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        emailColumn.setCellValueFactory(new PropertyValueFactory("email"));
        emailColumn.setOnEditCommit(new EventHandler<CellEditEvent>(){

            @Override
            public void handle(CellEditEvent t) {
                // TODO Auto-generated method stub

                Employee currentEmployee= (Employee) t.getTableView().getItems().get(t.getTablePosition().getRow());
                int pos= table.getSelectionModel().getSelectedIndex();
                String newEmail=(String) t.getNewValue();

                currentEmployee.setEmail(newEmail);
                employeeFactory.editEmployee(currentEmployee, pos);
            }

        });

        TableColumn phoneNumberColumn = new TableColumn("Phone Number");
        phoneNumberColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory("phoneNumber"));
        phoneNumberColumn.setOnEditCommit(new EventHandler<CellEditEvent>(){

            @Override
            public void handle(CellEditEvent t) {
                // TODO Auto-generated method stub

                Employee currentEmployee= (Employee) t.getTableView().getItems().get(t.getTablePosition().getRow());
                int pos= table.getSelectionModel().getSelectedIndex();
                String newPhoneNumber=(String) t.getNewValue();

                currentEmployee.setPhoneNumber(newPhoneNumber);
                employeeFactory.editEmployee(currentEmployee, pos);
            }

        });

        TableColumn roleColumn = new TableColumn("Role ");
        roleColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        roleColumn.setCellValueFactory(new PropertyValueFactory("role"));
        roleColumn.setOnEditCommit(new EventHandler<CellEditEvent>(){

            @Override
            public void handle(CellEditEvent t) {
                // TODO Auto-generated method stub

                Employee currentEmployee= (Employee) t.getTableView().getItems().get(t.getTablePosition().getRow());
                int pos= table.getSelectionModel().getSelectedIndex();
                String newRole=(String) t.getNewValue();

                currentEmployee.setRole(newRole);
                employeeFactory.editEmployee(currentEmployee, pos);
            }

        });

        TableColumn userColumn = new TableColumn("User ");
        userColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        userColumn.setCellValueFactory(new PropertyValueFactory("user"));
        userColumn.setOnEditCommit(new EventHandler<CellEditEvent>(){

            @Override
            public void handle(CellEditEvent t) {
                // TODO Auto-generated method stub

                Employee currentEmployee= (Employee) t.getTableView().getItems().get(t.getTablePosition().getRow());
                int pos= table.getSelectionModel().getSelectedIndex();
                String newUser=(String) t.getNewValue();

                currentEmployee.setUser(newUser);
                employeeFactory.editEmployee(currentEmployee, pos);
            }

        });

        TableColumn passwordColumn = new TableColumn("Password");
        passwordColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        passwordColumn.setCellValueFactory(new PropertyValueFactory("password"));
        passwordColumn.setOnEditCommit(new EventHandler<CellEditEvent>(){

            @Override
            public void handle(CellEditEvent t) {
                // TODO Auto-generated method stub

                Employee currentEmployee= (Employee) t.getTableView().getItems().get(t.getTablePosition().getRow());
                int pos= table.getSelectionModel().getSelectedIndex();
                String newPassword=(String) t.getNewValue();

                currentEmployee.setPassword(newPassword);
                employeeFactory.editEmployee(currentEmployee, pos);
            }

        });



        table.getColumns().addAll(firstNameColumn, lastNameColumn, dateOfBirth, emailColumn, phoneNumberColumn, roleColumn, userColumn, passwordColumn);

        Button save= new Button("Save");
        save.setOnAction(e->{
            HomeView hv = new HomeView(currentEmployee);
            stage.setScene(hv.execute(stage));
        });

        root.getChildren().addAll(table, save);

        Scene scene= new Scene(root, 450, 450);
        return scene;


    }
}

