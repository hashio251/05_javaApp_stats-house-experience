package statushouse.service;

import statushouse.model.VisitorLog;
import statushouse.repository.VisitorLogRepository;

public class VisitorLogDeleteService {
	private VisitorLogRepository repository;

	/**
	 * @param repository
	 */
	public VisitorLogDeleteService(VisitorLogRepository repository) {
		this.repository = repository;
	}

	public VisitorLog delete(int id) {
		VisitorLog log = repository.findById(id);

		if (log != null) {
			repository.delete(id);
			return log;
		}
		return null;
	}
}
