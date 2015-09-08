package presentation.frontcontroller;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import presentation.Target;
import presentation.TargetFactory;
import presentation.frontcontroller.command.*;
import presentation.gui.*;

public class CarloanApplicationController implements ApplicationController{


	@Override
	public Target handleRequest(String request, Object entity) {
		try {
			return TargetFactory.buildTarget(request, entity);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			return null;
		}
	}
}
