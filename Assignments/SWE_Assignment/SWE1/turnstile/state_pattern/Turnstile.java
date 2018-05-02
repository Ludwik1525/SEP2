package SWE1.turnstile.state_pattern;


public class Turnstile {
	private final LockedState LOCKED = new LockedState();
	private final OpenState OPEN = new OpenState();
	private ITurnstileState state = null;
	
	private ITurnstilecontroller controller = null;
	
	public Turnstile(ITurnstilecontroller controller) {
		this.controller = controller;
		setLocked();
		doLock();
	}
	
	// Handle external events
	public void coinInsertedEvent() {
		state.coinInsertedEvent(this);
	}
	
	public void passedEvent() {
		state.passedEvent(this);
	}
	
	// Actions
	protected void doLock() {
		controller.doLock();
	}
	
	protected void doUnlock() {
		controller.doUnlock();
	}	
	
	protected void doAlarm() {
		controller.doAlarm();
	}	
	
	protected void doReturnCoin() {
		controller.doReturnCoin();
	}

	// Set states
	protected void setLocked() {
		state = LOCKED;
	}
	
	protected void setOpen() {
		state = OPEN;
	}
}
