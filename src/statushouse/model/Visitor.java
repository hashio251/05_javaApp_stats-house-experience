package statushouse.model;

public class Visitor {
	private int id;
	private String visitorName;
	private String password;
	private String signupAt;

	/**
	 * @param id
	 * @param visitorName
	 * @param password
	 * @param signupAt
	 */
	public Visitor(int id, String visitorName, String password, String signupAt) {
		this.id = id;
		this.visitorName = visitorName;
		this.password = password;
		this.signupAt = signupAt;
	}

	public int getId() {
		return id;
	}

	public String getVisitorName() {
		return visitorName;
	}

	public String getPassword() {
		return password;
	}

	public String getSignupAt() {
		return signupAt;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
