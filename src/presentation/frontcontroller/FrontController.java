package presentation.frontcontroller;

public interface FrontController {
	public Object processRequest(String request);
	public Object processRequest(String request, Object entity);
}
