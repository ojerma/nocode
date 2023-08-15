package utils;

import java.util.Random;

public class RandomDataGenerator {
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final String[] FIRST_NAMES = {"John", "Jane", "Michael", "Emily", "William", "Olivia", "James", "Emma", "Alexander", "Sophia"};
    private static final String[] LAST_NAMES = {"Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor"};
    private static final Random RANDOM = new Random();

    public static String generateRandomEmail() {
        StringBuilder email = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            int index = RANDOM.nextInt(CHARACTERS.length());
            email.append(CHARACTERS.charAt(index));
        }

        email.append("@example.com");
        return email.toString();
    }

    public static String generateRandomPassword(int length) {
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = RANDOM.nextInt(CHARACTERS.length());
            password.append(CHARACTERS.charAt(index));
        }

        return password.toString();
    }

    public static String generateRandomFullName() {
        String firstName = FIRST_NAMES[RANDOM.nextInt(FIRST_NAMES.length)];
        String lastName = LAST_NAMES[RANDOM.nextInt(LAST_NAMES.length)];
        return firstName + " " + lastName;

    }
}
