package SWE1.turnstile.transistion_table;

import java.util.Vector;

public class Turnstile {
	private EState currentState = EState.LOCKED;
	private ITurnstilecontroller controller;
	
	private Vector<Transition> transitions = new Vector<Transition>();
	
	public Turnstile(ITurnstilecontroller controller) {
		this.controller = controller;
		controller.doLock();
		
		addTransition(EState.LOCKED, ETurnstileEvent.COIN, EState.OPEN, unlock());
		addTransition(EState.LOCKED, ETurnstileEvent.PASS, EState.LOCKED, alarm());
		addTransition(EState.OPEN, ETurnstileEvent.COIN, EState.OPEN, returnCoin());
		addTransition(EState.OPEN, ETurnstileEvent.PASS, EState.LOCKED, lock());
	}
	
	public void event(ETurnstileEvent event) {
		for (Transition transiton : transitions) {
			if ((currentState == transiton.currentState) && (event == transiton.event)) {
				currentState = transiton.nextState;
				transiton.action.execute();
			}
		}
	}
	
	private void addTransition(EState curentState, ETurnstileEvent event, EState nextState, IAction action) {
		transitions.add(new Transition(curentState, event, nextState, action));
	}
	
	private enum EState {
		OPEN,
		LOCKED
	}
	
	private class Transition {
		EState currentState;
		ETurnstileEvent event;
		EState nextState;
		IAction action;
		
		public Transition(EState curentState, ETurnstileEvent event, EState nextState, IAction action) {
			this.currentState = curentState;
			this.event = event;
			this.nextState = nextState;
			this.action = action;
		}
	}
	
	// Actions as anonymous implementations of IAction
	private interface IAction {
		void execute();
	}
	
	private IAction unlock() {
		return new IAction() {public void execute() {controller.doUnlock();}};
	}
	
	private IAction lock() {
		return new IAction() {public void execute() {controller.doLock();}};
	}
	
	private IAction alarm() {
		return new IAction() {public void execute() {controller.doAlarm();}};
	}
	
	private IAction returnCoin() {
		return new IAction() {public void execute() {controller.doReturnCoin();}};
	}
}
