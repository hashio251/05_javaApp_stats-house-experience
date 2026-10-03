package statushouse.service.auth;

import statushouse.repository.VisitorLogRepository;
import statushouse.service.VisitorLogService;

public class SignupService extends VisitorLogService {

	/**
	 * @param repository
	 */
	public SignupService(VisitorLogRepository repository) {
		super(repository);
	}

}
