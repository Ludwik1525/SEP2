package via.domain.mediator;

import com.google.gson.Gson;
import via.domain.model.Member;
import via.view.VIAView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;


public class VIACommunicationThreadHandler implements Runnable {
	
	private DataInputStream in;
	private DataOutputStream out;
	private Socket socket;
	private String ip;
	private Proxy model;
	private VIAView view;
	
	public VIACommunicationThreadHandler(Socket socket, Proxy model)
	{
		try {
			this.socket = socket;
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
			this.ip = socket.getInetAddress().getHostAddress();
			this.model= (Proxy) model;
		} catch (IOException e) {
			System.out.println("Error for client connection. Message: "+e.getMessage());
		}
	}
	
	private int OK = 1;
	
	public void run()
	{
		
		while(OK ==1)
		{
			try
			{
				String clientText = in.readUTF();
				
				Gson gson = new Gson();
				Package request = gson.fromJson(clientText,Package.class);
				System.out.println("\nClient request: "+request.getOperation());
				
				Package reply = operation(request);
				String json = gson.toJson(reply);
				out.writeUTF(json);

				if (reply.getOperation().equals(Package.EXIT)) {
					OK = 0;
				}
			}
			catch (Exception e)
			{
				String message = e.getMessage();
				if (message == null)
				{
					message = "Connection lost";
				}
				System.out
						.println("Error for client: " + ip + " - Message: " + message);
			}
		}
	}
	
	private Package operation(Package request)
	{
		switch(request.getOperation())
		{			
			case "GET MEMBERS WHO HAVE NOT PAID":
			{

					ArrayList<Member> mlist = model.getMembersWhoHaventPaid();
					Package reply= new Package(Package.GET_MEMBERS_WHO_HAVENT_PAID, null, mlist);
					return reply;
			}
				
			case "GET ALL THE MEMBERS":
			{
				ArrayList<Member> mlist = model.getMembers();
				Package reply= new Package(Package.GET_ALL_THE_MEMBERS, null, mlist);
				return reply;
			}

			case "ADD MEMBER":
			{
				return new Package("ACCESS DENIED!");
			}
//
//			case "GET LECTURERS":
//			{
//				Package reply= new Package(Package.GET_LECTURERS);
//				return reply;
//			}
//
//			case "GET LECTURERS BY CATEGORY":
//			{
//				Package reply= new Package(Package.GET_LECTURERS_BY_CATEGORY);
//				return reply;
//			}
//
//			case "GET ALL EVENTS":
//			{
//				Package reply= new Package(Package.GET_ALL_EVENTS);
//				return reply;
//			}
//
//			case "GET EVENTS BY TYPE":
//			{
//				Package reply= new Package(Package.GET_EVENTS_BY_TYPE);
//				return reply;
//			}
//
//			case "GET SPONSORS BY TYPE OF SPONSORSHIP":
//			{
//				Package reply= new Package(Package.GET_SPONSORS_BY_TYPE_OF_SPONSORSHIP);
//				return reply;
//			}
			
			case Package.EXIT:
			{
				Package reply= new Package("EXIT");
				return reply;
			}
			default:
			{
				Package reply= new Package("WRONG FORMAT");
				return reply;
			}
		}
	}

}
