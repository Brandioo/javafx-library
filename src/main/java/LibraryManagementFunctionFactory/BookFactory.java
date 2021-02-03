package LibraryManagementFunctionFactory;

import model.Book;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BookFactory {
    Session session = HibernateUtils.getSessionFactory().openSession();
    private ArrayList<Book> books;

    public BookFactory(Session session) {
        this.session = session;
    }

    public BookFactory() {
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public void createBook(final Book book) {

        Transaction transaction = session.beginTransaction();

        session.save(book);

        transaction.commit();

    }

    public String findAllBook() {
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-");
        System.out.println("Print All From Book: ");
        session.createQuery("from Book").getResultList().forEach(System.out::println);
        return null;
    }

    public List<Book> findAllBookList() {
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-");
        System.out.println("Print All From Book: ");
        Query query = session.createQuery("from Book");

        List<Book> books = query.getResultList();
        session.close();
        return books;

    }

    public Book findBooksByName(String bookName) {

        Query query = session.createQuery("select b from Book b where b.bookName=:bookName");
        query.setParameter("bookName", bookName);
        List<Book> books = query.getResultList();

        Book book = null;

        if (!books.isEmpty()) {
            return books.get(0);
        }
        session.close();
        return book;
    }

    public Book findBooksByISBN(String isbn) {

        Query query = session.createQuery("select b from Book b where b.isbn=:isbn");
        query.setParameter("isbn", isbn);
        List<Book> books = query.getResultList();

        Book book = null;

        if (!books.isEmpty()) {
            return books.get(0);
        }
        session.close();
        return book;
    }

    public boolean createBookButton(String bookName, String genere, String isbn,
                                    String description, Integer quantity, Integer price, LocalDateTime createdOn) {

        // the data are okay
        // create the user
        Book book = new Book(bookName, genere, isbn, description, quantity, price, createdOn);
        //this.book.add(book);
        createBook(book);
        return true;

    }

    public Book findBookByID(int Id) {
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-");
        System.out.println("Print All From Book by id: ");
        return session.find(Book.class, Id);
    }

    public void editBook(Book updatedBook, int position) {
//        this.books.set(position, updatedBook);
//        createBook(updatedBook);
//        Session session = sessionFactory.openSession();
//        Transaction tx = session.beginTransaction();
//
//        String hqlUpdate = "update Customer c set c.name = :newName where c.name = :oldName";
//// or String hqlUpdate = "update Customer set name = :newName where name = :oldName";
//        int updatedEntities = s.createQuery( hqlUpdate )
//                .setString( "newName",   )
//                .setString( "oldName", oldName )
//                .executeUpdate();
//        tx.commit();
//        session.close();
        this.books.set(position, updatedBook);
        createBook(updatedBook);
//    }
    }
}
