package presentation;
	
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import presentation.frontcontroller.CarloanFrontController;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage stage) {
		try {
			CarloanFrontController.getInstance().processRequest("MostraLogin");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		launch(args);
	}
}
