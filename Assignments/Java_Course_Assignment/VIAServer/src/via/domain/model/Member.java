package via.domain.model;

import java.util.Date;

public class Member {
	
	private String name;
	private String address;
	private String email;
	private long phoneNumber;
	private Date birthday;
	private Date dateForMembership;
	private boolean hasPaidMembership;
	private StarSign starSign;
//	private ArrayList<Event> attendedEvents;
	
	public Member(String name, String address, String email, long phoneNumber, Date birthday, Date dateForMembership,
				  boolean hasPaidMembership, String starSign)
	{
		this.name = name;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
		this.dateForMembership = dateForMembership;
		this.hasPaidMembership = hasPaidMembership;
		this.starSign = StarSignFactory.getStarSign(starSign);
	}
	
	public StarSign getStarSign()
	 {
		 return starSign;
	 }
	
	public void updateHasPaidMembership(boolean hasPaidMembership)
	{
		this.hasPaidMembership = hasPaidMembership;
	}
/*	
	public void updateHasPaidMembership2()
	{
		int currentDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		
		if(currentDay == dateForMembership.getDay() + 1 && currentMonth == dateForMembership.getMonth() && currentYear > dateForMembership.getYear())
			updateHasPaidMembership(false);
	}
	*/
	
	public String toString()
	{
		String all = "";
		all += "Name: " + name +"; Address: " + address + "; Email: " + email + 
				"; Phone number: " + phoneNumber + "; Birthday: " + birthday.toString() + "; Date of membership: " +
				dateForMembership +"; Star sign: "+starSign.getName()+"; Has paid fee: " + hasPaidMembership + ".";
		return all;			
	}
	
	public String getName()
	{
		return name;
	}
	
	public boolean getHasPaidMembership()
	{
		return hasPaidMembership;
	}

}
