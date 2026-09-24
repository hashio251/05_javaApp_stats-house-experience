package statushouse.ui;

import java.util.Scanner;

import statushouse.model.VisitorLog;
import statushouse.service.VisitorLogDeleteService;
import statushouse.service.VisitorLogReadService;
import statushouse.validation.InputValidator;

public class DeleteMenu {
	private Scanner scanner;
	private VisitorLogReadService readService;
	private VisitorLogDeleteService deleteService;
	private InputValidator validator;

	/**
	 * @param scanner
	 * @param readService
	 * @param deleteService
	 * @param validator
	 */
	public DeleteMenu(Scanner scanner, VisitorLogReadService readService, VisitorLogDeleteService deleteService,
			InputValidator validator) {
		this.scanner = scanner;
		this.readService = readService;
		this.deleteService = deleteService;
		this.validator = validator;
	}

	public void show() {
		System.out.println("IDを入力してください。");
		System.out.println("Visitor ID: ");
		String inputId = scanner.nextLine();
		while (!validator.isNumber(inputId)) {
			System.out.println("IDを入力してください。");
			System.out.println("Visitor ID: ");
			inputId = scanner.nextLine();
		}
		int id = Integer.parseInt(inputId);

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

		System.out.println("本当に削除しますか？");
		System.out.println("1 : Yes");
		System.out.println("2 : No");
		System.out.print("数字を入力してください。: ");
		int userAnswer = scanner.nextInt();

		if (userAnswer == 1) {
			deleteService.delete(id);
			System.out.println("204 No Content");
		} else if (userAnswer == 2) {
			return;
		} else {
			while (userAnswer == 1 || userAnswer == 2)
				System.out.println("数字を入力してください。");
			userAnswer = scanner.nextInt();
		}

	}
}
