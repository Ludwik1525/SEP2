package Domain.Mediator;

import Domain.Model.*;

public interface Model {
    public FlightList getAllFlights();
    public ClubMemberList getAllClubMembers();
    public AirplaneList getAllAirplanes();
    public AirportList getAllAirports();
    public Crew getAllCrewMembers();
    public PassengerList getAllPassengers();
    
}
