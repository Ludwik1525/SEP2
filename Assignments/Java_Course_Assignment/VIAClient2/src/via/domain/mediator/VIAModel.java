package via.domain.mediator;

import java.io.IOException;
import java.util.ArrayList;

import javafx.beans.Observable;
import via.domain.model.Event;
import via.domain.model.Lecturer;
import via.domain.model.Member;
import via.domain.model.Sponsor;

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
