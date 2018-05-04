package Client;

import Client.controller.ClientVIAController;
import Client.domain.mediator.ClientVIAModelManager;
import Client.domain.model.Member;
import Client.view.ClientVIAConsole;

import java.io.IOException;
import java.util.Date;


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
