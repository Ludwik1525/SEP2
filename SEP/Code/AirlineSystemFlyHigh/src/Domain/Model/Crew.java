package Domain.Model;

import Domain.Mediator.DatabaseAdapter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class Crew {
    private ObservableList<CrewMember> crewMemberList;
    DatabaseAdapter adapter;

    public Crew() {
        this.adapter = new DatabaseAdapter();
        crewMemberList = adapter.loadCrewMembers();

    }

    public ObservableList<CrewMember> getCrewMembers() {
        return crewMemberList;
    }


    public void updateList(ObservableList <CrewMember> crewMembers) {
        crewMemberList= crewMembers;
    }
}
