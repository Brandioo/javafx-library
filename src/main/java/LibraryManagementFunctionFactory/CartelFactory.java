package LibraryManagementFunctionFactory;

import model.Book;
import model.Cartel;
import model.Client;
import model.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtils;

import java.time.LocalDateTime;

public class CartelFactory {
    Session session = HibernateUtils.getSessionFactory().openSession();

    public CartelFactory(Session session) {
        this.session = session;
    }

    public CartelFactory() {
    }
    public void setSession(Session session) {
        this.session = session;
    }

    public void createCartel(final Cartel cartel) {
        Transaction transaction = session.beginTransaction();

        session.save(cartel);

        transaction.commit();
    }


    public boolean createCartelSection(LocalDateTime createdOn, Client clientID, Employee employeeID) {

        // the data are okay
        // create the user
        Cartel cartel = new Cartel(createdOn, clientID, employeeID);
        //this.book.add(book);
        createCartel(cartel);
        return true;

    }

    public String findAllCartels() {
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-");
        System.out.println("Print All From Cartels: ");
        session.createQuery("from Cartel").getResultList().forEach(System.out::println);
        return null;
    }

    public Cartel findCartelsByID(int Id) {
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-");
        System.out.println("Print All From Book by id: ");
        return session.find(Cartel.class, Id);
    }

    public void editCartel(Cartel updatedCartel) {

        session = HibernateUtils.getSessionFactory().openSession();

        session.update(updatedCartel);

        session.save(updatedCartel);

    }
}
