package presentation.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.stage.Stage;

public abstract class SchermataDati<T> implements Initializable{

	@FXML
	private Node root;
	
	protected boolean edit;
	
	public abstract void onConferma();
	public abstract void initModifica(T entity);

	
	protected void close() {
		((Stage)root.getScene().getWindow()).close();
	}
	
}
