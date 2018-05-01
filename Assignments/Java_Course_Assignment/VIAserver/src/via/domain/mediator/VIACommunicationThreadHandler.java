package via.domain.mediator;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import com.google.gson.Gson;

import tasklist.domain.mediator.Package;


public class VIACommunicationThreadHandler implements Runnable {
	
	private DataInputStream in;
	private DataOutputStream out;
	private Socket socket;
	private String ip;
	private VIAModel model;
	
	public VIACommunicationThreadHandler(Socket socket, VIAModel model) throws IOException
	{
		this.socket = socket;
		in = new DataInputStream(socket.getInputStream());
		out = new DataOutputStream(socket.getOutputStream());
		this.ip = socket.getInetAddress().getHostAddress();
		this.model = model;
	}
	
	private int OK = 1;
	
	public void run()
	{
		
		while(OK ==1)
		{
			try
			{
				
				String clientText = in.readUTF();
				System.out.println("Client> " + clientText);
				
				Gson gson = new Gson();
				Package request = gson.fromJson(clientText,Package.class);
				System.out.println(request.toString());
				
				Package reply = operation(request);
				String json = gson.toJson(reply);
				out.writeUTF(json);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	private Package operation(Package request)
	{
		switch(request.getOperation())
		{			
			case "GET MEMBERS WHO HAVEN'T PAID":
			{
				if(model.getMembersWhoHaventPaid().size() == 0 )
				{
					Package reply= new Package("NO MEMBERS WHO HAVEN'T PAID");
					return reply;
				}
				else
				{
					Package reply= new Package(Package.GET_MEMBERS_WHO_HAVENT_PAID);
					return reply;
				}
			}
				
			case "GET ALL THE MEMBERS":
			{
				Package reply= new Package(Package.GET_ALL_THE_MEMBERS);
				return reply;
			}
			
			case "ADD MEMBER":
			{
				/*model.add(request.getTask()); 
				Package reply= new Package(Package.ADD_MEMBER);
				return reply;
				*/
			}
			
			case "GET LECTURERS":
			{
				Package reply= new Package(Package.GET_LECTURERS);
				return reply;
			}
			
			case "GET LECTURERS BY CATEGORY":
			{
				Package reply= new Package(Package.GET_LECTURERS_BY_CATEGORY);
				return reply;
			}
			
			case "GET FINALIZED EVENTS":
			{
				Package reply= new Package(Package.GET_FINALIZED_EVENTS);
				return reply;
			}
			
			case "GET EVENTS BY TYPE":
			{
				Package reply= new Package(Package.GET_EVENTS_BY_TYPE);
				return reply;
			}
			
			case "GET SPONSORS BY TYPE OF SPONSORSHIP":
			{
				Package reply= new Package(Package.GET_SPONSORS_BY_TYPE_OF_SPONSORSHIP);
				return reply;
			}
			
			case "EXIT":
			{
				OK = 0;
				Package reply= new Package(Package.EXIT);
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
