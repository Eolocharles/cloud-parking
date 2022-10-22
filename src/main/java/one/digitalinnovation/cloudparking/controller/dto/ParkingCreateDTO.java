package one.digitalinnovation.cloudparking.controller.dto;

public class ParkingCreateDTO {
    private String licensePlate;
    private String state;
    private String model;
    private String color;

    public ParkingCreateDTO() {
    }

    public ParkingCreateDTO(String licensePlate, String state, String model, String color) {
        this.licensePlate = licensePlate;
        this.state = state;
        this.model = model;
        this.color = color;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
