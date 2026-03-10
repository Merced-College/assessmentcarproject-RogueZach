public class Car {
    private String carID;
    private String brand;
    private String model;
    private int year;
    private String fuelType;
    private String color;
    private double mileageKmpl;

    public Car(String carID, String brand, String model, int year, String fuelType, String color, double mileageKmpl) {
        this.carID = carID;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.fuelType = fuelType;
        this.color = color;
        this.mileageKmpl = mileageKmpl;
    }

    public String getCarID() { return carID; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public String getFuelType() { return fuelType; }
    public String getColor() { return color; }
    public double getMileageKmpl() { return mileageKmpl; }

    public String toString() {
        return carID + ", " + brand + ", " + model + ", " + year + ", " + fuelType + ", " + color + ", " + mileageKmpl;
    }
}
