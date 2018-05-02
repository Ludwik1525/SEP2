package SWE1.turnstile.state_pattern;

public interface ITurnstilecontroller {
	public void doUnlock();
	public void doLock();
	public void doAlarm();
	public void doReturnCoin();
}
