package presentation.frontcontroller;

import java.lang.reflect.InvocationTargetException;
import presentation.Target;
import presentation.TargetFactory;

public class CarloanApplicationController implements ApplicationController{


	@Override
	public Target handleRequest(String request, Object entity) {
		try {
			System.out.println(entity);
			return TargetFactory.buildTarget(request, entity);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			return null;
		}
	}
}
