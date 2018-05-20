package Domain.Model;

import java.util.Date;

public class CrewMember {
    private String name;
    private String position;
    private String address;
    private String id;
    private long phoneNumber;
    private String email;
    private Date birthdate;

    public CrewMember(String name, String position, String address, String id, long phoneNumber, String email,Date birthdate) {
        this.name = name;
        this.position = position;
        this.address = address;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.birthdate = birthdate;
    }

    public CrewMember() {

    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public String getAddress() {
        return address;
    }

    public String getPosition() {
        return position;
    }

    public boolean equals(Object object) {
        if (!(object instanceof CrewMember))
            return false;

        CrewMember member = (CrewMember) object;
        return ((member.getEmail().equals(this.getEmail())) && (member.getPhoneNumber()==this.getPhoneNumber())
                && (member.getName().equals(this.getName())) && (this.getId().equals(member.getId()))
                && (this.getBirthdate().equals(member.getBirthdate())) && (this.getAddress().equals(member.getAddress()))
                && (this.getPosition().equals(member.getPosition())));
    }

    @Override
    public String toString() {
        return "Name: "+getName()+": Birthdate: "+getBirthdate()+"; Position: "+getPosition()+"; Address: "+getAddress()+"; ID Number: "+getId()+
                "; Phone number: "+getPhoneNumber()+"; Email: "+getEmail();
    }
}
