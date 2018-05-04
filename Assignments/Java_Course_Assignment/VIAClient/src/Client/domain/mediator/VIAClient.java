package Client.domain.mediator;

import Client.domain.model.Event;
import Client.domain.model.Lecturer;
import Client.domain.model.Member;
import Client.domain.model.Sponsor;
import com.google.gson.Gson;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;


public class VIAClient implements VIAModel{
	
	private DataInputStream in;
	private DataOutputStream out;
	private Socket socket;
	
	public VIAClient(String host, int port) throws IOException
	{
		socket = new Socket(host, port);
		in = new DataInputStream(socket.getInputStream());
		out = new DataOutputStream(socket.getOutputStream());
	}
	
	public void close() throws IOException
	{
	    remoteCall(new Package(Package.EXIT));
		socket.close();
	}

	@Override
	public ArrayList<Member> getMembersWhoHaventPaid() throws IOException 
	{
		return remoteCall(new Package(Package.GET_MEMBERS_WHO_HAVENT_PAID)).getMemberList();
	}

	@Override
	public ArrayList<Member> getMembers() throws IOException 
	{
		return remoteCall(new Package(Package.GET_ALL_THE_MEMBERS)).getMemberList();
	}

	@Override
	public void addMember(Member member) throws IOException 
	{
		remoteCall(new Package(Package.ADD_MEMBER, member, null));
	}

	@Override
	public ArrayList<Lecturer> getLecturers() throws IOException 
	{
		Package pckg1 = new Package(Package.GET_LECTURERS);
		Package pckg2 = remoteCall(pckg1);
		return null;
	}

	@Override
	public ArrayList<Lecturer> getLecturersByCategory(String category) throws IOException 
	{
		Package pckg1 = new Package(Package.GET_LECTURERS_BY_CATEGORY);
		Package pckg2 = remoteCall(pckg1);
		return null;
	}

	@Override
	public ArrayList<Event> getAllEvents() throws IOException 
	{
		Package pckg1 = new Package(Package.GET_ALL_EVENTS);
		Package pckg2 = remoteCall(pckg1);
		return null;
	}

	@Override
	public ArrayList<Event> getEventsByType(String type) throws IOException 
	{
		Package pckg1 = new Package(Package.GET_EVENTS_BY_TYPE);
		Package pckg2 = remoteCall(pckg1);
		return null;
	}

	@Override
	public ArrayList<Sponsor> getSponsorsByTypeOfSponsorship(String typeOfSponsorship) throws IOException {
        Package pckg1 = new Package(Package.GET_SPONSORS_BY_TYPE_OF_SPONSORSHIP);
        Package pckg2 = remoteCall(pckg1);
        return null;
    }
	
	private Package remoteCall(Package request) throws IOException
	{
		Gson gson = new Gson();
		String json = gson.toJson(request);
		out.writeUTF(json);
		
		String replyFromServer = in.readUTF();
		Package replyFromServerConverted = gson.fromJson(replyFromServer, Package.class);
		return replyFromServerConverted;
	}

}
