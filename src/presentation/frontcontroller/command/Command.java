package presentation.frontcontroller.command;

import presentation.Target;

public interface Command <T> extends Target{
	public T execute (T entity);
}
