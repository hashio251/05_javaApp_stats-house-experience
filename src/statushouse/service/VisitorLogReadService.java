package statushouse.service;

import java.util.List;

import statushouse.model.VisitorLog;
import statushouse.repository.VisitorLogRepository;

public class VisitorLogReadService {
	private VisitorLogRepository repository;

	public VisitorLogReadService(VisitorLogRepository repository) {
		this.repository = repository;
	}

	public List<VisitorLog> findAll() {
		return repository.findAll();
	}

	public VisitorLog findById(int id) {
		return repository.findById(id);
	}
}
