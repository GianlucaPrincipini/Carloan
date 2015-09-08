package presentation;
	
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import business.applicationservice.ApplicationServiceCliente;
import business.entity.Cliente;
import presentation.frontcontroller.CarloanFrontController;
import presentation.frontcontroller.FrontController;
import integration.Encrypt;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	
	@Override
	public void start(Stage stage) {
		try {
			Cliente cli = new ApplicationServiceCliente().read("1234567890");
			System.out.println(cli);
			CarloanFrontController.getInstance().processRequest("MostraMainStage");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		launch(args);
	}
}
