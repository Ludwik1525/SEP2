package Domain.Model;

import Domain.Mediator.DatabaseAdapter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.time.LocalDate;



public class AirplaneList {

    private ObservableList<Airplane> airplaneList;

    public AirplaneList() {
        airplaneList = FXCollections.observableArrayList();
    }

    public AirplaneList(ObservableList<Airplane> airplaneList) {
        this.airplaneList = airplaneList;
    }

    public ObservableList<Airplane> getAirplanes() {
        return airplaneList;
    }
    public Airplane getAirplane(int i){
        return airplaneList.get(i);
    }
    public int getLength(){
        return airplaneList.size();
    }
    public String getId(int i){
        return airplaneList.get(i).getIDNumber();
    }

    public void updateList(ObservableList <Airplane> airplane) {
        airplaneList= airplane;
    }
}
