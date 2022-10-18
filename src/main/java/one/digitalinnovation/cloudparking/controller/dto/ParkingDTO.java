package one.digitalinnovation.cloudparking.controller.dto;

public class ParkingDTO {
    private String id;
    private String licensePlate;
    private String state;
    private String model;
    private String color;

    public ParkingDTO() {
    }

    public ParkingDTO(String id, String licensePlate, String state, String model, String color) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.state = state;
        this.model = model;
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
