package presentation.gui;

public class CarloanAgenzie extends CarloanStage{
	
	public CarloanAgenzie(){
		super("SchermataCliente.fxml", null);
		setTitle("Immissione cliente");
	}
	
	public CarloanAgenzie(Object entity) {
		super("SchermataCliente.fxml", entity);
		setTitle("Immissione cliente");
	}
}
