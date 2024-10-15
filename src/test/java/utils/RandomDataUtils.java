package utils;

import com.github.javafaker.Faker;
import java.text.SimpleDateFormat;

public class RandomDataUtils {

    Faker faker = new Faker();

    public String FirstName() {
        return faker.name().firstName();
    }

    public String LastName() {
        return faker.name().lastName();
    }

    public String Email() {
        return faker.internet().emailAddress();
    }

    public String Phone() {
        return faker.phoneNumber().subscriberNumber(10);
    }
    public String Address() {
        return faker.address().fullAddress();
    }

    public String Gender() {
        return faker.options().option("Male", "Female", "Other");
    }

    public String monthOfBirth() {
        return faker.options().option("January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December");
    }

    public String dayOfBirth() {
        return String.format("%02d", faker.number().numberBetween(1,28));
    }

    public String yearOfBirth() {
        return new SimpleDateFormat("yyyy").format(faker.date().birthday());
    }


    public String Subject() {
        return faker.options().option("Maths", "English");
    }

    public String Hobby() {
        return faker.options().option("Sports", "Reading", "Music");
    }

    public String State() {
        return faker.options().option("NCR", "Haryana", "Uttar Pradesh");
    }

    public String getCityRandom(String state) {
        switch (state) {
            case "NCR":
                return faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh":
                return faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana":
                return faker.options().option("Karnal", "Panipat");
            case "Rajasthan":
                return faker.options().option("Jaipur", "Jaiselmer");
            default:
                return state;
        }
    }
}
