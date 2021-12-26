package utils;

import com.github.javafaker.Faker;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GenerateRandomData {

    public static final Faker faker = new Faker();

    public static String generateFirstName() {
        return (faker.name().firstName());
    }

    public static String generateLastName() {
        return (faker.name().lastName());
    }

    public static String generateNickName() {
        return (faker.name().username());
    }

}
