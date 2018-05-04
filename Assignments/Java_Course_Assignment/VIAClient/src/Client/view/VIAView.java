package Client.view;

import java.util.Observable;
import java.util.Observer;
import Client.controller.ClientVIAController;

public interface VIAView extends Observer{

    String get(String text);
    void show(String text);
    void startView(ClientVIAController controller);
    void update(Observable o, Object arg);

}
