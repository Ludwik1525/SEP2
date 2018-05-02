package SWE1.turnstile.state_pattern;


public class OpenState implements ITurnstileState{
	@Override
	public void coinInsertedEvent(Turnstile turnstile) {
		turnstile.doReturnCoin();
	}

	@Override
	public void passedEvent(Turnstile turnstile) {
		turnstile.doLock();
		turnstile.setLocked();
	}
}
