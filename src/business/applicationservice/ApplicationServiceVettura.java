package business.applicationservice;

import java.util.List;

import integration.dao.DAO;
import integration.dao.DAOFactory;
import business.checker.Checker;
import business.checker.CheckerFactory;
import business.entity.Vettura;

public class ApplicationServiceVettura extends ApplicationServiceEntity<Vettura> implements Gestione<Vettura>{

	@SuppressWarnings("unchecked")
	protected ApplicationServiceVettura() throws InstantiationException, IllegalAccessException {
		super(DAOFactory.buildDao(Vettura.class), CheckerFactory.buildChecker(Vettura.class));
	}

	@Override
	public void create(Vettura entity) {
		if (checker.check(entity)) {
			dao.create(entity);
		}
	}

	@Override
	public void update(Vettura entity) {
		if (checker.isModifiable(read(entity.getTarga()))) {
			if (checker.check(entity)) {
				dao.update(entity);
			}
		}
	}

	@Override
	public void delete(Vettura entity) {
		if (checker.isModifiable(read(entity.getTarga()))) {
			if (checker.check(entity)) {
				dao.delete(entity.getTarga());
			}
		}
	}

	@Override
	public List<Vettura> readAll() {
		return dao.readAll();
	}

	@Override
	public Vettura read(String pk) {
		return dao.read(pk);
	}

}
