package statushouse.ui;

import java.util.Scanner;

import statushouse.model.VisitorLog;
import statushouse.service.VisitorLogCreateService;
import statushouse.validation.InputValidator;

public class CreateMenu {
	private Scanner scanner;
	private VisitorLogCreateService createService;
	private InputValidator inputValidator;

	/**
	 * @param scanner
	 * @param createService
	 */
	public CreateMenu(Scanner scanner, VisitorLogCreateService createService, InputValidator inputValidator) {
		this.scanner = scanner;
		this.createService = createService;
		this.inputValidator = inputValidator;
	}

	public void show() {
		System.out.print("Visitor Name: ");
		String visitorName = scanner.nextLine();

		while (inputValidator.isEmpty(visitorName)) {
			System.out.println("名前を入力してください。");
			System.out.print("Visitor Name: ");
			visitorName = scanner.nextLine();
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

		VisitorLog log = createService.create(visitorName, roomCode, message);

		System.out.println("201 Created");
		System.out.println("ID: " + log.getId());
		System.out.println("Visitor Name: " + log.getVisitorName());
		System.out.println("Room Code: " + log.getRoomCode());
		System.out.println("Message: " + log.getMessage());
		System.out.println("Visited At: " + log.getVisitedAt());
	}

}
