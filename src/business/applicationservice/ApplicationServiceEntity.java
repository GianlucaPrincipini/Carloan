package business.applicationservice;

import business.checker.Checker;
import integration.dao.DAO;

public abstract class ApplicationServiceEntity<Data> implements ApplicationService {
	protected DAO<Data> dao;
	protected Checker<Data> checker;
	
	protected ApplicationServiceEntity(DAO<Data> dao, Checker<Data> checker) {
		this.dao = dao;
		this.checker = checker;
	}
}
