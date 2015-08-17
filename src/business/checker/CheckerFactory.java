package business.checker;

import integration.dao.DAO;

public class CheckerFactory {
	public static Checker buildChecker(Class entityClass) throws InstantiationException, IllegalAccessException {
		String name = "business.checker."+entityClass.getSimpleName()+"Checker";
		Class<?> checker = null;
		try {
			checker = Class.forName(name);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return (Checker) checker.newInstance();
	}
}
