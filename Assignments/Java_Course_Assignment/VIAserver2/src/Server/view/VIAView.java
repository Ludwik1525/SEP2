package Server.view;

import java.util.Observable;
import java.util.Observer;

import Server.controller.VIAController;

public interface VIAView extends Observer{
	
	String get(String text);
	void show(String text);
	void startView(VIAController controller);
	void update(Observable o, Object arg);

}
