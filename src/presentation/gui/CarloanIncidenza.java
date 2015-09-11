package presentation.gui;

import business.entity.IncidenzaFascia;

public class CarloanIncidenza extends CarloanStage{

	public CarloanIncidenza(IncidenzaFascia entity){
		super("SchermataIncidenza.fxml", entity);
		setTitle("Modifica Incidenze di fascia");
	}
}
