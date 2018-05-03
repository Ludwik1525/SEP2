package Server.domain.mediator;

import java.util.ArrayList;

import Server.domain.model.*;

public interface VIAModel {
	
	ArrayList<Member> getMembersWhoHaventPaid();
	ArrayList<Member> getMembers();
	void addMember(Member member);
	ArrayList<Lecturer> getLecturers();
	ArrayList<Lecturer> getLecturersByCategory(String category);
	ArrayList<Event> getAllEvents();
	ArrayList<Event> getEventsByType(String type);
	ArrayList<Sponsor> getSponsorsByTypeOfSponsorship(String typeOfSponsorship);

}
