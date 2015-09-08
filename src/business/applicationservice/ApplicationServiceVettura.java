package business.applicationservice;

import java.util.List;

import integration.dao.DAO;
import integration.dao.DAOFactory;
import business.checker.Checker;
import business.checker.CheckerFactory;
import business.entity.Vettura;
import business.exception.IntegrityException;

public class ApplicationServiceVettura extends ApplicationServiceEntity<Vettura> implements Gestione<Vettura>{

	@SuppressWarnings("unchecked")
	public ApplicationServiceVettura() throws InstantiationException, IllegalAccessException {
		super(DAOFactory.buildDao(Vettura.class), CheckerFactory.buildChecker(Vettura.class));
	}

	@Override
	public void create(Vettura entity) {
		try {
			checker.check(entity);
		} catch (IntegrityException e) {
			e.printStackTrace();
		}
		dao.create(entity);
	}

	@Override
	public void update(Vettura entity) {
		try {
			checker.isModifiable(read(entity.getTarga()));
			checker.check(entity);
		} catch (IntegrityException e) {
			e.printStackTrace();
		}
		dao.update(entity);
	}

	@Override
	public void delete(Vettura entity) {
		try {
			checker.isModifiable(read(entity.getTarga()));
			checker.check(entity);
		} catch (IntegrityException e) {
			e.printStackTrace();
		}
		dao.delete(entity.getTarga());
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
