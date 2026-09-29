package statushouse.ui.login;

import java.util.Scanner;

import statushouse.constant.HttpStatus;
import statushouse.validation.InputValidator;

public class Login {
	private final Scanner scanner;
	private final InputValidator validator;

	public LoginMenu(Scanner scanner, InputValidator validator) {
		this.scanner = scanner;
		this.validator = validator;
	}

	public String showLoginMenu() {
		while (true) {
			System.out.println();
			System.out.println("===== STATUS HOUSE LOGIN MENU =====");
			System.out.println("1. Visitor Check-in");
			System.out.println("2. Visitor Sign-up(Start for the first time)");
			System.out.println("===================================");
			System.out.println();
			System.out.print("Select Menu Number: ");
			String input = scanner.nextLine();
			System.out.println();
		}

		if (validator.isValidMenu(input)) {
			return input;
		}
		System.out.println(HttpStatus.BAD_REQUEST.getStatusLine());
		System.out.println("1-2の数字を入力してください。");
		System.out.println();

	}
}
