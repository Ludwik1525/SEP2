
import java.io.IOException;

import via.controller.VIAController;
import via.domain.mediator.VIAModelManager;
import via.domain.model.Member;
import via.domain.model.MemberList;
import via.view.VIAConsole;

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
