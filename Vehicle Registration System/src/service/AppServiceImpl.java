package service;

import exceptions.DuplicatePlateException;
import exceptions.InvalidInputException;
import exceptions.VehicleNotFoundException;
import model.Car;
import model.Motorcycle;
import model.Truck;
import model.Vehicle;
import util.InputValidator;

import java.time.Year;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AppServiceImpl implements AppService {
    private final RegistrationService registrationService = new RegistrationServiceImpl();
    private final Scanner scanner = new Scanner(System.in);

    public AppServiceImpl() {
        seedData();
    }

    @Override
    public void start() {
        while (true) {
            System.out.println("\n========== VEHICLE REGISTRATION SYSTEM ==========");
            System.out.println("1. Register New Vehicle");
            System.out.println("2. Search Vehicle by Plate");
            System.out.println("3. Update Owner Name");
            System.out.println("4. Delete Vehicle");
            System.out.println("5. List All Vehicles");
            System.out.println("6. Filter by Vehicle Type");
            System.out.println("7. Show Owner History");
            System.out.println("8. Show Expired Registrations");
            System.out.println("9. Statistics Report");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1: registerMenu(); break;
                    case 2: searchMenu(); break;
                    case 3: updateMenu(); break;
                    case 4: deleteMenu(); break;
                    case 5: listAllMenu(); break;
                    case 6: filterByTypeMenu(); break;
                    case 7: showOwnerHistoryMenu(); break;
                    case 8: showExpiredMenu(); break;
                    case 9: registrationService.printStatistics(); break;
                    case 0:
                        System.out.println("Exiting System... Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice, please select from 0 to 9.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("System Error: " + e.getMessage());
            }
        }
    }

    private void registerMenu() {
        try {
            System.out.print("Enter plate number: ");
            String plate = scanner.nextLine();
            InputValidator.isPlateNumberValid(plate);

            System.out.print("Enter owner name: ");
            String owner = scanner.nextLine();
            InputValidator.isOwnerNameValid(owner);

            System.out.print("Enter vehicle type (Car/Truck/Motorcycle): ");
            String type = scanner.nextLine();
            InputValidator.isVehicleTypeValid(type);

            System.out.print("Enter registration year: ");
            int year = scanner.nextInt();
            scanner.nextLine();
            InputValidator.isYearValid(year);

            String status = "ACTIVE";

            Vehicle newVehicle = null;
            if (type.equalsIgnoreCase("Car")) {
                newVehicle = new Car(plate, owner, year, status, 4);
            } else if (type.equalsIgnoreCase("Truck")) {
                newVehicle = new Truck(plate, owner, year, status, 5.0);
            } else if (type.equalsIgnoreCase("Motorcycle")) {
                newVehicle = new Motorcycle(plate, owner, year, status, "Sport");
            }

            registrationService.registerVehicle(newVehicle);
            System.out.println("Vehicle registered successfully!");

        } catch (InvalidInputException | DuplicatePlateException e) {
            System.out.println("Input Error: " + e.getMessage());
        }
    }

    private void searchMenu() {
        System.out.print("Enter plate number to search: ");
        String plate = scanner.nextLine();
        try {
            Vehicle v = registrationService.findByPlate(plate);
            System.out.println(v.toString());
            System.out.println("Label: " + v.getRegistrationLabel());
        } catch (VehicleNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void updateMenu() {
        System.out.print("Enter plate number to update: ");
        String plate = scanner.nextLine();
        System.out.print("Enter new owner name: ");
        String newOwner = scanner.nextLine();

        try {
            InputValidator.isOwnerNameValid(newOwner);
            registrationService.updateOwner(plate, newOwner);
            System.out.println("Owner updated successfully.");
        } catch (VehicleNotFoundException | InvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void deleteMenu() {
        System.out.print("Enter plate number to delete: ");
        String plate = scanner.nextLine();
        try {
            registrationService.deleteVehicle(plate);
            System.out.println("Vehicle deleted successfully.");
        } catch (VehicleNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void listAllMenu() {
        List<Vehicle> list = registrationService.getAllVehicles();
        if (list.isEmpty()) {
            System.out.println("No vehicles registered.");
        } else {
            list.forEach(System.out::println);
        }
    }

    private void filterByTypeMenu() {
        System.out.print("Enter vehicle type to filter (Car/Truck/Motorcycle): ");
        String type = scanner.nextLine();
        List<Vehicle> filtered = registrationService.filterByType(type);
        if (filtered.isEmpty()) System.out.println("No vehicles found for this type.");
        else filtered.forEach(System.out::println);
    }

    private void showOwnerHistoryMenu() {
        System.out.print("Enter owner name (or part of it): ");
        String name = scanner.nextLine();
        List<Vehicle> history = registrationService.getVehiclesByOwner(name);
        if (history.isEmpty()) System.out.println("No vehicles found for this owner.");
        else history.forEach(System.out::println);
    }

    private void showExpiredMenu() {
        int currentYear = Year.now().getValue();
        List<Vehicle> expired = registrationService.getExpiredRegistrations(currentYear);
        if (expired.isEmpty()) System.out.println("No expired registrations found.");
        else expired.forEach(System.out::println);
    }

    private void seedData() {
        registrationService.registerVehicle(new Car("CAR-001", "Ahmed Ali", 2019, "EXPIRED", 4));
        registrationService.registerVehicle(new Car("CAR-002", "Sara Kamel", 2023, "ACTIVE", 2));
        registrationService.registerVehicle(new Truck("TRK-001", "Mohamed Said", 2021, "ACTIVE", 10.0));
        registrationService.registerVehicle(new Truck("TRK-002", "Laila Nour", 2017, "EXPIRED", 5.5));
        registrationService.registerVehicle(new Motorcycle("MOT-001", "Omar Fathi", 2022, "ACTIVE", "Sport"));
        registrationService.registerVehicle(new Motorcycle("MOT-002", "Nadia Hamed", 2024, "ACTIVE", "Cruiser"));
    }
}