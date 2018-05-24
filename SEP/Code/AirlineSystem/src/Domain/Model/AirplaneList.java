package Domain.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.util.Date;


public class AirplaneList {

    private ObservableList<Airplane> airplaneList;
    Date purchaseDate= new Date(2012,2,12);
    Date lastMaintenance= new Date(2012,01,23);

    public AirplaneList(){
        airplaneList=getAirplanesForTable();

    }
    public ObservableList<Airplane> getAirplanesForTable() {
        ObservableList<Airplane> planes= FXCollections.observableArrayList(
                new Airplane("idNumber", "model", 20, purchaseDate, lastMaintenance)
        );
        return planes;


    }
    public void updateData(ObservableList<Airplane> planeList)throws IOException{

    }
}
