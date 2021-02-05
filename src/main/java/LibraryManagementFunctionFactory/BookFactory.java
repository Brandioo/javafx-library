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

    public void createBook(final Book book) {

        Transaction transaction = session.beginTransaction();

        session.save(book);

        transaction.commit();

    }

    public boolean createBookSection(String bookName, String genere, String isbn,
                                     String description, Integer quantity, Integer price, LocalDateTime createdOn) {

        // the data are okay
        // create the user
        Book book = new Book(bookName, genere, isbn, description, quantity, price, createdOn);
        //this.book.add(book);
        createBook(book);
        return true;

    }


    public void editBook(Book updatedBook) {

        session = HibernateUtils.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();

        session.update(updatedBook);

        transaction.commit();

    }


//    public boolean updateBookSection(Book book, int position) {
//
//        // the data are okay
//        // create the user
//        //this.book.add(book);
//        editBook(book);
//        this.books.set(position,book);
//        return true;
//
//    }



    public Book findBookByID(int Id) {
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-");
        System.out.println("Print All From Book by id: ");
        return session.find(Book.class, Id);
    }

//    public void editBook(final Book updatedBook, int postion) {
//        Transaction transaction = session.beginTransaction();
//
//        session.update(String.valueOf(postion), updatedBook);
//
//        transaction.commit();
//    }




}
