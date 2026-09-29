package statushouse.ui.login;

import java.util.Scanner;

import statushouse.constant.HttpStatus;

public class Login {
	private final Scanner scanner;

	public Login(Scanner scanner) {
		this.scanner = scanner;
	}

	public String showLoginMenu() {

		while (true) {

			System.out.println();
			System.out.println("===== STATUS HOUSE LOGIN MENU =====");
			System.out.println("1. Visitor Login");
			System.out.println("2. Visitor Sign-up");
			System.out.println("0. Exit");
			System.out.println("===================================");
			System.out.println();
			System.out.print("Select Menu Number: ");

			String input = scanner.nextLine();

			if (input.equals("0")
					|| input.equals("1")
					|| input.equals("2")) {

				return input;
			}

			System.out.println(HttpStatus.BAD_REQUEST.getStatusLine());
			System.out.println("0-2の数字を入力してください。");
		}
	}
}
