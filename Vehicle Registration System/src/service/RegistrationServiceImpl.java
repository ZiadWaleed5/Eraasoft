package service;

import exceptions.DuplicatePlateException;
import exceptions.VehicleNotFoundException;
import model.Vehicle;

import java.util.*;
import java.util.stream.Collectors;

public class RegistrationServiceImpl implements RegistrationService {
    private List<Vehicle> vehicleList = new ArrayList<>();
    private Map<String, Vehicle> plateIndex = new HashMap<>();
    private Set<String> registeredPlates = new HashSet<>();

    @Override
    public void registerVehicle(Vehicle v) {
        String plateUpper = v.getPlateNumber().toUpperCase();
        if (registeredPlates.contains(plateUpper)) {
            throw new DuplicatePlateException(plateUpper);
        }

        vehicleList.add(v);
        plateIndex.put(plateUpper, v);
        registeredPlates.add(plateUpper);
    }

    @Override
    public Vehicle findByPlate(String plate) {
        String plateUpper = plate.toUpperCase();
        if (!plateIndex.containsKey(plateUpper)) {
            throw new VehicleNotFoundException(plateUpper);
        }
        return plateIndex.get(plateUpper);
    }

    @Override
    public void updateOwner(String plate, String newOwner) {
        Vehicle v = findByPlate(plate); // Reuse the search method
        v.setOwnerName(newOwner);
    }

    @Override
    public void deleteVehicle(String plate) {
        Vehicle v = findByPlate(plate);
        String plateUpper = v.getPlateNumber().toUpperCase();

        vehicleList.remove(v);
        plateIndex.remove(plateUpper);
        registeredPlates.remove(plateUpper);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return Collections.unmodifiableList(vehicleList);
    }


    @Override
    public List<Vehicle> filterByType(String type) {
        return vehicleList.stream()
                .filter(v -> v.getVehicleType().equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }

    @Override
    public List<Vehicle> getVehiclesByOwner(String ownerName) {
        return vehicleList.stream()
                .filter(v -> v.getOwnerName().toLowerCase().contains(ownerName.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Vehicle> getExpiredRegistrations(int currentYear) {
        return vehicleList.stream()
                .filter(v -> (currentYear - v.getRegistrationYear()) > 5)
                .sorted(Comparator.comparingInt(Vehicle::getRegistrationYear))
                .collect(Collectors.toList());
    }

    @Override
    public List<Vehicle> getSortedByYear(boolean ascending) {
        Comparator<Vehicle> comp = Comparator.comparingInt(Vehicle::getRegistrationYear);
        if (!ascending) comp = comp.reversed();
        return vehicleList.stream().sorted(comp).collect(Collectors.toList());
    }

    @Override
    public void printStatistics() {
        if (vehicleList.isEmpty()) {
            System.out.println("No vehicles registered.");
            return;
        }

        IntSummaryStatistics stats = vehicleList.stream()
                .mapToInt(Vehicle::getRegistrationYear)
                .summaryStatistics();

        Map<String, Long> byType = vehicleList.stream()
                .collect(Collectors.groupingBy(Vehicle::getVehicleType, Collectors.counting()));

        Map<Boolean, Long> byStatus = vehicleList.stream()
                .collect(Collectors.partitioningBy(
                        v -> v.getStatus().equals("ACTIVE"), Collectors.counting()));

        System.out.println("========== REGISTRATION STATISTICS ==========");
        System.out.println("Total Vehicles : " + stats.getCount());
        System.out.printf("Average Year   : %.0f\n", stats.getAverage());
        System.out.println("Newest Vehicle : " + stats.getMax());
        System.out.println("Oldest Vehicle : " + stats.getMin());

        System.out.println("Vehicles by Type:");
        byType.forEach((type, count) -> System.out.println(type + " : " + count));

        System.out.println("ACTIVE vehicles: " + byStatus.getOrDefault(true, 0L));
        System.out.println("EXPIRED vehicles: " + byStatus.getOrDefault(false, 0L));
        System.out.println("=============================================");
    }
}