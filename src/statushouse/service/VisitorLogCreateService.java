package statushouse.service;

import java.time.LocalDateTime;

import statushouse.model.VisitorLog;
import statushouse.repository.VisitorLogRepository;

public class VisitorLogCreateService extends VisitorLogService {
	/**
	 * @param repository
	 */
	public VisitorLogCreateService(VisitorLogRepository repository) {
		super(repository);
	}

	// 名前・pass・部屋番号・メッセージをもらったら登録処理
	public VisitorLog create(String visitorName, String password, int roomCode, String message) {
		int id = repository.createNextId();
		String visitedAtString = LocalDateTime.now().toString();

		VisitorLog log = new VisitorLog(id, visitorName, password, roomCode, message, visitedAtString);

		repository.save(log);

		return log;
	}

}
