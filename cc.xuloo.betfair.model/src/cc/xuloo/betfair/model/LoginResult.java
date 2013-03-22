package cc.xuloo.betfair.model;

public class LoginResult {

	private boolean success;
	
	private String reason;
	
	public LoginResult() {
		success = true;
	}
	
	public LoginResult(String reason) {
		this.reason = reason;
	}

	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}
}
