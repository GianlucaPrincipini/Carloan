package business.applicationservice;

import java.util.List;

import business.checker.Checker;
import business.checker.CheckerFactory;
import business.entity.Cliente;
import business.exception.CarloanException;
import business.exception.IntegrityException;
import business.exception.UnmodifiableEntityException;
import integration.dao.DAO;
import integration.dao.DAOFactory;

public class ApplicationServiceCliente extends ApplicationServiceEntity<Cliente> {
	@SuppressWarnings("unchecked")
	public ApplicationServiceCliente() throws InstantiationException, IllegalAccessException {
		super((DAO<Cliente>) DAOFactory.buildDao(Cliente.class), (Checker<Cliente>) CheckerFactory.buildChecker(Cliente.class));
	}


	@Override
	public void create(Cliente entity) throws IntegrityException {
		checker.check(entity);
		dao.create(entity);
	}

	@Override
	public void update(Cliente entity) throws IntegrityException {
		checker.isModifiable(dao.read(entity.getCodicePatente()));
		checker.check(entity);
		dao.update(entity);
	}

	@Override
	public void delete(Cliente entity) throws IntegrityException {
		checker.isModifiable(entity);
		dao.delete(entity.getCodicePatente());
	}

	@Override
	public Cliente read(String pk) {
		return dao.read(pk);
	}

	@Override
	public List<Cliente> readAll() {
		return dao.readAll();
	}

}
