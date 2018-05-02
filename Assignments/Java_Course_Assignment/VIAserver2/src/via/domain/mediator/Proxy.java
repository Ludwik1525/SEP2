package via.domain.mediator;

import java.util.ArrayList;
import java.util.Observable;

import via.domain.model.Event;
import via.domain.model.Lecturer;
import via.domain.model.Member;
import via.domain.model.Sponsor;

public class Proxy implements VIAModel{
	
	private VIAModel model;
	
	public Proxy(VIAModel model)
	{
		this.model = model;
	}

	@Override
	public ArrayList<Member> getMembersWhoHaventPaid() {
		// TODO Auto-generated method stub
		return model.getMembersWhoHaventPaid();
	}

	@Override
	public ArrayList<Member> getMembers() {
		// TODO Auto-generated method stub
		System.out.println("Access denied.");
		return null;
	}

	@Override
	public void addMember(Member member) {
		model.addMember(member);
	}

	@Override
	public ArrayList<Lecturer> getLecturers() {
		// TODO Auto-generated method stub
		System.out.println("Access denied.");
		return null;
	}

	@Override
	public ArrayList<Lecturer> getLecturersByCategory(String category) {
		// TODO Auto-generated method stub
		System.out.println("Access denied.");
		return null;
	}

	@Override
	public ArrayList<Event> getAllEvents() {
		// TODO Auto-generated method stub
		System.out.println("Access denied.");
		return null;
	}

	@Override
	public ArrayList<Event> getEventsByType(String type) {
		// TODO Auto-generated method stub
		System.out.println("Access denied.");
		return null;
	}

	@Override
	public ArrayList<Sponsor> getSponsorsByTypeOfSponsorship(String typeOfSponsorship) {
		// TODO Auto-generated method stub
		System.out.println("Access denied.");
		return null;
	}

	public void update(Observable obs, Object obj) {
		System.out.println("Member added: " + obj.toString());
	}

}
