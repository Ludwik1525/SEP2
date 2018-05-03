package Server.domain.model;

import java.util.ArrayList;

public class MemberList {
	
	private static MemberList memberList;
	private ArrayList<Member> members;
	
	private MemberList()
	{
		members = new ArrayList<>();
	}
	
	public static MemberList getInstance() 
	{
		if (memberList == null) 
		{
			memberList = new MemberList();
		}
		return memberList;
	}
	
	public void addMember(Member member)
	{
		members.add(member);
	}
	
	public Member getMember(String name)
	{
		for(int i = 0; i < members.size(); i++)
			if(members.get(i).getName().equalsIgnoreCase(name))
				return members.get(i);
		return null;
	}
	public void editMember(String name)
	{
		
	}
	
	public void removeMember(String name)
	{
		
	}
	
	public ArrayList<Member> getMembers()
	{
		return members;
	}
	
	public ArrayList<Member> getMembersWhoHaventPaid()
	{
		ArrayList<Member> members2 = new ArrayList<>();
		
		for(int i = 0 ; i < members.size(); i++)
			if(members.get(i).getHasPaidMembership() == false)
				members2.add(members.get(i));	
		return members2;
	}
	
	public ArrayList<Member> getMembersByEventCategory(String category)
	{
	return null;
	}
	
	public ArrayList<Member> getMembersByLecturer(Lecturer lecturer)
	{
	return null;
	}
	
	public ArrayList<String> getEmailsOfMembers()
	{
		return null;
	}
	
	public String toString(ArrayList<Member> mem)
	{
		String all = "";
		for(int i = 0; i < mem.size(); i++)
			all += mem.get(i).toString() + "\n";
		return all;
	}
	
	
}
