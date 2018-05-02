package SWE1.turnstile.state_pattern;

public interface ITurnstileState {
	public void coinInsertedEvent(Turnstile turnstile);
	public void passedEvent(Turnstile turnstile);
}
