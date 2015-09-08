package presentation.gui;

public class CarloanVetture extends CarloanStage{
	
	public CarloanVetture(){
		super("SchermataVettura.fxml", null);
		setTitle("Immissione Vettura");
	}
	
	public CarloanVetture(Object entity) {
		super("SchermataVettura.fxml", entity);
		setTitle("Immissione Vettura");
	}
}
