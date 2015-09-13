package presentation.gui;

import presentation.gui.controller.SchermataSelezione;

public class CarloanChiusuraContratto {
	public CarloanChiusuraContratto(Object selezione) {
		super("SchermataSelezione.fxml", null);
		SchermataSelezione controller = fxmlLoader.<SchermataSelezione>getController();
		controller.loadTable((String)selezione);
	}
}
