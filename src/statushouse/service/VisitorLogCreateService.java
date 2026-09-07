package statushouse.service;

import java.time.LocalDateTime;

import statushouse.model.VisitorLog;
import statushouse.repository.VisitorLogRepository;

public class VisitorLogCreateService {

	private VisitorLogRepository repository;

	/**
	 * @param repository
	 */
	public VisitorLogCreateService(VisitorLogRepository repository) {
		this.repository = repository;
	}

	// 名前・部屋番号・メッセージをもらったら登録処理
	public VisitorLog create(String visitorName, int roomCode, String message) {
		int id = repository.createNextId();
		String visitedAtString = LocalDateTime.now().toString();

		VisitorLog log = new VisitorLog(id, visitorName, roomCode, message, visitedAtString);

		repository.save(log);

		return log;
	}

}
