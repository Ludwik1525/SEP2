package Server.domain.mediator;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class VIAServer implements Runnable{
	
	private ServerSocket welcomeSocket;
	private VIAModel model;
	
	public VIAServer(VIAModel model,int port) throws IOException
	{
		welcomeSocket = new ServerSocket(port);
		this.model = model;
	}
	
	public void run()
	{
		while(true)
		{
			try
			{
				Socket socket = welcomeSocket.accept();
				VIACommunicationThreadHandler viacth = new VIACommunicationThreadHandler(socket, model);
				Thread t = new Thread(viacth);
				t.start();
			}
			catch(IOException e)
			{
				
			}
			
		}
	}

}
