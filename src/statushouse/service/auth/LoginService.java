package statushouse.service.auth;

import statushouse.repository.VisitorLogRepository;
import statushouse.service.VisitorLogService;

public class LoginService extends VisitorLogService {
	public LoginService(VisitorLogRepository repository) {
		super(repository);
	}

}
