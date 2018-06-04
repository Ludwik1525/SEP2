package Domain.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class PassengerList {
    private ObservableList<Passenger> passengers;

    public PassengerList() {
        this.passengers = FXCollections.observableArrayList();
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    public void deletePassenger(Passenger passenger) {
        passengers.remove(passenger);
    }

    public void setPassengers(ObservableList<Passenger> passengers) {
        this.passengers = passengers;
    }

    public ObservableList<Passenger> getPassengers() {
        return passengers;
    }


}
