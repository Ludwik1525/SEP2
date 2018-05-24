package Domain.Model;

import java.util.Date;

public class Airplane {
    private String IDNumber;
    private String model;
    private int numberOfSeats;
    private Date purchaseDate;
    private Date lastMaintainance;

    public Airplane(String IDNumber, String model, int numberOfSeats, Date purchaseDate, Date lastMaintainance) {
        this.IDNumber = IDNumber;
        this.model = model;
        this.numberOfSeats = numberOfSeats;
        this.purchaseDate = purchaseDate;
        this.lastMaintainance = lastMaintainance;
    }

    public Airplane() {

    }

    public void setNumber(String number) {
        this.IDNumber = number;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setLastMaintainance(Date lastMaintainance) {
        this.lastMaintainance = lastMaintainance;
    }

    public String getModel() {
        return model;
    }

    public String getNumber() {
        return IDNumber;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public Date getLastMaintainance() {
        return lastMaintainance;
    }

    @Override
    public String toString() {
        return "Model: "+getModel()+"Number: "+getNumber()+"; Purchase date: "+getPurchaseDate()+"; Number of seats: "
                +getNumberOfSeats()+"; Last maintainance: "+getLastMaintainance();
    }
}

