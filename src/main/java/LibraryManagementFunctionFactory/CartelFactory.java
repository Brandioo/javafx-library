package LibraryManagementFunctionFactory;

import model.Cartel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtils;

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

    public String findAllCartels() {
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-");
        System.out.println("Print All From Cartels: ");
        session.createQuery("from Cartel").getResultList().forEach(System.out::println);
        return null;
    }
}
