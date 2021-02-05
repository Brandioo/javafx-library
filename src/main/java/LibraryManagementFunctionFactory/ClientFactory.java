package LibraryManagementFunctionFactory;

import model.Client;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ClientFactory {
    Session session = HibernateUtils.getSessionFactory().openSession();
    private ArrayList<Client> clients;

    public ClientFactory(Session session) {
        this.session = session;
    }

    public ClientFactory() {
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public void createClient(final Client client) {
        Transaction transaction = session.beginTransaction();

        session.save(client);

        transaction.commit();
    }

    public Client findClientByID(int Id) {
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-");
        System.out.println("Print All From Employee by id: ");
        return session.find(Client.class, Id);
    }

    public String findAllClient() {
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-");
        System.out.println("Print All From Client: ");
        session.createQuery("from Client").getResultList().forEach(System.out::println);
        return null;
    }

    public List<Client> findAllClientList() {
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-");
        System.out.println("Print All From Clients: ");
        Query query = session.createQuery("from Client ");

        List<Client> clients = query.getResultList();
        session.close();
        return clients;

    }

    public Client findClientsByName(String firstName) {

        Query query  = session.createQuery("select c from Client c where c.firstName=:firstName");
        query.setParameter("firstName", firstName);
        List<Client> clients = query.getResultList();

        Client client = null;

        if (!clients.isEmpty()) {
            return clients.get(0);
        }
        session.close();
        return client;
    }


    public boolean createClientButton( String firstName, String lastName, String email,
                                       String phoneNumber, String address, LocalDateTime createdOn) {

        // the data are okay
        // create the user
        Client client = new Client(firstName, lastName, email, phoneNumber, address, createdOn);
        //this.client.add(client);
        createClient(client);
        return true;

    }

    public void editClient(Client updatedClient) {
        session = HibernateUtils.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();

        session.update(updatedClient);

        transaction.commit();

    }
}
