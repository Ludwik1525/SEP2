package via.view;

import via.controller.VIAController;

import java.util.Observable;
import java.util.Observer;

public interface VIAView extends Observer{
	
	String get(String text);
	void show(String text);
	void startView(VIAController controller);
	void update(Observable o, Object arg);

}
