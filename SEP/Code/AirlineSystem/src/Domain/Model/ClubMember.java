package Domain.Model;

import java.time.LocalDate;
import java.util.Date;

public class ClubMember extends Passenger {
    private String name;
    private String id;
    private String idType;
    private String nationality;
    private LocalDate birthday;
    private String phoneNumber;
    private String email;
    private String address;
    private LocalDate membershipDate;

    public ClubMember(String name, String id, String idType, String nationality, LocalDate birthday, String phoneNumber
            , String email,String address, LocalDate membershipDate) {
        super(name,id,idType,nationality,birthday,phoneNumber,email);
        this.address = address;
        this.membershipDate = membershipDate;
    }
    public ClubMember() {

    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMembershipDate(LocalDate membershipDate) {
        this.membershipDate = membershipDate;
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
