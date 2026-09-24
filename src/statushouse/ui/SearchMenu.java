package statushouse.ui;

import java.util.Scanner;

import statushouse.constant.HttpStatus;
import statushouse.model.VisitorLog;
import statushouse.service.VisitorLogReadService;
import statushouse.validation.InputValidator;

public class SearchMenu {
	private final Scanner scanner;
	private final VisitorLogReadService readService;
	private final InputValidator validator;

	/**
	 * @param scanner
	 * @param readService
	 * @param validator
	 */
	public SearchMenu(Scanner scanner, VisitorLogReadService readService, InputValidator validator) {
		this.scanner = scanner;
		this.readService = readService;
		this.validator = validator;
	}

	public void show() {
		System.out.print("Search ID: ");
		String idInput = scanner.nextLine();

		while (!validator.isNumber(idInput)) {
			System.out.println("数字を入力してください。");
			idInput = scanner.nextLine();
		}

		int id = Integer.parseInt(idInput);

		VisitorLog log = readService.findById(id);

		if (log == null) {
			System.out.println(HttpStatus.NOT_FOUND.getStatusLine());
			System.out.println();
			return;
		}

		System.out.println(HttpStatus.OK.getStatusLine());
		System.out.println("ID: " + log.getId());
		System.out.println("Visitor Name: " + log.getVisitorName());
		System.out.println("Room Code: " + log.getRoomCode());
		System.out.println("Message: " + log.getMessage());
		System.out.println("Visited At: " + log.getVisitedAt());
		System.out.println();
	}

}
