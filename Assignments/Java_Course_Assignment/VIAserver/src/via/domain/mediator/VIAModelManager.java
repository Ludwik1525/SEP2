package via.domain.mediator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;

import via.domain.model.*;

public class VIAModelManager extends Observable implements VIAModel{
	
	private MemberList memberList;
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
	public ArrayList<Member> getMembers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addMember(Member member) {
		setChanged();
		notifyObservers(member);
		memberList.addMember(member);
	}
	
	@Override
	public ArrayList<Lecturer> getLecturers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Lecturer> getLecturersByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Event> getAllEvents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Event> getEventsByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Sponsor> getSponsorsByTypeOfSponsorship(String typeOfSponsorship) {
		// TODO Auto-generated method stub
		return null;
	}


}
