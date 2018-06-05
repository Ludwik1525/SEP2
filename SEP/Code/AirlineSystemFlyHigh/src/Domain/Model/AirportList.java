package Domain.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.MenuItem;

public class AirportList {
    private ObservableList<Airport> airportList;

    public AirportList() {
        airportList = FXCollections.observableArrayList(
                new Airport("LCY", "London City Airport", "London", "postcode", "England", 150),
                new Airport("ARN", "Arlanda Airport", "Stockholm", "postcode", "Sweden", 190),
                new Airport("CPH", "Copenhagen Airport", "Copenhagen", "postcode", "Denmark", 190),
                new Airport("OSL", "Oslo Airport", "Oslo", "postcode", "Norway", 190),
                new Airport("HLS", "HLS Airport", "Helsinki", "postcode", "Finland", 190),
                new Airport("BRL", "Berlin Airport", "Berlin", "postcode", "Germany", 190),
                new Airport("PRS", "Paris Airport", "Paris", "postcode", "France", 190)
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
