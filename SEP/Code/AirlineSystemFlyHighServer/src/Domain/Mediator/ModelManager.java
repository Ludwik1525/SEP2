package Domain.Mediator;

import Domain.Model.*;
import javafx.collections.ObservableList;

public class ModelManager implements Model {
    AirportList airportList;
    FlightList flightList;
    PassengerList passengerList;
    AirplaneList airplaneList;
    ClubMemberList clubMemberList;
    Crew crew;
    Target target;

   public ModelManager(){
       target = new DatabaseAdapter();
       airportList= new AirportList(target.loadAirports());
       flightList= new FlightList(target.loadFlights());
       passengerList= new PassengerList(target.loadPassengers());
       airplaneList= new AirplaneList(target.loadAirplanes());
       clubMemberList= new ClubMemberList(target.loadClubMembers());
       crew= new Crew(target.loadCrewMembers());
    }


    @Override
    public ClubMemberList getClubMembers() {
        return clubMemberList;
    }

    @Override
    public AirportList getAirports() {
        return airportList;
    }

    @Override
    public AirplaneList getAirplanes() {
        return airplaneList;
    }

    @Override
    public Crew getCrewMembers() {
        return crew;
    }

    @Override
    public PassengerList getPassengers() {
        return passengerList;
    }

    @Override
    public FlightList getFlights() {
        return flightList;
    }

    @Override
    public void updateClubMember(ClubMember clubMember) {
        target.updateClubMember(clubMember);
    }

    @Override
    public void updateAirport(Airport airport) {
        target.updateAirport(airport);
    }

    @Override
    public void updateAirplane(Airplane airplane) {
        target.updateAirplane(airplane);
    }

    @Override
    public void updateCrewMember(CrewMember crewMember) {
        target.updateCrewMember(crewMember);
    }

    @Override
    public void updateFlight(Flight flight) {
        target.updateFlight(flight);
    }

    @Override
    public void addClubMember(ClubMember clubMember) {
        target.addClubMember(clubMember);
    }

    @Override
    public void addAirport(Airport airport) {
        target.addAirport(airport);
    }

    @Override
    public void addAirplane(Airplane airplane) {
        target.addAirplane(airplane);
    }

    @Override
    public void addCrewMember(CrewMember crewMember) {
        target.addCrewMember(crewMember);
    }

    @Override
    public void addPassenger(Passenger passenger) {
        target.addPassenger(passenger);
    }

    @Override
    public void addFlight(Flight flight) {
        target.addFlight(flight);
    }

    @Override
    public void removeClubMember(ClubMember clubMember) {
        target.removeClubMember(clubMember);
    }

    @Override
    public void removeAirport(Airport airport) {
        target.removeAirport(airport);
    }

    @Override
    public void removeAirplane(Airplane airplane) {
        target.removeAirplane(airplane);
    }

    @Override
    public void removeCrewMember(CrewMember crewMember) {
        target.removeCrewMember(crewMember);
    }
}
