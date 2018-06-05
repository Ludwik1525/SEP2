package Domain.Mediator;

import Domain.Model.*;
import javafx.collections.ObservableList;

public interface Target {
    public ObservableList<ClubMember> loadClubMembers();
    public ObservableList<Airport> loadAirports();
    public ObservableList<Airplane> loadAirplanes();
    public ObservableList<CrewMember> loadCrewMembers();
    public ObservableList<Passenger> loadPassengers();
    public ObservableList<Flight> loadFlights();


    public void updateClubMembers(ClubMember clubMember);

}
