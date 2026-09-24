package statushouse.constant;

// httpstatusのenum

public enum HttpStatus {
	// httpstatusログとして使うコード
	OK(200, "OK"), CREATED(201, "Created"), NO_CONTENT(204, "No Content"), BAD_REQUEST(400,
			"Bad Request"), FORBIDDEN(403,
					"Not Forbidden"), NOT_FOUND(404, "Not Found"), INTERNAL_SERVER_ERROR(500, "Internal Server Error");

	private final int code;
	private final String message;

	/**
	 * @param code
	 * @param message
	 */
	private HttpStatus(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public String getStatusLine() {
		return code + " " + message;
	}
}
