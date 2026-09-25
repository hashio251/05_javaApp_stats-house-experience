package statushouse.ui;

import java.util.Scanner;

import statushouse.constant.HttpStatus;
import statushouse.model.VisitorLog;
import statushouse.service.VisitorLogReadService;
import statushouse.service.VisitorLogUpdateService;
import statushouse.validation.InputValidator;

public class UpdateMenu implements Menu {
	private final Scanner scanner;
	private final VisitorLogReadService readService;
	private final VisitorLogUpdateService updateService;
	private final InputValidator validator;
	private final VisitorLogCommonUI commonUI;

	/**
	 * @param scanner
	 * @param readService
	 * @param updateService
	 * @param inputValidator
	 */
	public UpdateMenu(Scanner scanner, VisitorLogReadService readService, VisitorLogUpdateService updateService,
			InputValidator validator, VisitorLogCommonUI commonUI) {
		this.scanner = scanner;
		this.readService = readService;
		this.updateService = updateService;
		this.validator = validator;
		this.commonUI = commonUI;
	}

	@Override
	public void show() {
		System.out.println("Edit ID: ");
		String idInput = scanner.nextLine();

		while (!validator.isNumber(idInput)) {
			System.out.println(HttpStatus.BAD_REQUEST.getStatusLine());
			System.out.println("数字を入力してください。");
			System.out.print("Edit ID: ");
			idInput = scanner.nextLine();
		}

		int id = Integer.parseInt(idInput);

		VisitorLog log = readService.findById(id);

		if (log == null) {
			System.out.println(HttpStatus.NOT_FOUND.getStatusLine());
			return;
		}

		// 編集する人の本人確認
		System.out.print("Password: ");
		String visitorPassInput = scanner.nextLine();
		while (!validator.isNumber(visitorPassInput) || visitorPassInput.length() != 4) {
			System.out.println(HttpStatus.BAD_REQUEST.getStatusLine());
			System.out.println("４桁の数字を入力してください。");
			System.out.print("Password: ");
			visitorPassInput = scanner.nextLine();
		}

		if (!log.getPassword().equals(visitorPassInput)) {
			System.out.println(HttpStatus.UNAUTHORIZED.getStatusLine());
			System.out.println(HttpStatus.FORBIDDEN.getStatusLine());
			System.out.println("Passwordが違います。");
			return;
		}

		System.out.println(HttpStatus.OK.getStatusLine());
		commonUI.visitorLogCommonShow(log);

		// 編集する人の本人確認をパスしたら
		// Create new name
		// Create new name
		System.out.print("Visitor Name: ");
		String visitorNameInput = scanner.nextLine();

		while (validator.isEmpty(visitorNameInput)) {
			System.out.println(HttpStatus.BAD_REQUEST.getStatusLine());
			System.out.println("名前を入力してください。");
			System.out.print("Visitor Name: ");
			visitorNameInput = scanner.nextLine();
		}

		// Create new room code
		// Create new room code
		System.out.print("New Room Code: ");
		String roomCodeInput = scanner.nextLine();

		while (!validator.isNumber(roomCodeInput)) {
			System.out.println(HttpStatus.BAD_REQUEST.getStatusLine());
			System.out.println("数字を入力してください。");
			System.out.print("New Room Code: ");
			roomCodeInput = scanner.nextLine();
		}

		int roomCode = Integer.parseInt(roomCodeInput);

		// create new message
		// create new message
		System.out.println("メッセージを入力してください。");
		String messageInput = scanner.nextLine();

		while (validator.isEmpty(messageInput)) {
			System.out.println(HttpStatus.BAD_REQUEST.getStatusLine());
			System.out.println("メッセージを入力してください。");
			messageInput = scanner.nextLine();
		}

		// 呼び出し
		VisitorLog updatedLog = updateService.update(id, visitorNameInput, roomCode, messageInput);

		System.out.println(HttpStatus.OK.getStatusLine());
		commonUI.visitorLogCommonShow(updatedLog);
	}
}
