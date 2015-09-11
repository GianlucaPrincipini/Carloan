package presentation.gui;

import business.entity.IncidenzaFascia;

public class CarloanIncidenzaFascia extends CarloanStage{

	public CarloanIncidenzaFascia(){
		super("SchermataIncidenza.fxml", null);
		setTitle("Modifica Incidenze di fascia");
	}
	
	public CarloanIncidenzaFascia(Object entity){
		super("SchermataIncidenza.fxml", entity);
		setTitle("Modifica Incidenze di fascia");
	}
}
