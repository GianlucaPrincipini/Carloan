package presentation.gui;

public class CarloanChiusuraContratto extends CarloanStage {
	
	public CarloanChiusuraContratto() {
		super("",null);
	}
	
	public CarloanChiusuraContratto(Object contratto) {
		super("SchermataChiusura.fxml", contratto);
		setTitle("Chiudi Contratto");
	}
}
