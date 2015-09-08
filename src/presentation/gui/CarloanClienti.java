package presentation.gui;

public class CarloanClienti extends CarloanStage{
	
	public CarloanClienti(){
		super("SchermataCliente.fxml", null);
	}
	
	public CarloanClienti(Object entity) {
		super("SchermataCliente.fxml", entity);
		System.out.println(entity);
	}
}
