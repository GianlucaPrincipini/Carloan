package presentation.gui;

import business.entity.Tariffario;

public class CarloanTariffario extends CarloanStage{
	
	public CarloanTariffario(Object entity){
		super("SchermataTariffario.fxml", entity);
		setTitle("Modifica Tariffario");
	}
}
