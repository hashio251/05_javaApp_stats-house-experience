package statushouse.service;

import statushouse.repository.VisitorLogRepository;

public class VisitorLogCreateService {

	private VisitorLogRepository repository;

	/**
	 * @param repository
	 */
	public VisitorLogCreateService(VisitorLogRepository repository) {
		this.repository = repository;
	}

}
