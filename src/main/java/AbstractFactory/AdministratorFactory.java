package AbstractFactory;

import LibraryManagementFunctionFactory.LibraryManagementOptionsFactory;
import model.Employee;

import java.util.Optional;
import java.util.Scanner;

public class AdministratorFactory implements StatusCategory{

    @Override
    public Optional<Employee> getAction() {
        LibraryManagementOptionsFactory libraryManagementOptionsFactory=new LibraryManagementOptionsFactory();
        Employee employee=new Employee();
        System.out.println("__________________________________________________");
        System.out.println("Welcome " + employee.getUser() + " you are Admin");
        boolean t = true;
        while (t) {
            System.out.println("Please choose one action: ");
            System.out.println("1. Find All Book");
            System.out.println("2. Find All Cartel Record: ");
            System.out.println("3. Verification: ");
            System.out.println("4. Find All Employees");
            System.out.println("5. Log out: ");
            Scanner sc = new Scanner(System.in);
            int number=sc.nextInt();
            switch (number) {
                case 1:
                    libraryManagementOptionsFactory.findAllBook();
                    break;
                case 2:

                    libraryManagementOptionsFactory.findAllCartelRecord();
                    break;
                case 3:
                    System.out.println("Your Account Is Verified*");
                    break;
                case 4:
                    libraryManagementOptionsFactory.findAllEmployees();
                    break;
                case 5:
                    t = false;
                    System.out.println("-You are logged out.-");
                    break;
            }

            System.out.println("__________________________________________________");
        }
        return Optional.empty();
    }
}
