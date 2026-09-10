package statushouse.ui;

import java.util.Scanner;

import statushouse.service.VisitorLogCreateService;

public class CreateMenu {
	private Scanner scanner;
	private VisitorLogCreateService createService;

	/**
	 * @param scanner
	 * @param createService
	 */
	public CreateMenu(Scanner scanner, VisitorLogCreateService createService) {
		this.scanner = scanner;
		this.createService = createService;
	}

	public void show() {
		System.out.print("Visitor Name: ");
		String visitorName = scanner.nextLine();

		System.out.println("Visitor Name: " + visitorName);
	}

}
