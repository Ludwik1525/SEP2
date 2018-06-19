package Domain.Model;

import Domain.Mediator.DatabaseAdapter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.MenuItem;

public class AirportList {
    private ObservableList<Airport> airportList;

    public AirportList() {
        airportList = FXCollections.observableArrayList();
    }

    public AirportList(ObservableList<Airport> airportList) {
        this.airportList = airportList;
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
