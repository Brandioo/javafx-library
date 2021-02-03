package vendingMachine.models;


import LibraryManagementFunctionFactory.*;
import model.Book;
import model.Cartel;
import model.CartelRecord;
import model.Client;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;


public class VendingMachine {
    Scanner sc = new Scanner(System.in);
    BookFactory bookFactory=new BookFactory();
    List<Book> books=bookFactory.findAllBookList();
    private int balance = 0;
    private int diffRemainingAmount;

    public void start() {

        while (true) {
            System.out.println("--------------------------------------------------");
            System.out.println("Balance " + balance + " ALL");
            displayMenu();
            Optional<Book> book = findBook();
            if (book.isPresent()) {
                buyProduct(book.get());
            }
        }
    }

    private void buyProduct(Book book) {
        System.out.println("--------------------------------------------------");
        System.out.println("Please Enter " + book.getPrice() + " ALL (Only 10,20,50,100)");

        int coins = sc.nextInt();
        while (!(coins == 10 || coins == 20 || coins == 50 || coins == 100)) {
            System.out.println("Coin Not Supported");
            System.out.println("Please Enter " + book.getPrice() + " ALL (Only 10,20,50,100)");
            coins = sc.nextInt();

        }
            if (coins >= book.getPrice()) {

                balance += book.getPrice();

                if (coins == book.getPrice()) {
                    Cartel cartel = inputOfCartel();

                    inputOfCartelRecord(book, cartel);

                    System.out.println("--------------------------------------------------");
                    System.out.println("Here is Your Product " + book.getBookName() + ". Enjoy!");
                    book.setQuantity(book.getQuantity() - 1);
                } else if (coins > book.getPrice()) {
                    Cartel cartel = inputOfCartel();

                    inputOfCartelRecord(book, cartel);

                    System.out.println("--------------------------------------------------");
                    book.setQuantity(book.getQuantity() - 1);
                    double totalDiff = coins - book.getPrice();
                    System.out.println("Leftover given to you is- " + totalDiff + " ALL ");
                    System.out.println("Here is Your Product " + book.getBookName() + ". Enjoy!");
                }

            } else
                if (coins < book.getPrice()) {
                    System.out.println("--------------------------------------------------");

                    int totalDiff=0;
                    while (totalDiff < book.getPrice()) {
                    diffRemainingAmount = book.getPrice() - coins;
                    totalDiff = Math.round(diffRemainingAmount);
                    System.out.println("Please Give The Remaining Amount-" + totalDiff + " ALL ");
                        displayMenu();
                        totalDiff = sc.nextInt();

                    if (totalDiff == 10 || totalDiff == 20 || totalDiff == 50 || totalDiff == 100) {
                        coins += totalDiff;

                    }else {
                        System.out.println("Not Supported. Enter another coin (10,20,50,100)");

                    }
                        book.setQuantity(book.getQuantity() - 1);
                        int leftOverAfterPilaf = book.getPrice() - coins;
                        double totalLeftOverAfterPilaf = Math.round(leftOverAfterPilaf * 1000.0) / 1000.0;
                        if (book.getPrice() < coins) {

                            Cartel cartel = inputOfCartel();

                            inputOfCartelRecord(book,cartel);

                            System.out.println("LeftOver given To You is- " + totalLeftOverAfterPilaf);
                            System.out.println("Here is Your Product " + book.getBookName() + ". Enjoy!");

                        } else if (book.getPrice() == coins) {

                            Cartel cartel = inputOfCartel();

                            inputOfCartelRecord(book, cartel);

                            System.out.println("LeftOver given To You is- " + totalLeftOverAfterPilaf);
                            System.out.println("Here is Your Product " + book.getBookName() + ". Enjoy!");
                        }

                    }
                }
        }


        private Cartel inputOfCartel()
        {
            ClientFactory clientFactory=new ClientFactory();
            EmployeeFactory employeeFactory=new EmployeeFactory();
            CartelFactory cartelFactory=new CartelFactory();
            Cartel cartel=new Cartel();
            System.out.println("Input the Client ID: ");
            int clientId;
            clientId=sc.nextInt();
            System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_=_-_-_-_-_-_=_-_-_-_-_-_=_-_-_-_-_-_=");
            cartel.setClient(clientFactory.findClientByID(clientId));
            System.out.println("Input the Employee ID: ");
            int employeeID;
            employeeID=sc.nextInt();
            cartel.setEmployee(employeeFactory.findAllEmployeesByID(employeeID));
            System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_=_-_-_-_-_-_=_-_-_-_-_-_=_-_-_-_-_-_=");
            cartel.setCreatedOn(LocalDateTime.now());
            System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_=_-_-_-_-_-_=_-_-_-_-_-_=_-_-_-_-_-_=");
            cartelFactory.createCartel(cartel);
            return cartel;

        }

    private CartelRecord inputOfCartelRecord(Book book, Cartel cartel)
    {
        CartelRecordFactory cartelRecordFactory=new CartelRecordFactory();
        CartelRecord cartelRecord=new CartelRecord();
        cartelRecord.setDataStarted(LocalDateTime.now());
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_=_-_-_-_-_-_=_-_-_-_-_-_=_-_-_-_-_-_=");
        System.out.println("Input EndDate-Year: ");
        int year=sc.nextInt();
        System.out.println("--------BackEnd--------");
        System.out.println("Input EndDate-Month: ");
        int month=sc.nextInt();
        System.out.println("--------BackEnd--------");
        System.out.println("Input EndDate-Day: ");
        int day=sc.nextInt();
        System.out.println("--------BackEnd--------");
        System.out.println("Input EndDate-Hour: ");
        int hour=sc.nextInt();
        System.out.println("--------BackEnd--------");
        System.out.println("Input EndDate-Minute: ");
        int minute=sc.nextInt();
        System.out.println("--------BackEnd--------");
        cartelRecord.setEndData(LocalDateTime.of(year,month,day,hour,minute));
        cartelRecord.setCartel(cartel);
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_=_-_-_-_-_-_=_-_-_-_-_-_=_-_-_-_-_-_=");
        cartelRecord.setBook(book);
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_=_-_-_-_-_-_=_-_-_-_-_-_=_-_-_-_-_-_=");
        cartelRecord.setCreatedOn(LocalDateTime.now());
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_=_-_-_-_-_-_=_-_-_-_-_-_=_-_-_-_-_-_=");
        cartelRecordFactory.createCartelRecord(cartelRecord);
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_=_-_-_-_-_-_=_-_-_-_-_-_=_-_-_-_-_-_=");
        return cartelRecord;
    }

    private Optional<Book> findBook() {
        System.out.println("--------------------------------------------------");
        System.out.println("What Product Do You Want? (0 TO EXIT)");
        String bookCode = sc.next();
        //sc.nextLine();

        if (bookCode.equalsIgnoreCase("0")) {
            System.exit(0);
            return Optional.empty();
        }
        String finalBookCode = bookCode;
        Optional<Book> book = books.stream().filter(c->c.getIsbn().equalsIgnoreCase(finalBookCode)).findFirst();
        if (book.isPresent()) {
            if (book.get().getQuantity() > 0) {
                return book;
            } else {
                System.out.println(book.get().getBookName() + " is out of stock ");
            }
        } else {
            System.out.println("Sorry the product with code " + bookCode + " is Not Found!");
        }
        return Optional.empty();
    }


    private void displayMenu() {
        System.out.println("--------------------------------------------------");
        System.out.println("Our Products:");
        for (Book books : books) {
            System.out.println(books);
        }
    }
}
