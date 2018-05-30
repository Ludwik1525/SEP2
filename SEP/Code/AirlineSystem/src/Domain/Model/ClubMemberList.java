package Domain.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class ClubMemberList {
    private ObservableList<ClubMember> clubMemberList;

    LocalDate date= LocalDate.of(Integer.parseInt("1998"), Integer.parseInt("03"), Integer.parseInt("04"));
    public ClubMemberList() {
        clubMemberList = FXCollections.observableArrayList(
                new ClubMember("name","id", "idType", "nationality", date, "phoneNumber", "email", "address", date ),
                new ClubMember("name","id", "idType", "nationality", date, "phoneNumber", "email", "address", date )
                );

    }

    public ObservableList<ClubMember> getClubMembers() {
        return clubMemberList;
    }


    public void updateList(ObservableList <ClubMember> clubMembers) {
        clubMemberList= clubMembers;
    }
}
