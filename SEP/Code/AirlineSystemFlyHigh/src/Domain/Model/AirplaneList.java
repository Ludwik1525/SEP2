package Domain.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.time.LocalDate;



public class AirplaneList {

    private ObservableList<Airplane> airplaneList;
    LocalDate data1  = LocalDate.of(Integer.parseInt("1999"), Integer.parseInt("02"), Integer.parseInt("03"));
    LocalDate data2 = LocalDate.of(Integer.parseInt("1998"), Integer.parseInt("03"), Integer.parseInt("04"));

    public AirplaneList() {

        airplaneList = FXCollections.observableArrayList(
                new Airplane("IDNumber", "model", 20, data1, data2),
                new Airplane("ose", "one", 20, data1, data2)
        );

    }

    public ObservableList<Airplane> getAirplanes() {
        return airplaneList;
    }


    public void updateList(ObservableList <Airplane> airplane) {
        airplaneList= airplane;
    }
}
