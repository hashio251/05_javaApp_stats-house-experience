package statushouse.ui;

import java.util.Scanner;

import statushouse.constant.HttpStatus;
import statushouse.model.VisitorLog;
import statushouse.service.VisitorLogCreateService;
import statushouse.validation.InputValidator;

public class CreateMenu implements Menu {
	private final Scanner scanner;
	private final VisitorLogCreateService createService;
	private final InputValidator inputValidator;
	private final VisitorLogCommonUI commonUI;

	/**
	 * @param scanner
	 * @param createService
	 */
	public CreateMenu(Scanner scanner, VisitorLogCreateService createService, InputValidator inputValidator,
			VisitorLogCommonUI commonUI) {
		this.scanner = scanner;
		this.createService = createService;
		this.inputValidator = inputValidator;
		this.commonUI = commonUI;
	}

	@Override
	public void show() {

		System.out.print("Visitor Name: ");
		String nameInput = scanner.nextLine();

		while (inputValidator.isEmpty(nameInput)) {
			System.out.println("名前を入力してください。");
			System.out.print("Visitor Name: ");
			nameInput = scanner.nextLine();
		}

		// 追加で、別ファイルでRoomCodeを管理する
		System.out.println("Room Code: ");
		String roomCodeInput = scanner.nextLine();
		while (!inputValidator.isNumber(roomCodeInput)) {
			System.out.println("数字を入力してください。");
			System.out.print("Room Code: ");
			roomCodeInput = scanner.nextLine();
		}
		int roomCode = Integer.parseInt(roomCodeInput);
		System.out.println("Room Code: " + roomCodeInput);

		System.out.print("Message: ");
		String message = scanner.nextLine();
		while (inputValidator.isEmpty(message)) {
			System.out.println("メッセージを入力してください。");
			System.out.print("Message: ");
			message = scanner.nextLine();
		}

		VisitorLog log = createService.create(nameInput, roomCode, message);

		System.out.println(HttpStatus.CREATED.getStatusLine());
		commonUI.visitorLogCommonShow(log);
	}

}
