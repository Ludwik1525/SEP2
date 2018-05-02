package via.domain.mediator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;

import via.domain.model.Event;
import via.domain.model.Lecturer;
import via.domain.model.Member;
import via.domain.model.Sponsor;

public class Proxy implements VIAModel {

private VIAModel model;
	
	public Proxy(VIAModel model)
	{
		this.model = model;
	}

	@Override
	public ArrayList<Member> getMembersWhoHaventPaid() throws IOException 
	{
		return model.getMembersWhoHaventPaid();
	}

	@Override
	public ArrayList<Member> getMembers() 
	{
		System.out.println("Access denied.");
		return null;
	}

	@Override
	public void addMember(Member member) throws IOException 
	{
		System.out.println("Access denied.");
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
