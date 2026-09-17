package statushouse.ui;

import java.util.Scanner;

import statushouse.model.VisitorLog;
import statushouse.service.VisitorLogReadService;
import statushouse.service.VisitorLogUpdateService;
import statushouse.validation.InputValidator;

public class UpdateMenu {
	private Scanner scanner;
	private VisitorLogReadService readService;
	private VisitorLogUpdateService updateService;
	private InputValidator validator;

	/**
	 * @param scanner
	 * @param readService
	 * @param updateService
	 * @param inputValidator
	 */
	public UpdateMenu(Scanner scanner, VisitorLogReadService readService, VisitorLogUpdateService updateService,
			InputValidator validator) {
		this.scanner = scanner;
		this.readService = readService;
		this.updateService = updateService;
		this.validator = validator;
	}

	public void show() {
		System.out.println("Edit ID: ");
		String idInput = scanner.nextLine();

		while (!validator.isNumber(idInput)) {
			System.out.println("数字を入力してください。");
			System.out.print("Edit ID: ");
			idInput = scanner.nextLine();
		}

		int id = Integer.parseInt(idInput);

		VisitorLog log = readService.findById(id);

		if (log == null) {
			System.out.println("404 Not Found");
			return;
		}

		System.out.println("200 OK");
		System.out.println("ID: " + log.getId());
		System.out.println("Visitor Name: " + log.getVisitorName());
		System.out.println("Room Code: " + log.getRoomCode());
		System.out.println("Message: " + log.getMessage());
		System.out.println("Visited At: " + log.getVisitedAt());

		System.out.println();
		System.out.print("New Visitor Name: ");
		String visitorName = scanner.nextLine();

		while (validator.isEmpty(visitorName)) {
			System.out.println("名前を入力してください。");
			System.out.print("New Visitor Name: ");
			visitorName = scanner.nextLine();
		}
	}
}
