package integration.dao;


public class DAOFactory {
	public static DAO buildDao(Class<?> entityClass) throws InstantiationException, IllegalAccessException{
		String name = "integration.dao.DAO"+entityClass.getSimpleName();
		Class<?> dao = null;
		try {
			dao = Class.forName(name);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return (DAO) dao.newInstance();
	}
}
