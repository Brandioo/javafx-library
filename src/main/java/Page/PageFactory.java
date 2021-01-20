package Page;


import AbstractFactory.ArtPage;

import java.util.Optional;

public class PageFactory {
    public static Optional<Page> getPage(String pageName) {
        if (pageName.equalsIgnoreCase("Library-'Art'")) {
            return Optional.of(new ArtPage());
        }else return Optional.empty();

//    public static Optional<SingleTonComputerCreation> classCall2(String classCalling) {
//        if (classCalling.equalsIgnoreCase("Computer")) {
//            return Optional.of(new SingleTonComputerCreation());
//        }
//        return null;

//    }
    }
}