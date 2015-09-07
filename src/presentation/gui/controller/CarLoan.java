package presentation.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import business.entity.Entity;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;

public class CarLoan implements Initializable {
	@FXML
	private Node root;
	
	@FXML
	private MenuItem modTariffario;
	
	@FXML
	private MenuItem modIncidenza;
	
	@FXML 
	private MenuItem modCarburante;
	
	@FXML
	private Button aggiungi;
	
	@FXML
	private Button modifica;
	
	@FXML
	private Button rimuovi;
	
	@FXML
	private Button chiudi;
	
	@FXML 
	private TabPane tabPane;

	@FXML
	private TableView<Entity> tabContratti;
	
	@FXML
	private TableView<Entity> tabClienti;
	
	@FXML
	private TableView<Entity> tabAgenzie;
	
	@FXML
	private TableView<Entity> tabModelli;
	
	@FXML
	private TableView<Entity> tabVetture;
	
	@FXML
	private TableView<Entity> tabFasce;
	
	@FXML
	private TableView<Entity> tabOptional;
	
	@FXML
	private TableView<Entity> tabOperatori;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
}
