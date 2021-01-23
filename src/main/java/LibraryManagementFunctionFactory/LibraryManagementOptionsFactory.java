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


    public LibraryManagementOptionsFactory(Session session) {
        this.session = session;
    }

    public LibraryManagementOptionsFactory() {
    }

    public void setSession(Session session) {
        this.session = session;
    }
    //    public void createTable() {
//            try (final Statement createTableStatement = session..createStatement()) {
//                final String createTableQuery = "CREATE TABLE IF NOT EXISTS MOVIES (id INTEGER AUTO_INCREMENT, " +
//                        "title VARCHAR(255), " +
//                        "genre VARCHAR(255), " +
//                        "yearOfRelease INTEGER, " +
//                        "PRIMARY KEY (id))";
//                createTableStatement.execute(createTableQuery);
//            } catch (final SQLException exp) {
//                throw new DatabaseActionException(exp);
//            }
//        }
//
//        public void deleteTable() {
//            try (final Statement deleteStructureStatement = connection.createStatement()) {
//                deleteStructureStatement.execute("DROP TABLE MOVIES");
//            } catch (final SQLException exp) {
//                throw new DatabaseActionException(exp);
//            }
//        }
//
//        public void createMovie(final Movie movie) {
//            try (final PreparedStatement insertItemStatement = connection.prepareStatement("INSERT INTO MOVIES (title, genre, yearOfRelease) VALUES (?, ?, ?)")) {
//                insertItemStatement.setString(1, movie.getTitle());
//                insertItemStatement.setString(2, movie.getGenre());
//                insertItemStatement.setInt(3, movie.getYearOfRelease());
//                insertItemStatement.executeUpdate();
//            } catch (final SQLException exp) {
//                throw new DatabaseActionException(exp);
//            }
//        }
//
//        public void deleteMovie(final int id) {
//            try (final PreparedStatement deleteItemStatement = connection.prepareStatement("DELETE FROM MOVIES WHERE id = ?")) {
//                deleteItemStatement.setInt(1, id);
//                deleteItemStatement.executeUpdate();
//            } catch (final SQLException exp) {
//                throw new DatabaseActionException(exp);
//            }
//        }
//
//        public void updateMoviesTitle(final int id, final String newTitle) {
//            try (PreparedStatement updateStatement = connection.prepareStatement("UPDATE MOVIES SET title = ? WHERE id = ?")) {
//                updateStatement.setString(1, newTitle);
//                updateStatement.setInt(2, id);
//                updateStatement.executeUpdate();
//            } catch (final SQLException exp) {
//                throw new DatabaseActionException(exp);
//            }
//        }
//
//        public Optional<Movie> findMovieById(final int id) {
//            try (PreparedStatement searchStatement = connection.prepareStatement("SELECT * FROM MOVIES WHERE id = ?")) {
//                searchStatement.setInt(1, id);
//                final boolean searchResult = searchStatement.execute();
//                if (searchResult) {
//                    final ResultSet foundMovie = searchStatement.getResultSet();
//                    if (foundMovie.next()) {
//                        final String title = foundMovie.getString(2);
//                        final String genre = foundMovie.getString(3);
//                        final Integer yearOfRelease = foundMovie.getInt(4);
//                        return Optional.of(new Movie(id, title, genre, yearOfRelease));
//                    }
//                }
//                return Optional.empty();
//            } catch (final SQLException exp) {
//                throw new DatabaseActionException(exp);
//            }
//
//        }


//    public Optional<Employee> findEmployeeById(final int id) {
//        try (PreparedStatement searchStatement = connection.prepareStatement("SELECT * FROM employee WHERE id = ?")) {
//            searchStatement.setInt(1, id);
//            final boolean searchResult = searchStatement.execute();
//            if (searchResult) {
//                final ResultSet foundEmployee = searchStatement.getResultSet();
//                if (foundEmployee.next()) {
//                    final String firstName = foundEmployee.getString(2);
//                    final String lastName = foundEmployee.getString(3);
//                    final Date dateOfbirth = foundEmployee.getDate(4);
//                    final String email=foundEmployee.getString(5);
//                    final String role=foundEmployee.getString(6);
//                    final String user=foundEmployee.getString(7);
//                    final String password=foundEmployee.getString(8);
//                    final String createdBy=foundEmployee.getString(9);
//                    final String modifiedBy=foundEmployee.getString(7);
//                    return Optional.of(new Employee(firstName,lastName,dateOfbirth,email,role,user,password,createdBy,modifiedBy));
//                }
//            }
//            return Optional.empty();
//        } catch (final SQLException exp) {
//            throw new DatabaseActionException(exp);
//        }
//    }
//
// public Query login(String user, String password){
//     Query query = (Query) session.createQuery("select e from Employee e where e.user=user and e.password=password");
//     return query;
// }

    public ArrayList<Employee> getUsers() {
        return employees;
    }

    public void deleteUser(Employee u) {
        employees.remove(u);
    }


    public void addUser(Employee u) {
        employees.add(u);
    }



    public void createEmployee(final Employee employee) {
        Transaction transaction = session.beginTransaction();

        session.save(employee);

        transaction.commit();
    }

    public void createClient(final Client client) {
        Transaction transaction = session.beginTransaction();

        session.save(client);

        transaction.commit();
    }

    public void createBook(final Book book) {
        Transaction transaction = session.beginTransaction();

        session.save(book);

        transaction.commit();
    }

    public void createCartel(final Cartel cartel) {
        Transaction transaction = session.beginTransaction();

        session.save(cartel);

        transaction.commit();
    }

    public void createCartelRecord(final CartelRecord cartelRecord) {
        Transaction transaction = session.beginTransaction();

        session.save(cartelRecord);

        transaction.commit();
    }

    public void findAdministrator() {
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-");
        System.out.println("Print All From Administrator from Employee: ");
        session.createQuery("select e.firstName from Employee e where e.role='Manager'").getResultList().forEach(System.out::println);
    }

    public void findOperator() {
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-");
        System.out.println("Print All From Sellers from Employee: ");
        session.createQuery("select e.firstName from Employee e where e.role='Seller'").getResultList().forEach(System.out::println);
    }

    public Employee findAllEmployeesByID(int Id) {
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-");
        System.out.println("Print All From Employee by id: ");
        return session.find(Employee.class, Id);
    }

    public Client findClientByID(int Id) {
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-");
        System.out.println("Print All From Employee by id: ");
        return session.find(Client.class, Id);
    }

    public Book findBookByID(int Id) {
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-");
        System.out.println("Print All From Employee by id: ");
        return session.find(Book.class, Id);
    }

    public String findAllEmployees() {
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-");
        System.out.println("Print All From Employee: ");
        session.createQuery("from Employee ").getResultList().forEach(System.out::println);
        return null;
    }

    public void findAllEmployeesNames() {
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-");
        System.out.println("Print All Names From Employee: ");
        session.createQuery("select e.firstName from Employee e").getResultList().forEach(System.out::println);
    }

    public String findAllCartels() {
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-");
        System.out.println("Print All From Cartels: ");
        session.createQuery("from Cartel").getResultList().forEach(System.out::println);
        return null;
    }

    public String findAllCartelRecord() {
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-");
        System.out.println("Print All From CartelRecord: ");
        session.createQuery("from CartelRecord").getResultList().forEach(System.out::println);
        return null;
    }

    public String findAllClient() {
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-");
        System.out.println("Print All From Client: ");
        session.createQuery("from Client").getResultList().forEach(System.out::println);
        return null;
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

    public Employee findEmployeeID() {
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-");
        System.out.println("Print All From Book: ");
        Query query = session.createQuery("select e.employeesId from Employee e");
        Employee employee= (Employee) query.getResultList();
        session.close();
        return employee;

    }


    public Employee logIn(String user, String password) {

        Query query  = session.createQuery("select e from Employee e where e.user=:user and e.password=:password");
        query.setParameter("user", user);
        query.setParameter("password", password);
        List<Employee> employees = query.getResultList();

        Employee employee = null;

        if (!employees.isEmpty()) {
            return employees.get(0);
        }
        session.close();
        return employee;
    }


    public boolean signUp( String firstName, String lastName, LocalDate dateOfBirth, String email,
                          String phoneNumber, String role, String user, String password, String verifiedPassword,
                          LocalDateTime createdOn) {
        if (password.equals(verifiedPassword)) {
            // the data are okay
            // create the user
            Employee employee = new Employee( firstName, lastName, dateOfBirth, email, phoneNumber, role
                    , user, password, createdOn);
            //this.employees.add(employee);
            createEmployee(employee);
            return true;
        }
        return false;
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

    public boolean createBookButton(String bookName, String genere, String isbn,
                                       String description, Integer quantity, Integer price, LocalDateTime createdOn) {

        // the data are okay
        // create the user
        Book book = new Book(bookName, genere, isbn, description, quantity, price, createdOn);
        //this.book.add(book);
        createBook(book);
        return true;

    }

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

    public boolean logOutButton() {
        return false;
    }
}

