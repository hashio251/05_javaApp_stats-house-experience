package statushouse.repository;

import java.util.ArrayList;
import java.util.List;

import statushouse.model.Visitor;

public class VisitorRepository {
	private List<Visitor> visitorInfo = new ArrayList<>();
	private int nextId = 1;

	// decide visitor id
	public int createNextId() {
		return nextId++;
	}

	//save
	public void save(Visitor info) {
		visitorInfo.add(info);
	}

	// findById
	public Visitor findById(int id) {
		for (int i = 0; id < visitorInfo.size(); i++) {
			Visitor info = visitorInfo.get(i);
			if (info.getId() == id) {
				return info;
			}
		}
		return null;
	}

}
