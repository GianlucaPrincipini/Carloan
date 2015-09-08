package presentation.frontcontroller.command;

import java.util.List;

import business.applicationservice.ApplicationServiceContratto;
import business.entity.Contratto;

public class CommandReadAllContratti implements Command<List<Contratto>>{

	@Override
	public List<Contratto> execute(List<Contratto> entity) {
		try {
			return new ApplicationServiceContratto().readAll();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
