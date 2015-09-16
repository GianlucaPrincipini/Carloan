package presentation.frontcontroller.command;

import business.exception.CarloanException;
import presentation.frontcontroller.Target;

public interface Command <T> extends Target{
	public T execute (T entity) throws CarloanException;
}