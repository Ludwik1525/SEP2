package via.domain.mediator;

import java.util.ArrayList;

import via.domain.model.Member;

public class Package {
	
	public static final String GET_MEMBERS_WHO_HAVENT_PAID = "GET MEMBERS WHO HAVEN'T PAID";
	public static final String GET_ALL_THE_MEMBERS = "GET ALL THE MEMBERS";
	public static final String ADD_MEMBER = "ADD MEMBER";
	public static final String GET_LECTURERS = "GET LECTURERS";
	public static final String GET_LECTURERS_BY_CATEGORY = "GET LECTURERS BY CATEGORY";
	public static final String GET_ALL_EVENTS = "GET ALL EVENTS";
	public static final String GET_EVENTS_BY_TYPE = "GET EVENTS BY TYPE";
	public static final String GET_SPONSORS_BY_TYPE_OF_SPONSORSHIP = "GET SPONSORS BY TYPE OF SPONSORSHIP";
	public static final String EXIT = "EXIT";
	private Member member;
	private ArrayList<Member> memberList;
	private String operation;

	public Package(String operation, Member member,  ArrayList<Member> memberList) 
	{
		this.operation = operation;
		this.member = member;
		this.memberList = memberList;
	}
	
	public Package(String operation) 
	{
		this(operation, null,null);
	}

	public String getOperation() 
	{
		return operation;
	}
	
	public Member getMember()
	{
		return member;
	}
	
	public ArrayList<Member> getMemberList()
	{
		return memberList;
	}


}
