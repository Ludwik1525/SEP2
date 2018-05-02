package via.controller;

import via.view.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;

import via.domain.mediator.*;
import via.domain.model.*;

public class VIAController {

	private VIAModel model;
	private VIAView view;
	
	public VIAController(VIAModel model, VIAView view)
	{
		this.model = model;
		this.view = view;
		Observable obs = (Observable) model;
		obs.addObserver(this.view);
	}
	
	public void execute(int choice) 
	{
		switch(choice)
		{
			case 1:
				ArrayList<Member> members = model.getMembersWhoHaventPaid();
				view.show(members.toString()); break;
			case 2:
				ArrayList<Member> members2 = model.getMembers();
				view.show(members2.toString()); break;
			case 3: 
				String name = view.get("What is the name?");
				String address = view.get("What is the address?");
				String email = view.get("What is the email?");
				String phoneNumber = view.get("What is the phone number?");
				long phoneNo = -1;
				try
				{
					phoneNo = Long.parseLong(phoneNumber);
				}
				catch (NumberFormatException e) {}
				
				Date birth = null;
				try
				{	String birthday = view.get("What is the birthday?");
					DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
					birth = (Date)formatter.parse(birthday);
				}
				catch (Exception e) {} 
				
				Date dateMembership = null;
				try
				{	String dateForMembership = view.get("What is the date for membership");
					DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
					dateMembership = (Date)formatter.parse(dateForMembership);
				}
				catch (Exception e) {} 
				
				String paymentStatus = view.get("What is the payment status (true/false)?");
				Boolean hasPaidMembership = Boolean.valueOf(paymentStatus);
				String starSign = view.get("What is the star sign?");
				Member member = new Member(name, address, email, phoneNo, birth, dateMembership, hasPaidMembership, starSign);
				model.addMember(member);
				view.show(member.toString()); break;
			case 4: 
				try 
				{
					ArrayList<Lecturer> lecturers = model.getLecturers();
					view.show(lecturers.toString()); break;
				}
				catch(NullPointerException e)
				{
					view.show("Not implemented yet");
				}
			case 5: 
				try 
				{
					ArrayList<Lecturer> lecturers2 = model.getLecturersByCategory("astrology");
					view.show(lecturers2.toString()); break;
				}
				catch(NullPointerException e)
				{
					view.show("Not implemented yet");
				}
			case 6: 
				try 
				{
					ArrayList<Event> events = model.getAllEvents();
					view.show(events.toString()); break;
				}
				catch(NullPointerException e)
				{
					view.show("Not implemented yet");
				}
				
			case 7: 
				try 
				{
					ArrayList<Event> events2 = model.getEventsByType("lecture");
					view.show(events2.toString()); break;
				}
				catch(NullPointerException e)
				{
					view.show("Not implemented yet");
				}
		
			case 8: 
				try 
				{
					ArrayList<Sponsor> sponsors = model.getSponsorsByTypeOfSponsorship("some type");
					view.show(sponsors.toString()); break;
				}
				catch(NullPointerException e)
				{
					view.show("Not implemented yet");
				}
				
			case 0: System.exit(1); break;
			default: view.show("THERE IS NO SUCH OPTION"); break;
		}
	}
}
