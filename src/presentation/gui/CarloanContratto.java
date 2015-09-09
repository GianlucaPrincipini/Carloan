package presentation.gui;

public class CarloanContratto extends CarloanStage{
	public CarloanContratto(){
		super("SchermataContratto.fxml", null);
		setTitle("Immissione Contratto");
	}
	
	public CarloanContratto(Object entity) {
		super("SchermataContratto.fxml", entity);
		setTitle("Immissione Contratto");
	}
}
