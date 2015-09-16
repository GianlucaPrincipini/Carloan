package presentation.frontcontroller;


public interface ApplicationController {
	public Target handleRequest(String request, Object entity);
}
