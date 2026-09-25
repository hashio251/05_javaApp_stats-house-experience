package statushouse.model;

public class VisitorLog {
	private int id;
	private String visitorName;
	private String password;
	private int roomCode;
	private String message;
	private String visitedAt;

	/**
	 * @param id
	 * @param visitorName
	 * @param roomCode
	 * @param message
	 * @param visitedAt
	 */
	public VisitorLog(int id, String visitorName, String password, int roomCode, String message, String visitedAt) {
		this.id = id;
		this.visitorName = visitorName;
		this.password = password;
		this.roomCode = roomCode;
		this.message = message;
		this.visitedAt = visitedAt;
	}

	public int getId() {
		return id;
	}

	public String getVisitorName() {
		return visitorName;
	}

	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}

	public String getPassword() {
		return password;
	}

	public int getRoomCode() {
		return roomCode;
	}

	public void setRoomCode(int roomCode) {
		this.roomCode = roomCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getVisitedAt() {
		return visitedAt;
	}

}
