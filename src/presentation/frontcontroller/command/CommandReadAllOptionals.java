package presentation.frontcontroller.command;

import java.util.List;

import business.applicationservice.ApplicationServiceOptional;
import business.entity.Optional;

public class CommandReadAllOptionals implements Command<List<Optional>>{

	@Override
	public List<Optional> execute(List<Optional> entity) {
		try {
			return new ApplicationServiceOptional().readAll();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
