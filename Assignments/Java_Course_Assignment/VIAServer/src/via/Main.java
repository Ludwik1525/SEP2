package via;

import via.controller.VIAController;
import via.domain.mediator.VIAModelManager;
import via.view.VIAConsole;

import java.io.IOException;

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
