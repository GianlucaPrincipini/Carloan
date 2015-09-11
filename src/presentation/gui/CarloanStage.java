package presentation.gui;

import java.io.IOException;

import presentation.Target;
import presentation.gui.controller.SchermataDati;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public abstract class CarloanStage extends Stage implements Target{
	
	private Object value;
	private Pane root;
	private Scene scene;
	
	private final static String VIEW_LOCATION = "/presentation/gui/view/";
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public CarloanStage(String file, Object entity) {
        Class<?> mainClass = getClass();
        

        FXMLLoader fxmlLoader = new FXMLLoader(mainClass.getResource(VIEW_LOCATION + file));

        try {
            root = (Pane) fxmlLoader.load();
            if (entity != null) {
                setOnCloseRequest(new EventHandler<WindowEvent>() {
                    public void handle(WindowEvent we) {
                    	fxmlLoader.<SchermataDati>getController().setEdit(false);
                    	fxmlLoader.<SchermataDati>getController().setId(0);
                    }
                });
            	fxmlLoader.<SchermataDati>getController().initModifica(entity);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        scene = new Scene(root);
        setScene(scene);
        setResizable(false);
  
	}
	
	public void setResult(Object result) {
		value = result;
	}
	
	public Object showStage() {
		show();
		return value;
	}
}
