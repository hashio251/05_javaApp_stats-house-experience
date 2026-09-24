package statushouse.ui;

import java.util.Scanner;

import statushouse.constant.HttpStatus;
import statushouse.validation.InputValidator;

public class MainMenu {
	private final Scanner scanner;
	private final InputValidator validator;

	public MainMenu(Scanner scanner, InputValidator validator) {
		this.scanner = scanner;
		this.validator = validator;
	}

	public String showMenu() {
		// メソッドごと抜けるようにし、毎回表示させない
		while (true) {
			System.out.println("===== STATUS HOUSE =====");
			System.out.println("1. Visitor Check-in");
			System.out.println("2. Visitor Log List");
			System.out.println("3. Visitor Log Details");
			System.out.println("4. Edit Visitor Log");
			System.out.println("5. Delete Visitor Log");
			System.out.println("6. Search by ID");
			System.out.println("0. Exit");
			System.out.println("========================");

			String input = scanner.nextLine();
			if (validator.isValidMenu(input)) {
				return input;
			}
			System.out.println(HttpStatus.BAD_REQUEST.getStatusLine());
			System.out.println("0-6の数字を入力してください。");
		}
	}

}
