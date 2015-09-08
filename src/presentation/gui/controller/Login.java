package presentation.gui.controller;

import integration.Encrypt;

import java.net.URL;
import java.util.ResourceBundle;

import presentation.gui.CarloanStage;
import business.applicationservice.ApplicationServiceOperatore;
import business.entity.Operatore;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Login implements Initializable {
	@FXML
	private Node root;
	
	@FXML
	private TextField username;
	
	@FXML
	private TextField password;

	@FXML
	private Button login;

	@SuppressWarnings("unused")
	@FXML
	public void onLogin() {
		Operatore operatore = new Operatore();
		operatore.setUsername(username.getText());
		operatore.setPassword(password.getText());
		try {
			if (new ApplicationServiceOperatore().login(operatore)) {
				System.out.println("loggato");
			} else {
				((Stage) root.getScene().getWindow()).close();
			}
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	
}
