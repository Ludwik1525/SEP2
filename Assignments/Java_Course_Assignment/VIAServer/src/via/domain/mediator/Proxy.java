package via.domain.mediator;

import via.domain.model.Event;
import via.domain.model.Lecturer;
import via.domain.model.Member;
import via.domain.model.Sponsor;

import java.util.ArrayList;
import java.util.Observable;

public class Proxy implements VIAModel {

    private VIAModel model;

    public Proxy(VIAModel model)
    {
        this.model = model;
    }

    @Override
    public synchronized ArrayList<Member> getMembersWhoHaventPaid()
    {
        return model.getMembersWhoHaventPaid();
    }

    @Override
    public synchronized ArrayList<Member> getMembers()
    {
        return new ArrayList<>();
    }

    @Override
    public synchronized void addMember(Member member)
    {

    }

    @Override
    public ArrayList<Lecturer> getLecturers()
    {
        System.out.println("Access denied.");
        return null;
    }

    @Override
    public ArrayList<Lecturer> getLecturersByCategory(String category)
    {
        System.out.println("Access denied.");
        return null;
    }

    @Override
    public ArrayList<Event> getAllEvents()
    {
        System.out.println("Access denied.");
        return null;
    }

    @Override
    public ArrayList<Event> getEventsByType(String type)
    {
        System.out.println("Access denied.");
        return null;
    }

    @Override
    public ArrayList<Sponsor> getSponsorsByTypeOfSponsorship(String typeOfSponsorship)
    {
        System.out.println("Access denied.");
        return null;
    }

    public void update(Observable obs, Object obj)
    {
        System.out.println("Member added: " + obj.toString());
    }
}