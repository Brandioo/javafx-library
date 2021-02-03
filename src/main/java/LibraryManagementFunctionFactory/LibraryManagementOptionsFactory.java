package LibraryManagementFunctionFactory;

import model.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtils;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LibraryManagementOptionsFactory {


    Session session = HibernateUtils.getSessionFactory().openSession();
    private ArrayList<Employee> employees;
    private ArrayList<Client> clients;
    private ArrayList<Book> books;

    public LibraryManagementOptionsFactory(Session session) {
        this.session = session;
    }

    public LibraryManagementOptionsFactory() {
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public void deleteUser(Employee u) {
        employees.remove(u);
    }


    public void addUser(Employee u) {
        employees.add(u);
    }



//    public void update(Employee employee){
//        employee.setFirstName();
//    }

//    public Book findBooksID(int Id) {
//        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-");
//        System.out.println("Print All From Employee by id: ");
//        return session.find(Book.class, Id);
//    }


//    public boolean createCartelButton(LocalDateTime createdOn, String modifiedBy, Client clientId, Employee employeeId) {
//
//        // the data are okay
//        // create the user
//        Cartel cartel = new Cartel(createdOn, modifiedBy, clientId, employeeId);
//        //this.cartel.add(cartel);
//        createCartel(cartel);
//        return true;
//
//    }

//    public boolean logOutButton() {
//        return false;
//    }
}

