package presentation.gui;

public class CarloanVettura extends CarloanStage{
	
	public CarloanVettura(){
		super("SchermataVettura.fxml", null);
		setTitle("Immissione Vettura");
	}
	
	public CarloanVettura(Object entity) {
		super("SchermataVettura.fxml", entity);
		setTitle("Immissione Vettura");
	}
}
