package one.digitalinnovation.cloudparking.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ParkingDTO {
    private String id;
    private String licensePlate;
    private String state;
    private String model;
    private String color;
    private String entryDate;
    private String exitDate;
    private Double bill;

    public ParkingDTO() {
    }

    public ParkingDTO(String id, String licensePlate, String state, String model, String color, String entryDate, String exitDate, Double bill) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.state = state;
        this.model = model;
        this.color = color;
        this.entryDate = entryDate;
        this.exitDate = exitDate;
        this.bill = bill;
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

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getExitDate() {
        return exitDate;
    }

    public void setExitDate(String exitDate) {
        this.exitDate = exitDate;
    }

    public Double getBill() {
        return bill;
    }

    public void setBill(Double bill) {
        this.bill = bill;
    }
}
