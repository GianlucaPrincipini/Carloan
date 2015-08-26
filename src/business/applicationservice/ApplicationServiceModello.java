package business.applicationservice;

import integration.dao.DAO;
import integration.dao.DAOFactory;
import integration.dao.DAOFascia;

import java.util.List;

import business.checker.Checker;
import business.checker.CheckerFactory;
import business.entity.Fascia;
import business.entity.Modello;

public class ApplicationServiceModello extends ApplicationServiceEntity<Modello> {

	@SuppressWarnings("unchecked")
	protected ApplicationServiceModello() throws InstantiationException, IllegalAccessException {
		super(DAOFactory.buildDao(Modello.class), CheckerFactory.buildChecker(Modello.class));
	}

	public Fascia calcolaFascia(Modello modello) {
		List<Fascia> fasce = new DAOFascia().readAll();
		double indiceFascia = calcolaIndiceFascia(modello);
		for (Fascia f:fasce) {
			if (indiceFascia < f.getMax() && indiceFascia > f.getMin()) {
				modello.setFascia(f);
				return f;
			}
		}
		return null;
	}
	
	private double calcolaIndiceFascia(Modello modello) {
		return 0;
	}

	@Override
	public void create(Modello entity) {
		if (checker.check(entity)) {
			dao.create(entity);
		}
	}

	@Override
	public void update(Modello entity) {
		if (checker.isModifiable(read(Integer.toString(entity.getId())))) {
			if (checker.check(entity)) {
				dao.update(entity);
			}
		}
	}

	@Override
	public void delete(Modello entity) {
		if (checker.isModifiable(read(Integer.toString(entity.getId())))) {
			if (checker.check(entity)) {
				dao.delete(Integer.toString(entity.getId()));
			}
		}
	}

	@Override
	public List<Modello> readAll() {
		return dao.readAll();
	}

	@Override
	public Modello read(String pk) {
		return dao.read(pk);
	}
}
