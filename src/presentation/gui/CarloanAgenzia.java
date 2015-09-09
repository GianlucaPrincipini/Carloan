package presentation.gui;

public class CarloanAgenzia extends CarloanStage{
	
	public CarloanAgenzia(){
		super("SchermataAgenzia.fxml", null);
		setTitle("Immissione Agenzia");
	}
	
	public CarloanAgenzia(Object entity) {
		super("SchermataAgenzia.fxml", entity);
		setTitle("Immissione Agenzia");
	}
}
