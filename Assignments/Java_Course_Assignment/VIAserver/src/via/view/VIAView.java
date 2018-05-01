package via.view;

import java.util.Observable;
import java.util.Observer;

import via.controller.VIAController;

public interface VIAView extends Observer{
	
	String get(String text);
	void show(String text);
	void startView(VIAController controller);
	void update(Observable o, Object arg);

}
