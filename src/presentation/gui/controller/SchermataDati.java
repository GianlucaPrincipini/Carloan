package presentation.gui.controller;

import presentation.frontcontroller.CarloanFrontController;
import presentation.frontcontroller.FrontController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.stage.Stage;

public abstract class SchermataDati<T> implements Initializable{

	@FXML
	private Node root;
	
	protected FrontController controller = CarloanFrontController.getInstance();
	protected boolean edit;	
	protected int id;
	
	public abstract void onConferma();
	public abstract void initModifica(T entity);
	
	protected abstract T buildEntity();

	protected void close() {
		edit = false;
		((Stage)root.getScene().getWindow()).close();
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}
	public void setId(int id) {
		this.id = id;
	}
}
