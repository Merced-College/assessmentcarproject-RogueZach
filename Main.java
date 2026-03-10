import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<Car> loadCars(String filename) {
        ArrayList<Car> cars = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine(); // skip header
            while ((line = br.readLine()) != null) {
                try {
                    String[] parts = line.split(",");
                    if (parts.length != 7) continue;
                    String carID = parts[0].trim();
                    String brand = parts[1].trim();
                    String model = parts[2].trim();
                    int year = Integer.parseInt(parts[3].trim());
                    String fuelType = parts[4].trim();
                    String color = parts[5].trim();
                    double mileage = Double.parseDouble(parts[6].trim());
                    cars.add(new Car(carID, brand, model, year, fuelType, color, mileage));
                } catch (Exception e) {
                    // skip malformed row
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        System.out.println("Total cars loaded: " + cars.size());
        return cars;
    }

    public static void selectionSortByBrand(ArrayList<Car> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).getBrand().compareToIgnoreCase(list.get(minIndex).getBrand()) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Car temp = list.get(i);
                list.set(i, list.get(minIndex));
                list.set(minIndex, temp);
            }
        }
    }

    public static ArrayList<Car> binarySearchByBrand(ArrayList<Car> list, String brand) {
        // Find any match using binary search
        int low = 0;
        int high = list.size() - 1;
        int foundIndex = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = list.get(mid).getBrand().compareToIgnoreCase(brand);
            if (cmp == 0) {
                foundIndex = mid;
                break;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        ArrayList<Car> results = new ArrayList<>();
        if (foundIndex == -1) {
            return results;
        }

        // Expand left and right to find all matches
        int left = foundIndex;
        while (left > 0 && list.get(left - 1).getBrand().compareToIgnoreCase(brand) == 0) {
            left--;
        }
        int right = foundIndex;
        while (right < list.size() - 1 && list.get(right + 1).getBrand().compareToIgnoreCase(brand) == 0) {
            right++;
        }
        for (int i = left; i <= right; i++) {
            results.add(list.get(i));
        }

        return results;
    }

    public static void showStats(ArrayList<Car> list) {
        double totalMileage = 0;
        int[] fuelCounts = new int[5]; // Petrol, Diesel, CNG, Electric, Hybrid
        String[] fuelNames = {"Petrol", "Diesel", "CNG", "Electric", "Hybrid"};

        for (Car car : list) {
            totalMileage += car.getMileageKmpl();
            switch (car.getFuelType()) {
                case "Petrol":  fuelCounts[0]++; break;
                case "Diesel":  fuelCounts[1]++; break;
                case "CNG":     fuelCounts[2]++; break;
                case "Electric": fuelCounts[3]++; break;
                case "Hybrid":  fuelCounts[4]++; break;
            }
        }

        System.out.println("\n--- Stats (Working List) ---");
        System.out.printf("Average Mileage: %.2f kmpl%n", totalMileage / list.size());
        System.out.println("Counts by Fuel Type:");
        for (int i = 0; i < fuelNames.length; i++) {
            System.out.println("  " + fuelNames[i] + ": " + fuelCounts[i]);
        }
    }

    public static void main(String[] args) {
        ArrayList<Car> cars = loadCars("Car_Data.csv");
        ArrayList<Car> working = new ArrayList<>(cars.subList(0, 2000));
        boolean sorted = false;

        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 4) {
            System.out.println("\n===== Car Data Analyzer =====");
            System.out.println("1. Sort by Brand");
            System.out.println("2. Search by Brand");
            System.out.println("3. Show Stats");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                scanner.nextLine();
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    selectionSortByBrand(working);
                    sorted = true;
                    System.out.println("\nSorted by Brand. First 10 cars:");
                    for (int i = 0; i < 10 && i < working.size(); i++) {
                        System.out.println(working.get(i));
                    }
                    break;
                case 2:
                    if (!sorted) {
                        System.out.println("Sorting by Brand first...");
                        selectionSortByBrand(working);
                        sorted = true;
                    }
                    System.out.print("Enter brand to search: ");
                    String brand = scanner.nextLine();
                    ArrayList<Car> results = binarySearchByBrand(working, brand);
                    if (results.isEmpty()) {
                        System.out.println("No cars found for brand: " + brand);
                    } else {
                        System.out.println("Found " + results.size() + " car(s):");
                        for (Car car : results) {
                            System.out.println(car);
                        }
                    }
                    break;
                case 3:
                    showStats(working);
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }
}
