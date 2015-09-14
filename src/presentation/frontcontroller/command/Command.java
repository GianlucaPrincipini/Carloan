package presentation.frontcontroller.command;

import business.exception.CarloanException;
import presentation.Target;

public interface Command <T> extends Target{
	public T execute (T entity) throws CarloanException;
}