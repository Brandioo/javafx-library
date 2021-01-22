package Page;

import AbstractFactory.ArtPage;

import java.util.Optional;
import java.util.Scanner;

public class ClassCall {
    public static void rendering() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello, Input The Class You Want To Call:(Library-'Art')");
        String classCalling = sc.nextLine();
        Optional<Page> page = PageFactory.getPage(classCalling);
        // Optional<Object> singleTonComputerCreation = Optional.ofNullable(Factory.classCall2(classCalling));
        if (page.isPresent()) {
            page.get().render();
        } else {
            System.out.println("Function " + classCalling + " you called not found!");
        }

//        if (singleTonComputerCreation.isPresent()) {
//            Computer computer = new Computer.ComputerBuilder().computerName("ASUS").withCPU("Intel Core i3-7020U CPU @2.30GHz 2.30GHz Processor").withRAM(8).withMotherboard("ASUS X509").builder();
//            System.out.println(computer);
//
//        } else {
//            System.out.println("Function you called not found!");
//        }

    }


}

