package Domain.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class Crew {
    private ObservableList<CrewMember> crewMemberList;
    LocalDate date= LocalDate.of(1999,02,03);
    public Crew() {
        crewMemberList = FXCollections.observableArrayList(
                new CrewMember("name", "position","address", "id","phoneNumber",  "email", date),
                new CrewMember("name", "position","address", "id","phoneNumber",  "email", date)
        );

    }

    public ObservableList<CrewMember> getCrewMembers() {
        return crewMemberList;
    }


    public void updateList(ObservableList <CrewMember> crewMembers) {
        crewMemberList= crewMembers;
    }
}
