package statushouse.service;

import statushouse.repository.VisitorLogRepository;

// 親クラスの定義
public abstract class VisitorLogService {
	protected final VisitorLogRepository repository;

	protected VisitorLogService(VisitorLogRepository repository) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.repository = repository;
	}

}
