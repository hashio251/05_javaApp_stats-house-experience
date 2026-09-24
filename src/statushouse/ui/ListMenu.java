package statushouse.ui;

import java.util.List;

import statushouse.constant.HttpStatus;
import statushouse.model.VisitorLog;
import statushouse.service.VisitorLogReadService;

public class ListMenu implements Menu {
	private final VisitorLogReadService readService;
	private final VisitorLogCommonUI commonUI;

	public ListMenu(VisitorLogReadService readService, VisitorLogCommonUI commonUI) {
		this.readService = readService;
		this.commonUI = commonUI;
	}

	@Override
	public void show() {
		List<VisitorLog> logs = readService.findAll();

		if (logs.isEmpty()) {
			System.out.println("訪問者ログがありません。");
			return;
		}

		for (VisitorLog log : logs) {
			System.out.println(HttpStatus.OK.getStatusLine());
			commonUI.visitorLogCommonShow(log);
		}
	}
}
