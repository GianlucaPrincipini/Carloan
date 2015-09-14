package presentation;

import java.lang.reflect.InvocationTargetException;

import business.exception.CarloanException;
import presentation.frontcontroller.command.Command;
import presentation.gui.CarloanStage;

public class TargetFactory {
	
	public static Target buildTarget(String request) throws CarloanException {
		return buildTarget(request,null);
	}
	
	@SuppressWarnings("rawtypes")
	public static Target buildTarget(String request, Object entity) throws CarloanException {
		try {
			if (request.matches("MostraModifica[a-zA-Z]+")) {			
				String[] splitted = request.split("MostraModifica");
				return (CarloanStage) Class.forName("presentation.gui.Carloan"+splitted[1]).getDeclaredConstructor(Object.class).newInstance(entity);
			} else if (request.equals("MostraSelezione")) {
				return (CarloanStage) new presentation.gui.CarloanSelezione(entity);
			} else if (request.equals("MostraChiusura")) {
				return (CarloanStage) new presentation.gui.CarloanChiusuraContratto(entity);
			} else if (request.matches("Mostra[a-zA-Z]+")) {
				String[] splitted = request.split("Mostra");
				return (CarloanStage) Class.forName("presentation.gui.Carloan"+splitted[1]).newInstance();
			} else {
				return (Command) Class.forName("presentation.frontcontroller.command.Command"+request).newInstance();
			}
		} catch (Exception e) {
			throw new CarloanException(e.getMessage());
		}
	}
	
}
