package presentation.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import presentation.frontcontroller.CarloanFrontController;
import presentation.frontcontroller.FrontController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SchermataChiusura implements Initializable {

	private FrontController controller = CarloanFrontController.getInstance();
	
	private Contratto contratto;
	
	@FXML
	private Node root;

	@FXML
	private DatePicker dataChiusura;
	
	@FXML
	private TextField chilometriPercorsi;
	
	@FXML
	private Label costo;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	@FXML
	public void onCalcolaCosto() {
		costo.setText((Double) controller.processRequest("CalcolaCostoChiusura", ));
	}

}
