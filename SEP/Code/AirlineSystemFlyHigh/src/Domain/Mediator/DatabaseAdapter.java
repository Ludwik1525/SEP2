package Domain.Mediator;

import Domain.Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.lang.reflect.Executable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.*;

public class DatabaseAdapter implements Target  {
    Connection connection = null;
    Statement statement = null;

    public void connect(){
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5433/Fly_High_Database", "postgres",
                    "owd3sshp");

        } catch (SQLException e) {
            System.out.println("Connection failed. Check output console");
            e.printStackTrace();

        }
    }

    @Override
    public ObservableList<ClubMember> loadClubMembers() {
        connect();

        ObservableList<ClubMember> clubMemberList= FXCollections.observableArrayList(
        );
        try{
            statement=connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM clubmemberlist;");
            while (resultSet.next()){
                String name= resultSet.getString("name");
                String id= resultSet.getString("id");
                LocalDate birthdate= (resultSet.getDate("birthdate")).toLocalDate();
                int phoneNumber=resultSet.getInt("phonenumber");
                String email=resultSet.getString("email");
                String address= resultSet.getString("address");
                LocalDate membershipDate= (resultSet.getDate("membershipdate")).toLocalDate();
                boolean subscription= resultSet.getBoolean("subscription");

                clubMemberList.add(new ClubMember(name,id, birthdate, phoneNumber, email, address, membershipDate, subscription));
            }
        }catch (Exception e){
            System.err.println(e.getClass().getName()+"e.getMessage()");
           System.exit(0);
        }
        System.out.println("Retrieved club members successfully");
        return clubMemberList;
    }

    @Override
    public ObservableList<Airport> loadAirports() {
        connect();
        ObservableList<Airport> airportList= FXCollections.observableArrayList(
        );
        try{
            statement=connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM airportlist;");
            while (resultSet.next()){
                String code= resultSet.getString("code");
                String name= resultSet.getString("name");
                 String city=resultSet.getString("city");
                String postcode=resultSet.getString("postcode");
                String country= resultSet.getString("country");
                int numberofGates= resultSet.getInt("numberofgates");

                airportList.add(new Airport(code, name, city, postcode, country, numberofGates));
            }
        }catch (Exception e){
            System.err.println(e.getClass().getName()+"e.getMessage()");
            System.exit(0);
        }
        System.out.println("Retrieved airports successfully");
        return airportList;
    }

    @Override
    public ObservableList<Airplane> loadAirplanes() {
        connect();
        ObservableList<Airplane> airplaneList= FXCollections.observableArrayList(
        );
        try{
            statement=connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM airplanelist;");
            while (resultSet.next()){
                String idNumber= resultSet.getString("IDNumber");
                String model= resultSet.getString("model");
                int numberOfSeats=resultSet.getInt("numberOfSeats");
                LocalDate purchaseDate=resultSet.getDate("purchaseDate").toLocalDate();
                LocalDate lastMaintenance= resultSet.getDate("lastMaintenance").toLocalDate();

                airplaneList.add(new Airplane(idNumber, model, numberOfSeats, purchaseDate, lastMaintenance));
            }
        }catch (Exception e){
            System.err.println(e.getClass().getName()+"e.getMessage()");
            System.exit(0);
        }
        System.out.println("Retrieved airplanes successfully");
        return airplaneList;
    }

    @Override
    public ObservableList<CrewMember> loadCrewMembers() {
        connect();
        ObservableList<CrewMember> crewMemberList= FXCollections.observableArrayList(
        );
        try{
            statement=connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM crew;");
            while (resultSet.next()){
                int crewID=resultSet.getInt("crewID");
                String name= resultSet.getString("name");
                String position= resultSet.getString("position");
                String address= resultSet.getString("address");
                String id= resultSet.getString("id");
                int phoneNumber=resultSet.getInt("phoneNumber");
                String email= resultSet.getString("email");
                LocalDate birthdate=resultSet.getDate("birthdate").toLocalDate();

                crewMemberList.add(new CrewMember(name, position, address, id, phoneNumber, email, birthdate));
            }
        }catch (Exception e){
            System.err.println(e.getClass().getName()+"e.getMessage()");
            System.exit(0);
        }
        System.out.println("Retrieved crew members successfully");
        return crewMemberList;
    }

    @Override
    public ObservableList<Passenger> loadPassengers() {
        connect();
        ObservableList<Passenger> passengerList= FXCollections.observableArrayList(
        );
        try{
            statement=connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM passengerlist;");
            while (resultSet.next()){
                String name= resultSet.getString("name");
                String id= resultSet.getString("id");
                String idType= resultSet.getString("idType");
                String nationality= resultSet.getString("nationality");
                LocalDate birthdate=resultSet.getDate("birthdate").toLocalDate();
                int phoneNumber=resultSet.getInt("phoneNumber");
                String email= resultSet.getString("email");
                int seatNo=resultSet.getInt("seatNo");
                int luggageSize=resultSet.getInt("luggageSize");
                String paymentMenthod= resultSet.getString("paymentMethod");
                int passengerListID=resultSet.getInt("passengerListID");


                passengerList.add(new Passenger(name, id, idType, nationality, birthdate, phoneNumber, email, seatNo, luggageSize, paymentMenthod));
            }
        }catch (Exception e){
            System.err.println(e.getClass().getName()+"e.getMessage()");
            System.exit(0);
        }
        System.out.println("Retrieved passengers successfully");
        return passengerList;
    }

    @Override
    public ObservableList<Flight> loadFlights() {
        connect();
        ObservableList<Flight> flightList= FXCollections.observableArrayList(
        );
        try{
            statement=connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM flightlist;");
            while (resultSet.next()){
                int flightNumber=resultSet.getInt("flightNumber");
                LocalDate departureDate=resultSet.getDate("departureDate").toLocalDate();
              //  Time departureTime=resultSet.getTime("departureTime");
                LocalDate arrivalDate=resultSet.getDate("arrivalDate").toLocalDate();
                //Time arrivalTime= resultSet.getTime("arrivalTime");
                String departurePlace= resultSet.getString("departurePlace");
                String arrivalPlace= resultSet.getString("arrivalPlace");
                String status= resultSet.getString("status");
                String airplaneIdNumber= resultSet.getString("airplaneIdNumber");
               // int passengerListId=resultSet.getInt("passengerListId");
              //  int  crewId=resultSet.getInt("CrewID");
                double price=resultSet.getDouble("price");
                System.out.println("co sie dzieje");

                flightList.add(new Flight(flightNumber, departureDate, arrivalDate, departurePlace, arrivalPlace, status, airplaneIdNumber, price));
            }
        }catch (Exception e){
            e.printStackTrace();
           // System.err.println(e.getClass().getName()+"e.getMessage");
           // System.exit(0);
        }
        System.out.println("Retrieved flights successfully");
        return flightList;
    }

    @Override
    public void updateClubMembers(ClubMember clubMember) {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5433/Fly_High_Database", "postgres",
                    "owd3sshp");

        } catch (SQLException e) {
            System.out.println("Connection failed. Check output console");
            e.printStackTrace();
        }

        try{
            String tempId= clubMember.getId().toUpperCase();
            System.out.println(tempId);
            statement=connection.createStatement();
            String sql= "UPDATE ClubMemberList SET name ='"+clubMember.getName()+"' WHERE id='"+tempId+"';"+
              "UPDATE ClubMemberList SET address ='"+clubMember.getAddress()+"' WHERE id='"+tempId+"';"+
             "UPDATE ClubMemberList SET birthdate ='"+clubMember.getBirthday()+"' WHERE id='"+tempId+"';"+
             "UPDATE ClubMemberList SET phoneNumber ='"+clubMember.getPhoneNumber()+"' WHERE id='"+tempId+"';"+
                "UPDATE ClubMemberList SET email ='"+clubMember.getEmail()+"' WHERE id="+tempId+";"+
             "UPDATE ClubMemberList SET membershipDate ='"+clubMember.getMembershipDate()+"' WHERE id='"+tempId+"';";

             statement.executeUpdate(sql);
             connection.commit();

             System.out.println("Updated successfully.");

        }catch (Exception e){
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }
}
