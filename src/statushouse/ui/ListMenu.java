package statushouse.ui;

import java.util.List;

import statushouse.constant.HttpStatus;
import statushouse.model.VisitorLog;
import statushouse.service.VisitorLogReadService;

public class ListMenu {
	private final VisitorLogReadService readService;

	public ListMenu(VisitorLogReadService readService) {
		this.readService = readService;
	}

	public void show() {
		List<VisitorLog> logs = readService.findAll();

		if (logs.isEmpty()) {
			System.out.println("訪問者ログがありません。");
			return;
		}

		for (VisitorLog log : logs) {
			System.out.println(HttpStatus.OK.getStatusLine());
			System.out.println("ID: " + log.getId());
			System.out.println("Visitor Name: " + log.getVisitorName());
			System.out.println("Room Code: " + log.getRoomCode());
			System.out.println("Visited At: " + log.getVisitedAt());
			System.out.println("Message: " + log.getMessage());
			System.out.println();
		}
	}
}
