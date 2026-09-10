package statushouse.validation;

public class InputValidator {
	// 空文字チェック
	public boolean isEmpty(String input) {
		if (input == null || input.trim().isEmpty()) {
			return true;
		}
		return false;
	}

	// 数値チェック
	public boolean isNumber(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	// メニュー番号チェック
	public boolean isValidMenu(String input) {
		if (!isNumber(input)) {
			return false;
		}
		int menu = Integer.parseInt(input);
		if (menu >= 0 && menu <= 6) {
			return true;
		}
		return false;
	}
}
