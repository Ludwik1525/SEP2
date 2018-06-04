package Domain.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.MenuItem;

public class AirportList {
    private ObservableList<Airport> airportList;

    public AirportList() {
        airportList = FXCollections.observableArrayList(
                new Airport("code", "name", "city1", "postcode", "country1", 150),
                new Airport("one", "othername", "city2", "postcode", "country2", 190),
                new Airport("two", "othername", "city3", "postcode", "country3", 190),
                new Airport("lol", "othername", "city4", "postcode", "country4", 190),
                new Airport("RandomCode", "othername", "city5", "postcode", "country5", 190),
                new Airport("RandomCode", "othername", "city6", "postcode", "country6", 190),
                new Airport("RandomCode", "othername", "city7", "postcode", "country7", 190)
        );

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
