package util;

import exceptions.InvalidInputException;
import java.time.Year;

public class InputValidator {

    public static boolean isPlateNumberValid(String plate) {
        if (plate == null || plate.isBlank() || !plate.matches("^[A-Za-z0-9-]{3,10}$")) {
            throw new InvalidInputException("Plate number must be 3-10 alphanumeric characters");
        }
        return true;
    }

    public static boolean isOwnerNameValid(String name) {
        if (name == null || name.isBlank() || name.length() < 3 || !name.matches("^[A-Za-z ]+$")) {
            throw new InvalidInputException("Owner name must contain only letters and be at least 3 characters");
        }
        return true;
    }

    public static boolean isVehicleTypeValid(String type) {
        if (type == null || (!type.equalsIgnoreCase("Car") &&
                !type.equalsIgnoreCase("Truck") &&
                !type.equalsIgnoreCase("Motorcycle"))) {
            throw new InvalidInputException("Invalid type. Use: Car, Truck, Motorcycle");
        }
        return true;
    }

    public static boolean isYearValid(int year) {
        int currentYear = Year.now().getValue();
        if (year < 1990 || year > currentYear) {
            throw new InvalidInputException("Year must be between 1990 and " + currentYear);
        }
        return true;
    }
}