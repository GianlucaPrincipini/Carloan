package presentation.gui;

public class CarloanCliente extends CarloanStage{
	
	public CarloanCliente(){
		super("SchermataCliente.fxml", null);
		setTitle("Immissione cliente");
	}
	
	public CarloanCliente(Object entity) {
		super("SchermataCliente.fxml", entity);
		setTitle("Immissione cliente");
	}
}
