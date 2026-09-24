package statushouse.service;

import java.util.List;

import statushouse.model.VisitorLog;
import statushouse.repository.VisitorLogRepository;

public class VisitorLogReadService extends VisitorLogService {
	public VisitorLogReadService(VisitorLogRepository repository) {
		super(repository);
	}

	// 一括表示
	public List<VisitorLog> findAll() {
		return repository.findAll();
	}

	// １つずつ
	public VisitorLog findById(int id) {
		return repository.findById(id);
	}
}
