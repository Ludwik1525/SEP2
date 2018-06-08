package Domain.Model;

import java.time.LocalDate;
import java.util.Date;

public class Passenger {
    private String name;
    private String id;
    private String idType;
    private String nationality;
    private LocalDate birthdate;
    private int phoneNumber;
    private String email;
    private int seatNo;
    private int luggageSize;
    private String paymentMethod;

    public Passenger(String name, String id, String idType, String nationality, LocalDate birthday, int phoneNumber
            , String email, int seatNo, int luggageSize, String paymentMethod) {
        this.name = name;
        this.id = id;
        this.idType = idType;
        this.nationality = nationality;
        this.birthdate = birthday;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.seatNo=seatNo;
        this.luggageSize=luggageSize;
        this.paymentMethod=paymentMethod;
    }
    public Passenger(String name, String id, String nationality, LocalDate birthday, String phoneNumber
            , String email) {

    }

    public void setName(String name) {
        this.name = name;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthdate = birthday;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }

    public String getIdType() {
        return idType;
    }

    public LocalDate getBirthday() {
        return birthdate;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getNationality() {
        return nationality;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public int getLuggageSize() {
        return luggageSize;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setLuggageSize(int luggageSize) {
        this.luggageSize = luggageSize;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }

    public boolean equals(Object object) {
        if (!(object instanceof Passenger))
            return false;

        Passenger pass = (Passenger) object;
        return ((pass.getEmail().equals(this.getEmail()))&&(pass.getPhoneNumber()==this.getPhoneNumber())
                && (pass.getName().equals(this.getName()))&&(pass.getIdType().equals(this.getIdType()))
                && (this.getId().equals(pass.getId()))&&(this.getNationality().equals(pass.getNationality()))
                && (this.getBirthday().equals(pass.getBirthday())));
    }

    @Override
    public String toString() {
        return "Name: "+getName()+"; Birthday: "+getBirthday()+"; Nationality: "+getNationality()+"; ID type: "+
                getIdType()+"; ID Number: "+getId()+"; Phone number: "+getPhoneNumber()+"; Email: "+getEmail();
    }
}

