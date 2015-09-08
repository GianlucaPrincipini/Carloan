package presentation.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;

public abstract class SchermataDati<T> implements Initializable{
	
	protected boolean edit;
	
	public abstract void onConferma();
	public abstract void onCancel();
	public abstract void initModifica(T entity);
}
