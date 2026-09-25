package statushouse.ui.search;

import java.util.List;
import java.util.Scanner;

import statushouse.constant.HttpStatus;
import statushouse.model.VisitorLog;
import statushouse.service.VisitorLogReadService;
import statushouse.ui.Menu;
import statushouse.ui.VisitorLogCommonUI;
import statushouse.validation.InputValidator;

public class SearchByRoomCodeMenu implements Menu {
	private final Scanner scanner;
	private final VisitorLogReadService readService;
	private final InputValidator inputValidator;
	private final VisitorLogCommonUI commonUI;

	/**
	 * @param scanner
	 * @param readService
	 * @param commonUI
	 */
	public SearchByRoomCodeMenu(Scanner scanner, VisitorLogReadService readService, InputValidator inputValidator,
			VisitorLogCommonUI commonUI) {
		this.scanner = scanner;
		this.readService = readService;
		this.inputValidator = inputValidator;
		this.commonUI = commonUI;
	}

	@Override
	public void show() {

		System.out.print("Visitor Room Code: ");
		String roomCodeInput = scanner.nextLine();

		while (!inputValidator.isNumber(roomCodeInput)) {
			System.out.println(HttpStatus.BAD_REQUEST.getStatusLine());
			System.out.println("数字を入力してください。");
			System.out.print("Room Code: ");
			roomCodeInput = scanner.nextLine();
		}

		int roomCode = Integer.parseInt(roomCodeInput);

		List<VisitorLog> logs = readService.findByRoomCode(roomCode);

		if (logs.isEmpty()) {
			System.out.println(HttpStatus.NOT_FOUND.getStatusLine());
			return;
		}

		System.out.println(HttpStatus.OK.getStatusLine());

		for (VisitorLog log : logs) {
			commonUI.visitorLogCommonShow(log);
		}
	}
}
