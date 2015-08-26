package business.checker;

public interface Checker<Data> {
	/**
	 * Controlla la validità dei campi relativi all'entità.
	 * @param entity entità da controllare.
	 * @return true se l'entità è valida, false se non è valida.
	 */
	public boolean check(Data entity);
	
	/**
	 * Controlla se un'entità è modificabile oppure no.
	 * @param entity entità da controllare.
	 * @return true se l'entità è modificabile, false se non è modificabile.
	 */
	public boolean isModifiable(Data entity);
}
