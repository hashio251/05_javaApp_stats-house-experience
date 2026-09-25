package statushouse.ui;

import statushouse.model.VisitorLog;

// common ui of ui package
public class VisitorLogCommonUI {
	public void visitorLogCommonShow(VisitorLog log) {
		System.out.println();
		System.out.println("ID: " + log.getId());
		System.out.println("Visitor Name: " + log.getVisitorName());
		System.out.println("Room Code: " + log.getRoomCode());
		System.out.println("Message: " + log.getMessage());
		System.out.println("Visited At: " + log.getVisitedAt());
		System.out.println();

	}

}
