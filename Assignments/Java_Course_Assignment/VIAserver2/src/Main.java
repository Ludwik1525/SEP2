
import java.io.IOException;

import Server.controller.VIAController;
import Server.domain.mediator.VIAModelManager;
import Server.view.VIAConsole;

public class Main {
	public static void main(String[] args) throws IOException
	{
		VIAModelManager model = new VIAModelManager();
		VIAConsole view = new VIAConsole();
		VIAController controller = new VIAController(model, view);
		
		view.startView(controller);
		view.run();
		
	}

}
