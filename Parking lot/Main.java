
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

// vehicle
abstract class Vehicle {
    private String licensePlate;
    private long entryTime;
    private long exitTime;

    public Vehicle(String licensePlate, long entryTime) {
        this.licensePlate = licensePlate;
        this.entryTime = entryTime;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public long getExitTime() {
        return exitTime;
    }

    public void setExitTime(long exitTime) {
        this.exitTime = exitTime;
    }

    public abstract int getRate();
    public abstract String getType();


    public int calculateFee() {
        if (exitTime <= entryTime) return 0;
        long duration = exitTime - entryTime;
        long hours = duration / 3600;
        if (duration % 3600 != 0) hours++; // round up
        return (int) hours * getRate();
    }
}

// payment interface
interface payment{
    void paymentMethod(Vehicle vehicle,Scanner sc);
}

class cash implements payment 
{
    public void paymentMethod(Vehicle vehicle,Scanner sc) {

        System.out.println("You have chosen to pay in cash.");
        int actualCharge = vehicle.calculateFee();
        int userPaid = 0;

        while (true) {
            System.out.println("You need to pay " + actualCharge);
            System.out.print("Enter the amount you will pay: ");
            userPaid = sc.nextInt();

            if (userPaid < actualCharge) {
                System.out.println("Insufficient amount. Please pay at least " + actualCharge);
            } else {
                break;
            }
        }

        int change = userPaid - actualCharge;
        if (change>0){
            System.out.println("Here you go, your change: "+change);
        }
        System.out.println("Payment successful!");
    }
}

class UPIPayment implements payment  {
    public void paymentMethod(Vehicle vehicle,Scanner sc) {
        System.out.println("You have chosen UPI payment.");
        try {
            System.out.println("Proccessing payment of "+vehicle.calculateFee()+".....");
            Thread.sleep(2000);
            System.out.println("Payment successful!");
        } catch (Exception e) {
            System.out.println("Payment unsuccessful due to: "+ e.getMessage());
        }
    }
}

class CardPayment implements payment {
    public void paymentMethod(Vehicle vehicle,Scanner sc) {
        System.out.println("You have chosen card payment.");
        System.out.println("Enter you pin.");
        sc.nextInt();
        try {
            System.out.println("Proccessing payment of "+vehicle.calculateFee()+".....");
            Thread.sleep(2000);
            System.out.println("Payment successful!");
        } catch (Exception e) {
            System.out.println("Payment unsuccessful due to: "+ e.getMessage());
        }
    }
}

class PaymentProcessor{
    public void paymentChoice(Vehicle vehicle,Scanner sc) {

        while(true) 
        {
            System.out.println("You need to pay "+vehicle.calculateFee());
            System.out.println("How do you wish to proceed?");
            System.out.println("\n--- Payment menu ---");
            System.out.println("1. Cash");
            System.out.println("2. UPI");
            System.out.println("3. Card");
            int choicePayment = sc.nextInt();
            switch (choicePayment) {
                case 1:
                    new cash().paymentMethod(vehicle,sc);
                    return;
                case 2:
                    new UPIPayment().paymentMethod(vehicle,sc);
                    return;
                case 3:
                    new CardPayment().paymentMethod(vehicle,sc);
                    return;
                default:
                    System.out.println("Wrong choice. Try again");
                    
        }
    }
        
    }
}

// bike
class Bike extends Vehicle {
    public Bike(String licensePlate, long entryTime) {
        super(licensePlate, entryTime);
    }

    public int getRate() {
        return 20;
    }

    public String getType() {
        return "Bike";
    }
}

//car
class Car extends Vehicle {
    public Car(String licensePlate, long entryTime) {
        super(licensePlate, entryTime);
    }

    public int getRate() {
        return 40;
    }

    public String getType() {
        return "Car";
    }
}

// parking spots
class ParkingSpot {
    private Vehicle vehicle;

    public boolean isEmpty() {
        return vehicle == null;
    }

    public void park(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void unpark() {
        this.vehicle = null;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}

// parking floors

class Floor {
    private ParkingSpot[] spots;
    private String type;

    public Floor(int capacity, String type) {
        this.type = type;
        spots = new ParkingSpot[capacity];
        for (int i = 0; i < capacity; i++) {
            spots[i] = new ParkingSpot();
        }
    }

    public boolean parkVehicle(Vehicle vehicle) {
        if (!vehicle.getType().equalsIgnoreCase(type)) {
            System.out.println("Wrong floor for vehicle type.");
            return false;
        }
        for (int i = 0; i < spots.length; i++) {
            if (spots[i].isEmpty()) {
                spots[i].park(vehicle);
                System.out.println("\n+-----------------------------+");
                System.out.println("|  Vehicle Parked Successfully |");
                System.out.println("+-----------------------------+");
                System.out.println("| Type         : " + vehicle.getType());
                System.out.println("| Plate        : " + vehicle.getLicensePlate());
                System.out.println("| Slot Number  : " + (i + 1));
                System.out.println("| Entry Time   : " + Main.formatTime(vehicle.getEntryTime()));
                System.out.println("+-----------------------------+\n");
                return true;
            }
        }
        System.out.println("No available " + type + " spots.");
        return false;
    }

    public Vehicle unparkVehicle(String licensePlate, long exitTime) {
        for (int i = 0; i < spots.length; i++) {
            Vehicle v = spots[i].getVehicle();
            if (v != null && v.getLicensePlate().equalsIgnoreCase(licensePlate)) {
                v.setExitTime(exitTime);
                int fee = v.calculateFee();
                long duration = exitTime - v.getEntryTime();

                System.out.println("\n+-----------------------------+");
                System.out.println("| Vehicle Exit Bill           |");
                System.out.println("+-----------------------------+");
                System.out.println("| Type         : " + v.getType());
                System.out.println("| Plate        : " + v.getLicensePlate());
                System.out.println("| Slot Number  : " + (i + 1));
                System.out.println("| Entry Time   : " + Main.formatTime(v.getEntryTime()));
                System.out.println("| Exit Time    : " + Main.formatTime(exitTime));
                System.out.println("| Time Elapsed : " + duration + " seconds");
                System.out.println("| Fee          : Rs. " + fee);
                System.out.println("+-----------------------------+\n");

                spots[i].unpark();
                return v;
            }
        }
        return null;
    }

    public boolean searchVehicle(String licensePlate) {
        for (int i = 0; i < spots.length; i++) {
            Vehicle v = spots[i].getVehicle();
            if (v != null && v.getLicensePlate().equalsIgnoreCase(licensePlate)) {
                System.out.println("\n+-----------------------------+");
                System.out.println("| Vehicle Found              |");
                System.out.println("+-----------------------------+");
                System.out.println("| Type         : " + v.getType());
                System.out.println("| Plate        : " + v.getLicensePlate());
                System.out.println("| Slot Number  : " + (i + 1));
                System.out.println("| Entry Time   : " + Main.formatTime(v.getEntryTime()));
                System.out.println("+-----------------------------+\n");
                return true;
            }
        }
        return false;
    }

    public void displayStatus() {
        int occupied = 0;
        for (ParkingSpot spot : spots) {
            if (!spot.isEmpty()) occupied++;
        }
        int free = spots.length - occupied;

        System.out.println("\n+-----------------------------+");
        System.out.println("| " + type + " Floor Status");
        System.out.println("+-----------------------------+");
        System.out.println("| Total Spots   : " + spots.length);
        System.out.println("| Occupied      : " + occupied);
        System.out.println("| Free          : " + free);
        System.out.println("+-----------------------------+\n");
    }
}

class ParkingLot {
    private Floor bikeFloor;
    private Floor carFloor;

    public ParkingLot() {
        bikeFloor = new Floor(10, "Bike");
        carFloor = new Floor(20, "Car");
    }

    public void parkVehicle(Vehicle vehicle) {
        if (vehicle instanceof Bike) {
            bikeFloor.parkVehicle(vehicle);
        } else if (vehicle instanceof Car) {
            carFloor.parkVehicle(vehicle);
        } else {
            System.out.println("Unknown vehicle type.");
        }
    }

    public Vehicle unparkVehicle(String licensePlate, long exitTime) {
    Vehicle vehicle = bikeFloor.unparkVehicle(licensePlate, exitTime);
    if (vehicle == null) {
        vehicle = carFloor.unparkVehicle(licensePlate, exitTime);
    }
    if (vehicle == null) {
        System.out.println("\nNo vehicles currently parked with plate: " + licensePlate + "\n");
    }
    return vehicle;
}

    public void searchVehicle(String licensePlate) {
        if (!bikeFloor.searchVehicle(licensePlate)) {
            if (!carFloor.searchVehicle(licensePlate)) {
                System.out.println("\nVehicle not found: " + licensePlate + "\n");
            }
        }
    }

    public void displayStatus() {
        bikeFloor.displayStatus();
        carFloor.displayStatus();
    }
}

public class Main {
    public static String formatTime(long epochSeconds) {
        Date date = new Date(epochSeconds * 1000);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Welcome to My Parking Space!");
            System.out.println("\n--- Parking Lot Menu ---");
            System.out.println("1. Park Vehicle");
            System.out.println("2. Leave Vehicle");
            System.out.println("3. Show Status");
            System.out.println("4. Search Vehicle");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter vehicle type (Car/Bike): ");
                    String type = scanner.nextLine().trim();
                    System.out.print("Enter license plate: ");
                    String plate = scanner.nextLine();
                    long entryTime = System.currentTimeMillis() / 1000;

                    Vehicle vehicle;
                    if (type.equalsIgnoreCase("Car")) {
                        vehicle = new Car(plate, entryTime);
                    } else if (type.equalsIgnoreCase("Bike")) {
                        vehicle = new Bike(plate, entryTime);
                    } else {
                        System.out.println("Invalid vehicle type.");
                        break;
                    }

                    lot.parkVehicle(vehicle);
                    break;

                case 2:
                    System.out.print("Enter license plate to remove: ");
                    String removePlate = scanner.nextLine();
                    long exitTime = System.currentTimeMillis() / 1000;
                    Vehicle vehicleToPay = lot.unparkVehicle(removePlate, exitTime);

                    if (vehicleToPay != null) {
                        new PaymentProcessor().paymentChoice(vehicleToPay, scanner);
                    }
                    break;

                case 3:
                    System.out.println("\n--- Parking Lot Status ---");
                    lot.displayStatus();
                    break;

                case 4:
                    System.out.print("Enter license plate to search: ");
                    String searchPlate = scanner.nextLine();
                    lot.searchVehicle(searchPlate);
                    break;

                case 0:
                    System.out.println("Thank you for choosing my parking space!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
