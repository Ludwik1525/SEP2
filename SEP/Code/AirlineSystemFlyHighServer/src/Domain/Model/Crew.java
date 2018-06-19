package Domain.Model;

import Domain.Mediator.DatabaseAdapter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class Crew {
    private ObservableList<CrewMember> crewMemberList;

    public Crew() {
        this.crewMemberList = FXCollections.observableArrayList();
    }

    public Crew(ObservableList<CrewMember> crewMemberList) {
        this.crewMemberList = crewMemberList;
    }

    public ObservableList<CrewMember> getCrewMembers() {
        return crewMemberList;
    }


    public void updateList(ObservableList <CrewMember> crewMembers) {
        crewMemberList= crewMembers;
    }
}
