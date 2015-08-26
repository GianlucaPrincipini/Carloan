package business.checker;

public interface Checker<Data> {
	/**
	 * Controlla la validit� dei campi relativi all'entit�.
	 * @param entity entit� da controllare.
	 * @return true se l'entit� � valida, false se non � valida.
	 */
	public boolean check(Data entity);
	
	/**
	 * Controlla se un'entit� � modificabile oppure no.
	 * @param entity entit� da controllare.
	 * @return true se l'entit� � modificabile, false se non � modificabile.
	 */
	public boolean isModifiable(Data entity);
}
