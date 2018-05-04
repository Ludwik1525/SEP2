package via.domain.mediator;

import via.domain.model.Event;
import via.domain.model.Lecturer;
import via.domain.model.Member;
import via.domain.model.Sponsor;

import java.util.ArrayList;

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
