package via.domain.mediator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;

import javafx.beans.InvalidationListener;
import via.domain.model.Event;
import via.domain.model.Lecturer;
import via.domain.model.Member;
import via.domain.model.Sponsor;

public class ClientVIAModelManager extends Observable implements VIAModel{
	
	private VIAModel model;
	
	public ClientVIAModelManager() throws IOException
	{
		model = new VIAClient("10.152.220.35", 6789);
	}

	@Override
	public ArrayList<Member> getMembersWhoHaventPaid() throws IOException 
	{
		return model.getMembersWhoHaventPaid();
	}

	@Override
	public ArrayList<Member> getMembers() throws IOException 
	{
		return model.getMembers();
	}

	@Override
	public void addMember(Member member) throws IOException 
	{
		model.addMember(member);
	}

	@Override
	public ArrayList<Lecturer> getLecturers() throws IOException 
	{
		return model.getLecturers();
	}

	@Override
	public ArrayList<Lecturer> getLecturersByCategory(String category) throws IOException 
	{
		return model.getLecturersByCategory(category);
	}

	@Override
	public ArrayList<Event> getAllEvents() throws IOException 
	{
		return model.getAllEvents();
	}

	@Override
	public ArrayList<Event> getEventsByType(String type) throws IOException 
	{
		return model.getEventsByType(type);
	}

	@Override
	public ArrayList<Sponsor> getSponsorsByTypeOfSponsorship(String typeOfSponsorship) throws IOException 
	{
		return model.getSponsorsByTypeOfSponsorship(typeOfSponsorship);
	}


}
