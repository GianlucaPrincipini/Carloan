package business.applicationservice;

import java.util.List;

import integration.dao.DAO;
import integration.dao.DAOFactory;
import business.checker.Checker;
import business.checker.CheckerFactory;
import business.entity.Agenzia;
import business.exception.CarloanException;
import business.exception.IntegrityException;
import business.exception.UnmodifiableEntityException;

public class ApplicationServiceAgenzia extends ApplicationServiceEntity<Agenzia> {

	@SuppressWarnings("unchecked")
	public ApplicationServiceAgenzia() throws InstantiationException, IllegalAccessException {
		super(DAOFactory.buildDao(Agenzia.class), CheckerFactory.buildChecker(Agenzia.class));
	}

	@Override
	public void create(Agenzia entity) throws IntegrityException{
		try {
			checker.check(entity);
			dao.create(entity);
		} catch (IntegrityException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Agenzia entity) throws IntegrityException{
		checker.isModifiable(dao.read(Integer.toString(entity.getId())));
		checker.check(entity);
		dao.update(entity);
		
	}

	@Override
	public void delete(Agenzia entity) throws IntegrityException{
		checker.isModifiable(dao.read(Integer.toString(entity.getId())));
		if (entity.getId() != 1) 
			dao.delete(Integer.toString(entity.getId()));
		else {
			throw new IntegrityException("Impossibile eliminare");
		}

	}

	@Override
	public List<Agenzia> readAll() {
		return dao.readAll();
	}

	@Override
	public Agenzia read(String pk){
		return dao.read(pk);
	}

}
