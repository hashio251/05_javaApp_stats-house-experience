package statushouse.service;

import statushouse.model.VisitorLog;
import statushouse.repository.VisitorLogRepository;

public class VisitorLogUpdateService extends VisitorLogService {

	/**
	 * @param repository
	 */
	public VisitorLogUpdateService(VisitorLogRepository repository) {
		super(repository);
	}

	public VisitorLog update(int id, int roomCode, String message) {
		VisitorLog log = repository.findById(id);
		if (log != null) {
			log.setRoomCode(roomCode);
			log.setMessage(message);
			log.setRoomCode(roomCode);
			log.setMessage(message);
			return log;
		}
		return null;
	}

}
