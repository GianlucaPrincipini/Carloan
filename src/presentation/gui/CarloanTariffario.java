package presentation.gui;

import business.entity.Tariffario;

public class CarloanTariffario extends CarloanStage{
	
	public CarloanTariffario(Tariffario entity){
		super("SchermataTariffario.fxml", entity);
		setTitle("Modifica Tariffario");
	}
}
