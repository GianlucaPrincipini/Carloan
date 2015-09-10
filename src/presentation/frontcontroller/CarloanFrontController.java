package presentation.frontcontroller;

import presentation.Target;
import presentation.frontcontroller.command.Command;
import presentation.gui.CarloanStage;
import business.entity.Amministratore;
import business.entity.Operatore;

public class CarloanFrontController implements FrontController{

	private static Operatore userAuthenticated;
	private static CarloanFrontController frontController;
	

	private CarloanFrontController(){};
	
	public boolean isAdmin() {
		return userAuthenticated instanceof Amministratore;
	}
	
	public Operatore getUserAuthenticated() {
		return userAuthenticated;
	}
	
	public void setUserAuthenticated(Operatore userAuthenticated) {
		CarloanFrontController.userAuthenticated = userAuthenticated;
	}
	
	public Object processRequest(String request) {
		return processRequest(request, null);
	}
	
	
	public static CarloanFrontController getInstance() {
		if (frontController == null) {
			frontController = new CarloanFrontController();
		}
		return frontController;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Object processRequest(String request, Object entity) {
		ApplicationController ac =  new CarloanApplicationController();
		Target targetRequest = ac.handleRequest(request, entity);
		if (targetRequest instanceof Command) {
			return ((Command) targetRequest).execute(entity);
		} else if (targetRequest instanceof CarloanStage){
			return ((CarloanStage)targetRequest).showStage();
		}
		return null;
	}
}
