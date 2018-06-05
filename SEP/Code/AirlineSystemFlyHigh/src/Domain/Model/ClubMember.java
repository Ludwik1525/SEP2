package Domain.Model;

import java.time.LocalDate;

public class ClubMember  {
    private String name;
    private String id;
    private LocalDate birthdate;
    private String phoneNumber;
    private String email;
    private String address;
    private LocalDate membershipDate= LocalDate.now();
    private LocalDate subscription;

    public ClubMember(String name, String id, LocalDate birthday, String phoneNumber
            , String email,String address, LocalDate subscription) {
        this.name=name;
        this.id=id;
        this.birthdate =birthday;
        this.phoneNumber=phoneNumber;
        this.email=email;
        this.address = address;
        this.subscription=subscription;
    }


    public void setAddress(String address) {
        this.address = address;
    }

    public void setMembershipDate(LocalDate membershipDate) {
        this.membershipDate = membershipDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthdate = birthday;
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

    public LocalDate getBirthday() {
        return birthdate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


    public String getAddress() {
        return address;
    }

    public LocalDate getMembershipDate() {
        return membershipDate;
    }

    @Override
    public String toString() {
        return super.toString()+"; Address: "+getAddress()+"; Membership date: "+getMembershipDate();
    }
}
