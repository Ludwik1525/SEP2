package Domain.Model;

import java.util.Date;

public class Passenger {
    private String name;
    private String id;
    private String idType;
    private String nationality;
    private Date birthday;
    private long phoneNumber;
    private String email;

    public Passenger(String name, String id, String idType, String nationality, Date birthday, long phoneNumber
    , String email) {
        this.name = name;
        this.id = id;
        this.idType = idType;
        this.nationality = nationality;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    public Passenger() {

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

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(long phoneNumber) {
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

    public Date getBirthday() {
        return birthday;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String getNationality() {
        return nationality;
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

