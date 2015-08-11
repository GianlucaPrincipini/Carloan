package business.applicationservice;

import integration.dao.DAO;

public abstract class ApplicationServiceEntity<Data> implements ApplicationService {
	protected DAO<Data> dao;
	protected ApplicationServiceEntity(DAO<Data> dao) {
		this.dao = dao;
	}
}
