package statushouse.repository;

import java.util.ArrayList;
import java.util.List;

import statushouse.model.VisitorLog;

public class VisitorLogRepository {
	private List<VisitorLog> visitorLogs = new ArrayList<>();

	// save
	public void save(VisitorLog log) {
		visitorLogs.add(log);
	}

	// findAll
	public List<VisitorLog> findAll() {
		return visitorLogs;
	}

	// findById
	public VisitorLog findById(int id) {
		for (int i = 0; i < visitorLogs.size(); i++) {
			VisitorLog log = visitorLogs.get(i);
			if (log.getId() == id) {
				return log;
			}
		}
		return null;
	}

	// delete
	public void delete(int id) {
		VisitorLog log = findById(id);
		if (log != null) {
			visitorLogs.remove(log);
		}
	}
}
