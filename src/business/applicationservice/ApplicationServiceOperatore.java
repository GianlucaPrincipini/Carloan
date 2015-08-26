package business.applicationservice;

import java.util.List;

import integration.dao.DAOFactory;
import business.checker.CheckerFactory;
import business.entity.Operatore;

public class ApplicationServiceOperatore extends ApplicationServiceEntity<Operatore> implements Gestione<Operatore>{

	@SuppressWarnings("unchecked")
	protected ApplicationServiceOperatore() throws InstantiationException, IllegalAccessException {
		super(DAOFactory.buildDao(Operatore.class), CheckerFactory.buildChecker(Operatore.class));
	}

	@Override
	public void create(Operatore entity) {
		if (checker.check(entity)) {
			dao.create(entity);
		}
	}

	@Override
	public void update(Operatore entity) {
		if (checker.isModifiable(read(entity.getUsername()))) {
			dao.update(entity);
		}
	}

	@Override
	public void delete(Operatore entity) {
		if (checker.isModifiable(read(entity.getUsername()))) {
			dao.delete(entity.getUsername());
		}
	}

	@Override
	public List<Operatore> readAll() {
		return dao.readAll();
	}

	@Override
	public Operatore read(String pk) {
		return dao.read(pk);
	}

}
