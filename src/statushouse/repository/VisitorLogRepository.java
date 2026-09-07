package statushouse.repository;

import java.util.ArrayList;
import java.util.List;

import statushouse.model.VisitorLog;

public class VisitorLogRepository {
	private List<VisitorLog> visitorLogs = new ArrayList<>();

	public void save(VisitorLog log) {
		visitorLogs.add(log);
	}
}
