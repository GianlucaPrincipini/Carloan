package presentation.gui;

public class CarloanTariffario extends CarloanStage{
	
<<<<<<< HEAD
	/**
	 * Richiama la schermata del tariffario caricando le informazioni da file
	 * @param entity Dati del tariffario caricati dal file
	 */
=======
	public CarloanTariffario() {
		super("SchermataTariffario", Tariffario.getInstance());
	}
	
>>>>>>> origin/master
	public CarloanTariffario(Object entity){
		super("SchermataTariffario.fxml", entity);
		setTitle("Modifica Tariffario");
	}
}
