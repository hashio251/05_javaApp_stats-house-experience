package statushouse.ui;

import statushouse.model.VisitorLog;
import statushouse.service.VisitorLogReadService;

public class ListMenu {
	private VisitorLogReadService readService;

	public ListMenu(VisitorLogReadService readService) {
		this.readService = readService;
	}

	public void show() {
		List<VisitorLog> logs = readService.findAll();
		
		if (logs.())
}

}
