package presentation.gui;

import business.entity.IncidenzaFascia;

public class CarloanIncidenza extends CarloanStage{

	public CarloanIncidenza(){
		super("SchermataIncidenza.fxml", IncidenzaFascia.getInstance());
		setTitle("Modifica Incidenze di fascia");
	}
}
