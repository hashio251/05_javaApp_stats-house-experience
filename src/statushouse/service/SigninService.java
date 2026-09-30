package statushouse.service;

import statushouse.repository.VisitorLogRepository;

public class SigninService extends VisitorLogService {

	/**
	 * @param repository
	 */
	public SigninService(VisitorLogRepository repository) {
		super(repository);
	}

}
