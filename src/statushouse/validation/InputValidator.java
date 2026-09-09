package statushouse.validation;

public class InputValidator {
	public boolean isEmpty(String input) {
		if (input == null || input.trim().isEmpty()) {
			return true;
		}
		return false;
	}
}
