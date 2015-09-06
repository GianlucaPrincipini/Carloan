package business.checker;
import business.exception.*;

public interface Checker<Data> {
	/**
	 * Controlla la validit� dei campi relativi all'entit�.
	 * @param entity entit� da controllare.
	 */
	public void check(Data entity) throws IntegrityException;
	
	/**
	 * Controlla se un'entit� � modificabile oppure no.
	 * @param entity entit� da controllare.
	 */
	public void isModifiable(Data entity) throws IntegrityException;
}
