package statushouse.ui;

import java.util.Scanner;

import statushouse.constant.HttpStatus;
import statushouse.model.VisitorLog;
import statushouse.service.VisitorLogReadService;
import statushouse.validation.InputValidator;

public class DetailMenu {

	private final Scanner scanner;
	private final VisitorLogReadService readService;
	private final InputValidator inputValidator;
	private final VisitorLogCommonUI commonUI;

	/**
	 * @param scanner
	 * @param readService
	 * @param inputValidator
	 */
	public DetailMenu(Scanner scanner, VisitorLogReadService readService, InputValidator inputValidator,
			VisitorLogCommonUI commonUI) {
		this.scanner = scanner;
		this.readService = readService;
		this.inputValidator = inputValidator;
		this.commonUI = commonUI;
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
			System.out.println(HttpStatus.NOT_FOUND.getStatusLine());
			return;
		}

		System.out.println(HttpStatus.OK.getStatusLine());
		commonUI.visitorLogCommonShow(log);
	}

}