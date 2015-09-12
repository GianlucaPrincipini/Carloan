package presentation;

import java.lang.reflect.InvocationTargetException;

import presentation.frontcontroller.command.Command;
import presentation.gui.CarloanStage;

public class TargetFactory {
	
	public static Target buildTarget(String request) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		return buildTarget(request,null);
	}
	
	@SuppressWarnings("rawtypes")
	public static Target buildTarget(String request, Object entity) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		if (request.matches("MostraModifica[a-zA-Z]+")) {			
			String[] splitted = request.split("MostraModifica");
			return (CarloanStage) Class.forName("presentation.gui.Carloan"+splitted[1]).getDeclaredConstructor(Object.class).newInstance(entity);
		} else if (request.equals("MostraSelezione")) {
			return (CarloanStage) new presentation.gui.CarloanSelezione(entity);
		} else if (request.matches("Mostra[a-zA-Z]+")) {
			String[] splitted = request.split("Mostra");
			return (CarloanStage) Class.forName("presentation.gui.Carloan"+splitted[1]).newInstance();
		} else {
			return (Command) Class.forName("presentation.frontcontroller.command.Command"+request).newInstance();
		}
	}
	
}
