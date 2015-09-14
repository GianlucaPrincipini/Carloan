package presentation.frontcontroller;

import java.lang.reflect.InvocationTargetException;

import business.exception.CarloanException;
import presentation.Target;
import presentation.TargetFactory;

public class CarloanApplicationController implements ApplicationController{


	@Override
	public Target handleRequest(String request, Object entity) {
		try {
			Target res = TargetFactory.buildTarget(request, entity);
			return res; 
		} catch (CarloanException e) {
			e.showError();
		}
		return null; 
	}
}
