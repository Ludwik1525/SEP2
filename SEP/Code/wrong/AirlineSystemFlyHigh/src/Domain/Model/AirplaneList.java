package Domain.Model;

import Domain.Mediator.DatabaseAdapter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.time.LocalDate;



public class AirplaneList {

    private ObservableList<Airplane> airplaneList;
    DatabaseAdapter adapter= new DatabaseAdapter();

    public AirplaneList() {

        airplaneList = adapter.loadAirplanes();

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
