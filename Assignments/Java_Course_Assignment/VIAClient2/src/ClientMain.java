import java.io.IOException;
import java.util.Date;

import via.controller.ClientVIAController;
import via.domain.mediator.ClientVIAModelManager;
import via.domain.model.Member;
import via.view.ClientVIAConsole;

public class ClientMain {
	public static void main(String args[]) throws IOException
	{
		ClientVIAModelManager model = new ClientVIAModelManager();
		ClientVIAConsole view = new ClientVIAConsole();
		ClientVIAController controller = new ClientVIAController(model, view);
		model.addMember(new Member("adssad","asdasd","asdasd", 1234,
				new Date(25/12/2000), new Date(12/03/2017),false,"Leo"));
		
		view.startView(controller);
		view.run();
	}

}
