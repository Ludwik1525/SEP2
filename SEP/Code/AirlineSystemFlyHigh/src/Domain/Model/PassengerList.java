package Domain.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.ArrayList;

public class PassengerList {
    private ObservableList<Passenger> passengers;
    LocalDate date = LocalDate.of(1999,3,5);
    public PassengerList() {
        this.passengers = FXCollections.observableArrayList(
         new Passenger("Dragos","0503992493","CPR","Romania",date,"50265890","dragsirbu@gmail.com","16A",5,"Bank Transfer"),
                new Passenger("NotDragos","0503992493","CPR","Romania",date,"50265890","notdragsirbu@gmail.com","16A",3,"Bank Transfer")
        );
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
