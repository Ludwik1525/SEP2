package Client.domain.mediator;

import java.io.IOException;
import java.util.ArrayList;

import Client.domain.model.Event;
import Client.domain.model.Lecturer;
import Client.domain.model.Member;
import Client.domain.model.Sponsor;

public interface VIAModel  {
	
	ArrayList<Member> getMembersWhoHaventPaid() throws IOException;
	ArrayList<Member> getMembers() throws IOException;
	void addMember(Member member) throws IOException;
	ArrayList<Lecturer> getLecturers() throws IOException;
	ArrayList<Lecturer> getLecturersByCategory(String category) throws IOException;
	ArrayList<Event> getAllEvents() throws IOException;
	ArrayList<Event> getEventsByType(String type) throws IOException;
	ArrayList<Sponsor> getSponsorsByTypeOfSponsorship(String typeOfSponsorship) throws IOException;

}
