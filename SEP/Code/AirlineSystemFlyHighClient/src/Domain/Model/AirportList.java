package Domain.Model;

import Domain.Mediator.DatabaseAdapter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.MenuItem;

public class AirportList {
    private ObservableList<Airport> airportList;
    DatabaseAdapter adapter= new DatabaseAdapter();

    public AirportList() {
        airportList = adapter.loadAirports();

    }

    public ObservableList<Airport> getAirports() {
        return airportList;
    }
    public Airport getAirport(int i){
        return airportList.get(i);
    }
    public int getLength(){
        return airportList.size();
    }
    public String getCountry(int i){
        return airportList.get(i).getCountry();
    }
    public  String getCity(int i){
        return airportList.get(i).getCity();
    }

    public void updateList(ObservableList <Airport> airports) {
        airportList= airports;
    }
}
