package presentation.gui;

import business.entity.Tariffario;

public class CarloanTariffario extends CarloanStage{
	
	public CarloanTariffario(){
		super("SchermataTariffario.fxml", Tariffario.getInstance());
		setTitle("Immissione Tariffario");
	}
}
