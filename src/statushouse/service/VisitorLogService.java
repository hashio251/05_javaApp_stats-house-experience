package statushouse.service;

import statushouse.repository.VisitorLogRepository;

// 親クラスの定義
// 直接インスタンスかできないabstractに（子サービスの親として使うため）
public abstract class VisitorLogService {
	// 同じパッケージや継承した子クラスから使えるようにprotected
	// 一度repositoryを代入したら別のRepositoryに入れ替えられないようにするためfinal
	protected final VisitorLogRepository repository;

	protected VisitorLogService(VisitorLogRepository repository) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.repository = repository;
	}

}
