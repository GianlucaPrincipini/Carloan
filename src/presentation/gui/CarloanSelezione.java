package presentation.gui;

import presentation.gui.controller.SchermataSelezione;

public class CarloanSelezione extends CarloanStage{

	private String value;
	
	public String getValue() {
		if (value != null) return value;
		return "";
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public CarloanSelezione(Object selezione) {
		super("SchermataSelezione.fxml", null);
		SchermataSelezione controller = fxmlLoader.<SchermataSelezione>getController();
		controller.loadTable((String)selezione);
	}

}
