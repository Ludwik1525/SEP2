package Domain.Model;

import java.util.Date;

public class ClubMember extends Passenger {
    private String name;
    private String id;
    private String idType;
    private String nationality;
    private Date birthday;
    private long phoneNumber;
    private String email;
    private String address;
    private Date membershipDate;

    public ClubMember(String name, String id, String idType, String nationality, Date birthday, long phoneNumber
            , String email,String address, Date membershipDate) {
        super(name,id,idType,nationality,birthday,phoneNumber,email);
        this.address = address;
        this.membershipDate = membershipDate;
    }
    public ClubMember() {

    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMembershipDate(Date membershipDate) {
        this.membershipDate = membershipDate;
    }

    public String getAddress() {
        return address;
    }

    public Date getMembershipDate() {
        return membershipDate;
    }

    @Override
    public String toString() {
        return super.toString()+"; Address: "+getAddress()+"; Membership date: "+getMembershipDate();
    }
}
