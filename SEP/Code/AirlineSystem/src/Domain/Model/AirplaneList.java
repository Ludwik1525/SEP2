package Domain.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Date;


public class AirplaneList {

    private ObservableList<Airplane> airplaneList;
    Date data = new Date(1999,02,23);

    public AirplaneList() {

        airplaneList = FXCollections.observableArrayList(
                new Airplane("IDNumber", "model", 20, data, data),
                new Airplane("ose", "one", 20, data, data)
        );

    }

    public ObservableList<Airplane> getAirplaneList() {
        return airplaneList;
    }
}
