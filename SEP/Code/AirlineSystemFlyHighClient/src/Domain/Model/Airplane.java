package Domain.Model;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.Date;

public class Airplane {
    private String IDNumber;
    private String model;
    private int numberOfSeats;
    private LocalDate purchaseDate;
    private LocalDate lastMaintenance;

    public Airplane(String IDNumber, String model, int numberOfSeats, LocalDate purchaseDate, LocalDate lastMaintenance) {
        this.IDNumber = IDNumber;
        this.model = model;
        this.numberOfSeats = numberOfSeats;
        this.purchaseDate = purchaseDate;
        this.lastMaintenance = lastMaintenance;
    }


    public void setIDNumber(String IDNumber) {
        this.IDNumber = IDNumber;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setLastMaintenance(LocalDate lastMaintenance) {
        this.lastMaintenance = lastMaintenance;
    }

    public String getModel() {
        return model;
    }

    public String getIDNumber() {
        return IDNumber;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public LocalDate getLastMaintenance() {
        return lastMaintenance;
    }

    @Override
    public String toString() {
        return "Model: "+getModel()+"Number: "+getIDNumber()+"; Purchase date: "+getPurchaseDate()+"; Number of seats: "
                +getNumberOfSeats()+"; Last maintenance: "+getLastMaintenance();
    }
}

