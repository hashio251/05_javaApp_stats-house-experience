package statushouse.ui.serch;

import java.util.List;
import java.util.Scanner;

import statushouse.constant.HttpStatus;
import statushouse.model.VisitorLog;
import statushouse.service.VisitorLogReadService;
import statushouse.ui.Menu;
import statushouse.ui.VisitorLogCommonUI;

public class SearchByVisitorNameMenu implements Menu {
	private final Scanner scanner;
	private final VisitorLogReadService readService;
	private final VisitorLogCommonUI commonUI;

	/**
	 * @param scanner
	 * @param readService
	 * @param commonUI
	 */
	public SearchByVisitorNameMenu(Scanner scanner, VisitorLogReadService readService, VisitorLogCommonUI commonUI) {
		this.scanner = scanner;
		this.readService = readService;
		this.commonUI = commonUI;
	}

	@Override
	public void show() {

		System.out.print("Visitor Name: ");
		String visitorName = scanner.nextLine();

		List<VisitorLog> logs = readService.findByVisitorName(visitorName);

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
