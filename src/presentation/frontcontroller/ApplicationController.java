package presentation.frontcontroller;

import presentation.Target;

public interface ApplicationController {
	public Target handleRequest(String request, Object entity);
}
