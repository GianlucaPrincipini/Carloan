package business.applicationservice;

import integration.dao.DAOFactory;

import java.util.List;

import business.checker.CheckerFactory;
import business.entity.Optional;
import business.exception.IntegrityException;

public class ApplicationServiceOptional extends ApplicationServiceEntity<Optional> implements Gestione<Optional>{

	@SuppressWarnings("unchecked")
	public ApplicationServiceOptional() throws InstantiationException, IllegalAccessException {
		super(DAOFactory.buildDao(Optional.class), CheckerFactory.buildChecker(Optional.class));
	}
	
	@Override
	public void create(Optional entity) {
		try {
			checker.check(entity);
		} catch (IntegrityException e) {
			e.printStackTrace();
		}
		dao.create(entity);
	}

	@Override
	public void update(Optional entity) {
		try {
			checker.isModifiable(dao.read(Integer.toString(entity.getId())));
			checker.check(entity);
		} catch (IntegrityException e) {
			e.printStackTrace();
		}
		dao.update(entity);	
	}

	@Override
	public void delete(Optional entity) {
		try {
			checker.isModifiable(dao.read(Integer.toString(entity.getId())));
		} catch (IntegrityException e) {
			e.printStackTrace();
		}
		dao.delete(Integer.toString(entity.getId()));
		
	}

	@Override
	public List<Optional> readAll() {
		return dao.readAll();
	}

	@Override
	public Optional read(String pk) {
		return dao.read(pk);
	}

}
