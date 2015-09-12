package presentation.frontcontroller;

import java.lang.reflect.InvocationTargetException;

import presentation.Target;
import presentation.TargetFactory;

public class CarloanApplicationController implements ApplicationController{


	@Override
	public Target handleRequest(String request, Object entity) {
		try {
			Target res = TargetFactory.buildTarget(request, entity);
			return res; 
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			return null;
		}
	}
}
