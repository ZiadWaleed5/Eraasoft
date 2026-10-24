package service;

import model.Vehicle;
import java.util.List;

public interface RegistrationService {
    void registerVehicle(Vehicle v);
    Vehicle findByPlate(String plate);
    void updateOwner(String plate, String newOwner);
    void deleteVehicle(String plate);
    List<Vehicle> getAllVehicles();

    // Streams Methods
    List<Vehicle> filterByType(String type);
    List<Vehicle> getVehiclesByOwner(String ownerName);
    List<Vehicle> getExpiredRegistrations(int currentYear);
    List<Vehicle> getSortedByYear(boolean ascending);
    void printStatistics();
}