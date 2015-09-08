package presentation;
	
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

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
			FXMLLoader fxmlLoader = new FXMLLoader();
			
			Class<?> mainClass = getClass();
			
			Parent root = fxmlLoader.load(mainClass.getResource("/presentation/gui/view/Login.fxml"));
			stage.setTitle("Carloan Login");
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		launch(args);
	}
}
