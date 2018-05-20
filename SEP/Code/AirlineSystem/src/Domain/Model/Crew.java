package Domain.Model;

import java.util.ArrayList;

public class Crew {

    private ArrayList<CrewMember> crew;

    public Crew() {
        this.crew = new ArrayList<>();
    }

    public void addMember(CrewMember member) {
        crew.add(member);
    }

    public void deleteMember(CrewMember member) {
        crew.remove(member);
    }
}
