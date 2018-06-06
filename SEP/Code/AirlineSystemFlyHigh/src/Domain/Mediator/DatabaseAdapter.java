package Domain.Mediator;

import Domain.Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.io.PrintWriter;
import java.lang.reflect.Executable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Logger;

public class DatabaseAdapter implements Target  {
    Connection connection = null;
    Statement statement = null;
    DataSource dataSource= new DataSource() {
        @Override
        public Connection getConnection() throws SQLException {
            try {
                connection = DriverManager.getConnection(
                        "jdbc:postgresql://127.0.0.1:5433/Fly_High_Database", "postgres",
                        "owd3sshp");

            } catch (SQLException e) {
                System.out.println("Connection failed. Check output console");
                e.printStackTrace();

            }
            return connection;
        }

        @Override
        public Connection getConnection(String username, String password) throws SQLException {
            try {
                connection = DriverManager.getConnection(
                        "jdbc:postgresql://127.0.0.1:5433/Fly_High_Database", "postgres",
                        "owd3sshp");

            } catch (SQLException e) {
                System.out.println("Connection failed. Check output console");
                e.printStackTrace();

            }return connection;
        }

        @Override
        public <T> T unwrap(Class<T> iface) throws SQLException {
            return null;
        }

        @Override
        public boolean isWrapperFor(Class<?> iface) throws SQLException {
            return false;
        }

        @Override
        public PrintWriter getLogWriter() throws SQLException {
            return null;
        }

        @Override
        public void setLogWriter(PrintWriter out) throws SQLException {

        }

        @Override
        public void setLoginTimeout(int seconds) throws SQLException {

        }

        @Override
        public int getLoginTimeout() throws SQLException {
            return 0;
        }

        @Override
        public Logger getParentLogger() throws SQLFeatureNotSupportedException {
            return null;
        }
    };

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
                LocalDate birthdate= (resultSet.getDate("birthdate").toLocalDate());
                int phoneNumber=resultSet.getInt("phonenumber");
                String email=resultSet.getString("email");
                String address= resultSet.getString("address");
                LocalDate membershipDate= (resultSet.getDate("membershipdate").toLocalDate());
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
    public void updateClubMember(ClubMember clubMember) {
       connect();

        try{
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);

            statement=connection.createStatement();
            String temp= clubMember.getId();
            String sql= "UPDATE ClubMemberList SET name ='"+clubMember.getName()+"' WHERE id='"+temp+"';"+
              "UPDATE ClubMemberList SET address ='"+clubMember.getAddress()+"' WHERE id='"+temp+"';"+
             "UPDATE ClubMemberList SET birthdate ='"+clubMember.getBirthday()+"' WHERE id='"+temp+"';"+
             "UPDATE ClubMemberList SET phoneNumber ='"+clubMember.getPhoneNumber()+"' WHERE id='"+temp+"';"+
                "UPDATE ClubMemberList SET email ='"+clubMember.getEmail()+"' WHERE id="+temp+";"+
             "UPDATE ClubMemberList SET membershipDate ='"+clubMember.getMembershipDate()+"' WHERE id='"+temp+"';";

             statement.executeUpdate(sql);
             connection.commit();

             System.out.println("Updated successfully.");

        }catch (Exception e){
            e.printStackTrace();
           //System.err.println(e.getClass().getName()+": "+e.getMessage());
           // System.exit(0);
        }
    }

    @Override
    public void updateAirport(Airport airport) {
        connect();

        try{
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);

            statement=connection.createStatement();
            String temp= airport.getCode();
            String sql= "UPDATE airportlist SET name ='"+airport.getName()+"' WHERE code='"+temp+"';"+
              "UPDATE airportlist SET city ='"+airport.getCity()+"' WHERE code='"+temp+"';"+
             "UPDATE airportlist SET postcode ='"+airport.getPostcode()+"' WHERE code='"+temp+"';"+
             "UPDATE airportlist SET country ='"+airport.getCountry()+"' WHERE code='"+temp+"';"+
                "UPDATE airportlist SET numberOfGates ='"+airport.getNumberOfGates()+"' WHERE code="+temp+";";
            statement.executeUpdate(sql);
            connection.commit();

            System.out.println("Updated successfully.");

        }catch (Exception e){
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }

    }

    @Override
    public void updateAirplane(Airplane airplane) {
        connect();

        try{
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);

            statement=connection.createStatement();
            String temp= airplane.getIDNumber();
            String sql= "UPDATE airplanelist SET model ='"+airplane.getModel()+"' WHERE IDNumber='"+temp+"';"+
             "UPDATE airplanelist SET numberofseats ='"+airplane.getNumberOfSeats()+"' WHERE IDNumber='"+temp+"';"+
             "UPDATE airplanelist SET purchaseDate ='"+airplane.getPurchaseDate()+"' WHERE IDNumber='"+temp+"';"+
             "UPDATE airplanelist SET lastMaintenance ='"+airplane.getLastMaintenance()+"' WHERE IDNumber='"+temp+"';";

            statement.executeUpdate(sql);
            connection.commit();

            System.out.println("Updated successfully.");

        }catch (Exception e){
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }

    }

    @Override
    public void updateCrewMember(CrewMember crewMember) {
        connect();

        try{
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);

            statement=connection.createStatement();
            String temp= crewMember.getId();
            String sql= "UPDATE crew SET name ='"+crewMember.getName()+"' WHERE id='"+temp+"';"+
              "UPDATE crew SET position ='"+crewMember.getPosition()+"' WHERE id='"+temp+"';"+
             "UPDATE crew SET address ='"+crewMember.getAddress()+"' WHERE id='"+temp+"';"+
             "UPDATE crew SET phonenumber ='"+crewMember.getPhoneNumber()+"' WHERE id='"+temp+"';"+
                "UPDATE crew SET email ='"+crewMember.getEmail()+"' WHERE id="+temp+";"+
             "UPDATE crew SET birthdate ='"+crewMember.getBirthdate()+"' WHERE id='"+temp+"';";

            statement.executeUpdate(sql);
            connection.commit();

            System.out.println("Updated successfully.");

        }catch (Exception e){
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }

    }



//    @Override
//    public void updatePassenger(Passenger passenger) {
//        connect();
//
//        try{
//            connection = dataSource.getConnection();
//            connection.setAutoCommit(false);
//
//            statement=connection.createStatement();
//            String temp= passenger.getId();
//            String sql= "UPDATE passengerlist SET name ='"+passenger.getName()+"' WHERE id='"+temp+"';"+
//              "UPDATE passengerlist SET idtype ='"+passenger.getIdType()+"' WHERE id='"+temp+"';"+
//             "UPDATE passengerlist SET nationality ='"+passenger.getNationality()+"' WHERE id='"+temp+"';"+
//             "UPDATE passengerlist SET birthdate ='"+passenger.getBirthday()+"' WHERE id='"+temp+"';"+
//              "UPDATE passengerlist SET phonenumber ='"+passenger.getPhoneNumber()+"' WHERE id="+temp+";"+
//              "UPDATE passengerlist SET email ='"+passenger.getEmail()+"' WHERE id='"+temp+"';"+
//            "UPDATE passengerlist SET seatno ='"+passenger.getSeatNo()+"' WHERE id="+temp+";"+
//            "UPDATE passengerlist SET luggagesize ='"+passenger.getLuggageSize()+"' WHERE id="+temp+";"+
//             "UPDATE passengerlist SET paymentmethod ='"+passenger.getPaymentMethod()+"' WHERE id="+temp+";";
//
//            statement.executeUpdate(sql);
//            connection.commit();
//
//            System.out.println("Updated successfully.");
//
//        }catch (Exception e){
//            System.err.println(e.getClass().getName()+": "+e.getMessage());
//            System.exit(0);
//        }
//
//    }

    @Override
    public void updateFlight(Flight flight) {
        connect();

        try{
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);

            statement=connection.createStatement();
//            String tempId= flight
//            String sql= "UPDATE ClubMemberList SET name ='"+clubMember.getName()+"' WHERE id='"+tempId+"';"+
//              "UPDATE ClubMemberList SET address ='"+clubMember.getAddress()+"' WHERE id='"+tempId+"';"+
//             "UPDATE ClubMemberList SET birthdate ='"+clubMember.getBirthday()+"' WHERE id='"+tempId+"';"+
//             "UPDATE ClubMemberList SET phoneNumber ='"+clubMember.getPhoneNumber()+"' WHERE id='"+tempId+"';"+
//                "UPDATE ClubMemberList SET email ='"+clubMember.getEmail()+"' WHERE id="+tempId+";"+
//             "UPDATE ClubMemberList SET membershipDate ='"+clubMember.getMembershipDate()+"' WHERE id='"+tempId+"';";

//            statement.executeUpdate(sql);
//            connection.commit();

            System.out.println("Updated successfully.");

        }catch (Exception e){
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }

    }

    @Override
    public void addClubMember(ClubMember clubMember) {
        connect();

        try{
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);

            statement=connection.createStatement();
            System.out.println(clubMember.getBirthday());
            String sql= "INSERT INTO ClubMemberList (name, address, login, password, id, birthdate, phoneNumber, email, membershipDate, subscription) VALUES" +
                    "('"+clubMember.getName()+"', '"+clubMember.getAddress()+"', 'logIn', 'password1', '"
                    +clubMember.getId()+"', '"+clubMember.getBirthday()+"', '"
                    +clubMember.getPhoneNumber()+"', '"+clubMember.getEmail()+"', '"+clubMember.getMembershipDate()+"', true)";

            statement.executeUpdate(sql);
            connection.commit();
            System.out.println("Added successfully.");

        }catch (Exception e){
            e.printStackTrace();
           // System.err.println(e.getClass().getName()+": "+e.getMessage());
           // System.exit(0);
        }
    }

    @Override
    public void addAirport(Airport airport) {
        connect();


        try{

            connection = dataSource.getConnection();
            connection.setAutoCommit(false);

            statement=connection.createStatement();
            String sql= "INSERT INTO  airportlist(code, name, city, postcode, country, numberofgates) VALUES" +
                    "('"+airport.getCode()+"', '"+airport.getName()+"', '"+airport.getCity()+"', '"+airport.getPostcode()+"', '"+airport.getCountry()+"', '"+airport.getNumberOfGates()+"');";

            statement.executeUpdate(sql);
            statement.close();
            connection.commit();
            connection.close();

            System.out.println("Updated successfully.");

        }catch (Exception e){
             System.err.println(e.getClass().getName()+": "+e.getMessage());
             System.exit(0);
        }
    }

    @Override
    public void addAirplane(Airplane airplane) {
        connect();

        try{

            connection = dataSource.getConnection();
            connection.setAutoCommit(false);

            statement=connection.createStatement();
            String sql= "INSERT INTO  airplanelist(idnumber, model, numberofseats, purchasedate, lastmaintenance) VALUES" +
                    "('"+airplane.getIDNumber()+"', '"+airplane.getModel()+"', '"+airplane.getNumberOfSeats()+"', '"+airplane.getPurchaseDate()+"', '"+airplane.getLastMaintenance()+"');";

            statement.executeUpdate(sql);
            statement.close();
            connection.commit();
            connection.close();

            System.out.println("Added successfully.");

        }catch (Exception e){
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }

    }

    @Override
    public void addCrewMember(CrewMember crewMember) {
        connect();

        try{

            connection = dataSource.getConnection();
            connection.setAutoCommit(false);

            statement=connection.createStatement();
            String sql= "INSERT INTO  crew(crewid, name, position, address, id, phonenumber, email, birthdate) VALUES " +
             "( 1, '"+crewMember.getName()+"', '"+crewMember.getPosition()+"', '"+crewMember.getAddress()+"', '"+crewMember.getId()+"', '"+crewMember.getPhoneNumber()+"', '"+crewMember.getEmail()+"', '"+crewMember.getBirthdate()+"');";

            statement.executeUpdate(sql);
            statement.close();
            connection.commit();
            connection.close();

            System.out.println("Added successfully.");

        }catch (Exception e){
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }

    @Override
    public void addPassenger(Passenger passenger) {
        connect();


        try{

            connection = dataSource.getConnection();
            connection.setAutoCommit(false);

            statement=connection.createStatement();
            String sql= "INSERT INTO  passengerlist(name, id, idType, nationality, birthdate, phonenumber, email, seatno, luggagesize, paymentmethod, passengerlistid) VALUES" +
                    "('"+passenger.getName()+"', '"+passenger.getId()+"', '"+passenger.getIdType()+"', '"+passenger.getNationality()+"', '"+passenger.getBirthday()+"', '"+passenger.getPhoneNumber()+"', '"+passenger.getEmail()+"', '"+passenger.getSeatNo()+"', '"+passenger.getLuggageSize()+"', '"+passenger.getPaymentMethod()+"', 1);";

            statement.executeUpdate(sql);
            statement.close();
            connection.commit();
            connection.close();

            System.out.println("Updated successfully.");

        }catch (Exception e){
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }

    @Override
    public void addFlight(Flight flight) {

    }

    @Override
    public void removeClubMember(ClubMember clubMember) {
        connect();
        try{

            connection = dataSource.getConnection();
            connection.setAutoCommit(false);


            statement=connection.createStatement();
            String sql= "DELETE FROM clubmemberlist WHERE id ='"+clubMember.getId()+"';";

            statement.executeUpdate(sql);
            connection.commit();

            System.out.println("Removed successfully.");

        }catch (Exception e){
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }

    @Override
    public void removeAirport(Airport airport) {
        connect();
        try{

            connection = dataSource.getConnection();
            connection.setAutoCommit(false);


            statement=connection.createStatement();
            String sql= "DELETE FROM airportlist WHERE code ='"+airport.getCode()+"';";

            statement.executeUpdate(sql);
            connection.commit();

            System.out.println("Removed successfully.");

        }catch (Exception e){
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }

    @Override
    public void removeAirplane(Airplane airplane) {
        connect();
        try{

            connection = dataSource.getConnection();
            connection.setAutoCommit(false);


            statement=connection.createStatement();
            String sql= "DELETE FROM airplanelist WHERE idNumber ='"+airplane.getIDNumber()+"';";

            statement.executeUpdate(sql);
            connection.commit();

            System.out.println("Removed successfully.");

        }catch (Exception e){
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }

    @Override
    public void removeCrewMember(CrewMember crewMember) {
        connect();


        try{

            connection = dataSource.getConnection();
            connection.setAutoCommit(false);


            statement=connection.createStatement();
            String sql= "DELETE FROM crew WHERE id ='"+crewMember.getId()+"';";

            statement.executeUpdate(sql);
            connection.commit();

            System.out.println("Removed successfully.");

        }catch (Exception e){
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }
}
