package statushouse.ui;

import java.util.Scanner;

import statushouse.model.VisitorLog;
import statushouse.service.VisitorLogReadService;
import statushouse.validation.InputValidator;

public class DetailMenu {

	private Scanner scanner;
	private VisitorLogReadService readService;
	private InputValidator inputValidator;

	/**
	 * @param scanner
	 * @param readService
	 * @param inputValidator
	 */
	public DetailMenu(Scanner scanner, VisitorLogReadService readService, InputValidator inputValidator) {
		this.scanner = scanner;
		this.readService = readService;
		this.inputValidator = inputValidator;
	}

	public void show() {
		System.out.println("ID: ");
		String idInput = scanner.nextLine();

		while (!inputValidator.isNumber(idInput)) {
			System.out.println("IDを入力してください。");
			System.out.println("ID: ");
			idInput = scanner.nextLine();
		}

		int id = Integer.parseInt(idInput);

		VisitorLog log = readService.findById(id);

		if (log == null) {
			System.out.println("404 Not Found");
			return;
		}

		System.out.println("ID: " + log.getId());
		System.out.println("Visitor Name: " + log.getVisitorName());
		System.out.println("Room Code: " + log.getRoomCode());
		System.out.println("Message: " + log.getMessage());
		System.out.println("Visited At: " + log.getVisitedAt());
		System.out.println();
	}

}