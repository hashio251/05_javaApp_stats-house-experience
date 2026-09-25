package statushouse.ui;

import java.util.Scanner;

import statushouse.constant.HttpStatus;
import statushouse.model.VisitorLog;
import statushouse.service.VisitorLogDeleteService;
import statushouse.service.VisitorLogReadService;
import statushouse.validation.InputValidator;

public class DeleteMenu implements Menu {
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

	@Override
	public void show() {
		System.out.println("IDを入力してください。");
		System.out.println("Visitor ID: ");
		String inputId = scanner.nextLine();
		while (!validator.isNumber(inputId)) {
			System.out.println(HttpStatus.BAD_REQUEST.getStatusLine());
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

		// 削除する人の本人確認
		System.out.print("Visitor Name: ");
		String visitorNameInput = scanner.nextLine();

		while (validator.isEmpty(visitorNameInput)) {
			System.out.println(HttpStatus.BAD_REQUEST.getStatusLine());
			System.out.println("名前を入力してください。");
			System.out.print("Visitor Name: ");
			visitorNameInput = scanner.nextLine();
		}

		if (!log.getVisitorName().equals(visitorNameInput)) {
			System.out.println(HttpStatus.FORBIDDEN.getStatusLine());
			System.out.println("登録した本人のみ削除できます。");
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
			System.out.println(HttpStatus.BAD_REQUEST.getStatusLine());
			System.out.print("1か2を入力してください。: ");
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
