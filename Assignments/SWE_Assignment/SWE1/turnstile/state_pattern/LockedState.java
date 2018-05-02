package SWE1.turnstile.state_pattern;

public class LockedState implements ITurnstileState {
	@Override
	public void coinInsertedEvent(Turnstile turnstile) {
		turnstile.doUnlock();
		turnstile.setOpen();
	}

	@Override
	public void passedEvent(Turnstile turnstile) {
		turnstile.doAlarm();
	}
}
