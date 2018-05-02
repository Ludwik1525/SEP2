package via.domain.mediator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;

import via.domain.model.*;

public class VIAModelManager extends Observable implements VIAModel{
	
	private MemberList memberList;
	private LecturerList lecturerList;
	private EventList eventList;
	private SponsorList sponsorList;
	private VIAServer viaServer;
	
	public VIAModelManager() throws IOException
	{
		memberList  = MemberList.getInstance();
		viaServer = new VIAServer(this, 6789);
		Thread t = new Thread(viaServer);
		t.start();
	}

	@Override
	public synchronized ArrayList<Member> getMembersWhoHaventPaid() {
		return memberList.getMembersWhoHaventPaid();
	}
	
	@Override
	public ArrayList<Member> getMembers() 
	{
		return memberList.getMembers();
	}

	@Override
	public void addMember(Member member) {
		setChanged();
		notifyObservers(member);
		memberList.addMember(member);
	}
	
	@Override
	public ArrayList<Lecturer> getLecturers() 
	{
		return lecturerList.getLecturers();
	}

	@Override
	public ArrayList<Lecturer> getLecturersByCategory(String category) 
	{
		return lecturerList.getLecturersByCategory(category);
	}

	@Override
	public ArrayList<Event> getAllEvents() 
	{
		return eventList.getAllEvents();
	}

	@Override
	public ArrayList<Event> getEventsByType(String type) 
	{
		return eventList.getEventsByType(type);
	}

	@Override
	public ArrayList<Sponsor> getSponsorsByTypeOfSponsorship(String typeOfSponsorship) 
	{
		return sponsorList.getSponsorsByTypeOfSponsorship("some type");
	}

}
