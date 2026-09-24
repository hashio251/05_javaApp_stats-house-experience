package statushouse.repository;

import java.util.ArrayList;
import java.util.List;

import statushouse.model.VisitorLog;

public class VisitorLogRepository {
	private List<VisitorLog> visitorLogs = new ArrayList<>();
	private int nextId = 1;

	public int createNextId() {
		return nextId++;
	}

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

	// Search用(ViditorName)
	public List<VisitorLog> findByVisitorName(String visitorName) {

		List<VisitorLog> result = new ArrayList<>();

		for (VisitorLog log : visitorLogs) {

			if (log.getVisitorName().equals(visitorName)) {
				result.add(log);
			}
		}

		return result;
	}

	// Search用(VisitorRoomCode)
	public List<VisitorLog> findByRoomCode(int roomCode) {

		List<VisitorLog> result = new ArrayList<>();

		for (VisitorLog log : visitorLogs) {

			if (log.getRoomCode() == roomCode) {
				result.add(log);
			}
		}

		return result;
	}
}
