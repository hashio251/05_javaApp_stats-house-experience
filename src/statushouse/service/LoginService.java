package statushouse.service;

import statushouse.repository.VisitorLogRepository;

public class LoginService extends VisitorLogService {
	public LoginService(VisitorLogRepository repository) {
		super(repository);
	}

}
