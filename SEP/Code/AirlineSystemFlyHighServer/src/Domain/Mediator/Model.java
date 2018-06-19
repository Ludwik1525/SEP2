package Domain.Mediator;

import Domain.Model.*;
import javafx.collections.ObservableList;

public interface Model {
    public ClubMemberList getClubMembers();
    public AirportList getAirports();
    public AirplaneList getAirplanes();
    public Crew getCrewMembers();
    public PassengerList getPassengers();
    public FlightList getFlights();

    public void updateClubMember(ClubMember clubMember);
    public void updateAirport(Airport airport);
    public void updateAirplane(Airplane airplane);
    public void updateCrewMember(CrewMember crewMember);
    public void updateFlight(Flight flight);

    public void addClubMember(ClubMember clubMember);
    public void addAirport(Airport airport);
    public void addAirplane(Airplane airplane);
    public void addCrewMember(CrewMember crewMember);
    public void addPassenger(Passenger passenger);
    public void addFlight(Flight flight);

    public void removeClubMember(ClubMember clubMember);
    public void removeAirport(Airport airport);
    public void removeAirplane(Airplane airplane);
    public void removeCrewMember(CrewMember crewMember);
    
}
