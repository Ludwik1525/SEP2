package Domain.Model;

import java.util.ArrayList;

public class PassengerList {
    private ArrayList<Passenger> passengers;

    public PassengerList() {
        this.passengers = new ArrayList<>();
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    public void deletePassenger(Passenger passenger) {
        passengers.remove(passenger);
    }


}
