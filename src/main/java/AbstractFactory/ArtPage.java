package AbstractFactory;

import LibraryManagementFunctionFactory.LibraryManagementOptionsFactory;
import Page.Page;
import model.Employee;

import java.util.Scanner;

public class ArtPage implements Page {
    private Object AdmistratorFactory;

    @Override
    public void render() {
        LibraryManagementOptionsFactory libraryManagementOptionsFactory = new LibraryManagementOptionsFactory();
        libraryManagementOptionsFactory.findAdministrator();
        libraryManagementOptionsFactory.findOperator();
        Scanner sc = new Scanner(System.in);
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
        System.out.println("Welcome To Library 'Art'");
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
        System.out.println("Please Choose One Category Of Your Status (Administrator or Operator)");
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
        String categoryWork = sc.nextLine();
        ArtFactoryProducer.getCategory(categoryWork);
        if ("Administrator".equalsIgnoreCase(categoryWork)) {
            System.out.println("******************************");
            System.out.println("Welcome To Our Company!");
            while (true) {
                System.out.println("-Write your Username Of Your Signed Up Account:  ");
                String username1 = sc.nextLine();
                System.out.println("----------------------------------");
                System.out.println("-Write your Password Of Your Signed Up Account: ");
                //Password inputted
                String password = sc.nextLine();
                new AdministratorFactory();
//                Employee e = libraryManagementOptionsFactory.checkLogin(username1, password);
//
//                if (e instanceof PasswordChecker) {
//                    AdministratorFactory admistratorFactory = new AdministratorFactory();
//                    admistratorFactory.getAction();
//                } else {
//                    System.out.println(" -_-_-_-_-_-_-_-_-_-_-_-_-");
//                    System.out.println("Your info is not correct! ");
//                    System.out.println("Please try again");
//                    System.out.println(" -_-_-_-_-_-_-_-_-_-_-_-_-");
//                    break;
//                }


            }
        } else if ("Operator".equalsIgnoreCase(categoryWork)) {
            System.out.println("******************************");
            System.out.println("Welcome To Our Company!");
            while (true) {
                System.out.println("-Write your Username Of Your Signed Up Account:  ");
                String username1 = sc.nextLine();
                System.out.println("----------------------------------");
                System.out.println("-Write your Password Of Your Signed Up Account: ");
                //Password inputted
                String password = sc.nextLine();

             //   Employee e = libraryManagementOptionsFactory.checkLogin(username1, password);

//                if (e instanceof PasswordChecker) {
//                    OperatorFactory operatorFactory = new OperatorFactory();
//                    operatorFactory.getAction();
//                } else {
//                    System.out.println(" -_-_-_-_-_-_-_-_-_-_-_-_-");
//                    System.out.println("Your info is not correct! ");
//                    System.out.println("Please try again");
//                    System.out.println(" -_-_-_-_-_-_-_-_-_-_-_-_-");
//                    break;
//                }

                new OperatorFactory();
            }
        } else System.out.println("There is no class related to this name->" + categoryWork);
    }
}
