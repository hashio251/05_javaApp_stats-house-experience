package statushouse.ui.serch;

import java.util.Scanner;

import statushouse.constant.HttpStatus;
import statushouse.ui.Menu;
import statushouse.validation.InputValidator;

public class SearchMenu implements Menu {
	private final Scanner scanner;
	private final InputValidator validator;
	private final SearchByVisitorNameMenu searchByVisitorNameMenu;
	private final SearchByRoomCodeMenu searchByRoomCodeMenu;

	/**
	 * @param scanner
	 * @param validator
	 * @param searchByVisitorNameMenu
	 * @param searchByRoomCodeMenu
	 */
	public SearchMenu(Scanner scanner, InputValidator validator, SearchByVisitorNameMenu searchByVisitorNameMenu,
			SearchByRoomCodeMenu searchByRoomCodeMenu) {
		this.scanner = scanner;
		this.validator = validator;
		this.searchByVisitorNameMenu = searchByVisitorNameMenu;
		this.searchByRoomCodeMenu = searchByRoomCodeMenu;
	}

	@Override
	public void show() {

		while (true) {

			System.out.println("===== Search =====");
			System.out.println("1. Search by Visitor Name");
			System.out.println("2. Search by Room Code");
			System.out.println("0. Back");
			System.out.println("==================");

			String input = scanner.nextLine();

			if (!validator.isNumber(input)) {
				System.out.println(HttpStatus.BAD_REQUEST.getStatusLine());
				System.out.println("数字を入力してください。");
				continue;
			}

			if (input.equals("1")) {
				searchByVisitorNameMenu.show();
				return;
			}

			if (input.equals("2")) {
				searchByRoomCodeMenu.show();
				return;
			}

			if (input.equals("0")) {
				return;
			}

			System.out.println(HttpStatus.BAD_REQUEST.getStatusLine());
			System.out.println("0-2の数字を入力してください。");
		}
	}

}