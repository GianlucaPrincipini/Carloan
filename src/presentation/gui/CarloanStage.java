package presentation.gui;

import java.io.IOException;

import presentation.Target;
import presentation.gui.controller.SchermataDati;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public abstract class CarloanStage extends Stage implements Target{
	
	private Object value;
	private Pane root;
	private Scene scene;
	
	private final static String VIEW_LOCATION = "/presentation/gui/view/";
	
	public CarloanStage(String file, Object entity) {
        Class<?> mainClass = getClass();
        
        FXMLLoader fxmlLoader = new FXMLLoader(mainClass.getResource(VIEW_LOCATION + file));

        
        try {
        	System.out.println(VIEW_LOCATION+file);
            root = (Pane) fxmlLoader.load();
            if (entity != null) {
            	((SchermataDati)fxmlLoader.getController()).initModifica(entity);
            }
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
		show();
		return value;
	}
}
