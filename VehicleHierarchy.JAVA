class Vehicle {
    String brand;
    int year;

    Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
        System.out.println("Vehicle constructor called");
    }

    void displayInfo() {
        System.out.println("Brand: " + brand + ", Year: " + year);
    }
}

class Car extends Vehicle {
    int doors;

    Car(String brand, int year, int doors) {
        super(brand, year); 
        this.doors = doors;
        System.out.println("Car constructor called");
    }

    @Override
    void displayInfo() {
        super.displayInfo(); 
        System.out.println("Doors: " + doors);
    }
}

class ElectricCar extends Car {
    int batteryCapacity;

    ElectricCar(String brand, int year, int doors, int batteryCapacity) {
        super(brand, year, doors);
        this.batteryCapacity = batteryCapacity;
        System.out.println("ElectricCar constructor called");
    }

    @Override
    void displayInfo() {
        super.displayInfo(); 
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
    }
}

public class VehicleHierarchy {
    public static void main(String[] args) {
        System.out.println("Creating a Vehicle:");
        Vehicle v = new Vehicle("Generic Brand", 2020);
        v.displayInfo();

        System.out.println("\nCreating a Car:");
        Car c = new Car("Toyota", 2021, 4);
        c.displayInfo();

        System.out.println("\nCreating an ElectricCar:");
        ElectricCar e = new ElectricCar("Tesla", 2023, 4, 100);
        e.displayInfo();
    }
}
