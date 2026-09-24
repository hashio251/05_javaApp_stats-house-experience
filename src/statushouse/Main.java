package statushouse;

import java.util.Scanner;

import statushouse.repository.VisitorLogRepository;
import statushouse.service.VisitorLogCreateService;
import statushouse.service.VisitorLogDeleteService;
import statushouse.service.VisitorLogReadService;
import statushouse.service.VisitorLogUpdateService;
import statushouse.ui.CreateMenu;
import statushouse.ui.DeleteMenu;
import statushouse.ui.DetailMenu;
import statushouse.ui.ListMenu;
import statushouse.ui.MainMenu;
import statushouse.ui.Menu;
import statushouse.ui.UpdateMenu;
import statushouse.ui.VisitorLogCommonUI;
import statushouse.ui.serch.SearchByRoomCodeMenu;
import statushouse.ui.serch.SearchByVisitorNameMenu;
import statushouse.ui.serch.SearchMenu;
import statushouse.validation.InputValidator;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner scanner = new Scanner(System.in);

		VisitorLogRepository repository = new VisitorLogRepository();

		InputValidator validator = new InputValidator();

		// service package
		VisitorLogCreateService createService = new VisitorLogCreateService(repository);

		VisitorLogReadService readService = new VisitorLogReadService(repository);

		VisitorLogUpdateService updateService = new VisitorLogUpdateService(repository);

		VisitorLogDeleteService deleteService = new VisitorLogDeleteService(repository);

		// common ui
		VisitorLogCommonUI commonUI = new VisitorLogCommonUI();

		// ui package
		CreateMenu createMenu = new CreateMenu(scanner, createService, validator, commonUI);

		ListMenu listMenu = new ListMenu(readService, commonUI);

		DeleteMenu deleteMenu = new DeleteMenu(scanner, readService, deleteService, validator, commonUI);

		DetailMenu detailMenu = new DetailMenu(scanner, readService, validator, commonUI);

		UpdateMenu updateMenu = new UpdateMenu(scanner, readService, updateService, validator, commonUI);

		// Searchで作ったクラスをまとめて呼び出す
		SearchByVisitorNameMenu searchByVisitorNameMenu = new SearchByVisitorNameMenu(scanner, readService, commonUI);

		SearchByRoomCodeMenu searchByRoomCodeMenu = new SearchByRoomCodeMenu(scanner, readService, validator, commonUI);

		SearchMenu searchMenu = new SearchMenu(
				scanner,
				validator,
				searchByVisitorNameMenu,
				searchByRoomCodeMenu);

		MainMenu mainMenu = new MainMenu(scanner, validator);

		// インターフェースの実装に合わせ、各MenuをMenu型にして呼び出す
		Menu[] menus = {
				null,
				createMenu,
				listMenu,
				detailMenu,
				updateMenu,
				deleteMenu,
				searchMenu
		};

		while (true) {

			String menu = mainMenu.showMenu();

			if (menu.equals("0")) {
				break;
			}

			int menuNumber = Integer.parseInt(menu);
			// 呼び出す
			menus[menuNumber].show();
		}
		scanner.close();
	}
}
