package presentation.gui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CarloanStage extends Stage{
	
	private Object value;
	private Pane root;
	private Scene scene;
	
	public CarloanStage(String file) {
        Class<?> mainClass = getClass();

        FXMLLoader fxmlLoader = new FXMLLoader(mainClass.getResource(file));

        try {
            root = (Pane) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        scene = new Scene(root);
        setScene(scene);
	}
	
	public void setResult(Object result) {
		value = result;
	}
	
	public Object showStage() {
		showAndWait();
		return value;
	}
}
