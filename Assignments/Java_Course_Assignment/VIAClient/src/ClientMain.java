import java.io.IOException;

import via.controller.ClientVIAController;
import via.domain.mediator.ClientVIAModelManager;
import via.view.ClientVIAConsole;

public class ClientMain {
	public static void main(String args[]) throws IOException
	{
		ClientVIAModelManager model = new ClientVIAModelManager();
		ClientVIAConsole view = new ClientVIAConsole();
		ClientVIAController controller = new ClientVIAController(model, view);
		
		view.startView(controller);
		view.run();
	}

}
