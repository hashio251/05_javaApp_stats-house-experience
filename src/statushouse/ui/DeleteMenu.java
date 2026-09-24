package statushouse.ui;

import java.util.Scanner;

import statushouse.constant.HttpStatus;
import statushouse.model.VisitorLog;
import statushouse.service.VisitorLogDeleteService;
import statushouse.service.VisitorLogReadService;
import statushouse.validation.InputValidator;

public class DeleteMenu {
	private final Scanner scanner;
	private final VisitorLogReadService readService;
	private final VisitorLogDeleteService deleteService;
	private final InputValidator validator;
	private final VisitorLogCommonUI commonUI;

	/**
	 * @param scanner
	 * @param readService
	 * @param deleteService
	 * @param validator
	 */
	public DeleteMenu(Scanner scanner, VisitorLogReadService readService, VisitorLogDeleteService deleteService,
			InputValidator validator, VisitorLogCommonUI commonUI) {
		this.scanner = scanner;
		this.readService = readService;
		this.deleteService = deleteService;
		this.validator = validator;
		this.commonUI = commonUI;
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
			System.out.println(HttpStatus.NOT_FOUND.getStatusLine());
			return;
		}

		System.out.println(HttpStatus.OK.getStatusLine());
		commonUI.visitorLogCommonShow(log);

		System.out.println("本当に削除しますか？");
		System.out.println("1 : Yes");
		System.out.println("2 : No");
		System.out.print("数字を入力してください。: ");
		String inputAnswer = scanner.nextLine();

		while (!inputAnswer.equals("1") && !inputAnswer.equals("2")) {
			System.out.println("1か2を入力してください。");
			inputAnswer = scanner.nextLine();
		}

		if (inputAnswer.equals("1")) {
			deleteService.delete(id);
			System.out.println(HttpStatus.NO_CONTENT.getStatusLine());
		} else {
			System.out.println("削除をキャンセルしました。");
		}
		System.out.println();
	}
}
