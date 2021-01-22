package AbstractFactory;

import java.util.Optional;

public class ArtFactoryProducer {
    public static Optional<StatusCategory> getCategory(String categoryName) {
        if ("Administrator".equalsIgnoreCase(categoryName)) {
            return Optional.of(new AdministratorFactory());
        } else if ("Operator".equalsIgnoreCase(categoryName)) {
            return Optional.of(new OperatorFactory());
        } else return Optional.empty();

    }
}
