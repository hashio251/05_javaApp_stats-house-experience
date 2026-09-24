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
import statushouse.ui.SearchMenu;
import statushouse.ui.UpdateMenu;
import statushouse.validation.InputValidator;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner scanner = new Scanner(System.in);

		VisitorLogRepository repository = new VisitorLogRepository();

		InputValidator validator = new InputValidator();

		VisitorLogCreateService createService = new VisitorLogCreateService(repository);

		VisitorLogReadService readService = new VisitorLogReadService(repository);

		VisitorLogUpdateService updateService = new VisitorLogUpdateService(repository);

		VisitorLogDeleteService deleteService = new VisitorLogDeleteService(repository);

		CreateMenu createMenu = new CreateMenu(scanner, createService, validator);

		ListMenu listMenu = new ListMenu(readService);

		DeleteMenu deleteMenu = new DeleteMenu(scanner, readService, deleteService, validator);

		DetailMenu detailMenu = new DetailMenu(scanner, readService, validator);

		UpdateMenu updateMenu = new UpdateMenu(scanner, readService, updateService, validator);

		SearchMenu searchMenu = new SearchMenu(scanner, readService, validator);

		MainMenu mainMenu = new MainMenu(scanner, validator);

		String menu = "";

		while (!menu.equals("0")) {
			menu = mainMenu.showMenu();
			switch (menu) {
			case "1":
				createMenu.show();
				break;
			case "2":
				listMenu.show();
				break;
			case "3":
				detailMenu.show();
				break;
			case "4":
				updateMenu.show();
				break;
			case "5":
				deleteMenu.show();
				break;
			case "6":
				searchMenu.show();
				break;
			}
		}
		scanner.close();
	}
}
