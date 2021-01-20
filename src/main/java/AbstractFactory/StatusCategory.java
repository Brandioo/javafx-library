package AbstractFactory;

import model.Book;
import model.Employee;

import java.util.Optional;

public interface StatusCategory {
    Optional<Employee> getAction();

}
