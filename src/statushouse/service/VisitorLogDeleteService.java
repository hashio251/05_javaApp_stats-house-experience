package statushouse.service;

import statushouse.model.VisitorLog;
import statushouse.repository.VisitorLogRepository;

public class VisitorLogDeleteService extends VisitorLogService {

	/**
	 * @param repository
	 */
	public VisitorLogDeleteService(VisitorLogRepository repository) {
		super(repository);
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
