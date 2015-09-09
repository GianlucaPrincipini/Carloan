package presentation.gui;

public class CarloanAgenzie extends CarloanStage{
	
	public CarloanAgenzie(){
		super("SchermataAgenzia.fxml", null);
		setTitle("Immissione Agenzia");
	}
	
	public CarloanAgenzie(Object entity) {
		super("SchermataAgenzia.fxml", entity);
		setTitle("Immissione Agenzia");
	}
}
