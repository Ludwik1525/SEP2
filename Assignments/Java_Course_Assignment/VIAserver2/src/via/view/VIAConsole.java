package via.view;

import java.io.IOException;
import java.util.Observable;
import java.util.Scanner;
import via.controller.*;

public class VIAConsole implements VIAView, Runnable{

	private Scanner input;
	private VIAController controller;
	
	public VIAConsole() throws IOException
	{
		input = new Scanner(System.in);
		controller = null;
	}
	
	public void startView(VIAController controller) 
	{
		this.controller = controller;
		Thread t = new Thread();
		t.start(); 
	}
	
	public void run() 
	{
		boolean continueWorking = true;
		while (continueWorking) 
		{
			System.out.print("1) Type 1 for \"GET MEMBERS WHO HAVEN'T PAID\"\n" + "2) Type 2 for \"GET ALL THE MEMBERS\"" + "\n3) Type 3 for \"ADD MEMBER\"\n"
					+"4) Type 4 for \"GET LECTURERS\"\n" 
					+"5) Type 5 for \"GET LECTURERS BY CATEGORY\"\n" 
					+"6) Type 6 for \"GET ALL EVENTS\"\n" 
					+"7) Type 7 for \"GET EVENTS BY TYPE\"\n" 
					+"8) Type 8 for \"GET SPONSORS BY TYPE OF SPONSORSHIP\"\n" 
					+"0) Type 0 to \"EXIT\"\nEnter choice: ");
			int choice = input.nextInt();
			input.nextLine();
			
			controller.execute(choice);
			
			if (choice == 0) {
				continueWorking = false;
			}
		}
	}
	
	public String get(String text)
	{
		System.out.println(text);
		return input.nextLine();
	}
	
	public void show(String text)
	{
		System.out.println(text);
	}

	@Override
	public void update(Observable o, Object arg) 
	{
		show("Member added: " + arg.toString());
	}
}
