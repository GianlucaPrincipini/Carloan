package presentation.gui;

import business.entity.Tariffario;

public class CarloanTariffario extends CarloanStage{
	
	public CarloanTariffario() {
		super("SchermataTariffario", Tariffario.getInstance());
	}
	
	public CarloanTariffario(Object entity){
		super("SchermataTariffario.fxml", entity);
		setTitle("Modifica Tariffario");
	}
}
