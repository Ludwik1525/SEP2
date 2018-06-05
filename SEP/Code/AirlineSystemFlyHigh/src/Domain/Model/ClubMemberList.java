package Domain.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class ClubMemberList {
    private ObservableList<ClubMember> clubMemberList;

    LocalDate date= LocalDate.of(1998,03,04);
    public ClubMemberList() {
        clubMemberList = FXCollections.observableArrayList(
                new ClubMember("name","id", date, "phoneNumber", "email", "address",  date),
                new ClubMember("name","id", date, "phoneNumber", "email", "address",  date )
        );

    }

    public ObservableList<ClubMember> getClubMembers() {
        return clubMemberList;
    }


    public void updateList(ObservableList <ClubMember> clubMembers) {
        clubMemberList= clubMembers;
    }
}
