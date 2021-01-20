package LibraryManagementFunctionFactory;

import model.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtils;


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

    public void findAllEmployees() {
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-");
        System.out.println("Print All From Employee: ");
        session.createQuery("from Employee").getResultList().forEach(System.out::println);
    }

    public void findAllCartels() {
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-");
        System.out.println("Print All From Cartels: ");
        session.createQuery("from Cartel").getResultList().forEach(System.out::println);
    }

    public void findAllCartelRecord() {
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-");
        System.out.println("Print All From CartelRecord: ");
        session.createQuery("from CartelRecord").getResultList().forEach(System.out::println);
    }

    public void findAllClient() {
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-");
        System.out.println("Print All From Client: ");
        session.createQuery("from Client").getResultList().forEach(System.out::println);
    }

    public void findAllBook() {
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-");
        System.out.println("Print All From Book: ");
        session.createQuery("from Book").getResultList().forEach(System.out::println);
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
}

