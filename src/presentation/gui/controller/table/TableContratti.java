package presentation.gui.controller.table;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import presentation.frontcontroller.CarloanFrontController;
import presentation.frontcontroller.FrontController;
import integration.DateHelper;
import business.entity.Agenzia;
import business.entity.Cliente;
import business.entity.Contratto;
import business.entity.Fascia;
import business.entity.Modello;
import business.entity.Operatore;
import business.entity.Optional;
import business.entity.Vettura;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;


public class TableContratti implements Initializable {

	private FrontController controller;
	
	@FXML
	private AnchorPane root;
	
	@FXML
	private TableColumn<Contratto,String> id;
	
	@FXML
	private TableColumn<Contratto,String> operatore;
	
	@FXML
	private TableColumn<Contratto,String> cliente;
	
	@FXML
	private TableColumn<Contratto,String> targaVettura;
	
	@FXML
	private TableColumn<Contratto,String> agenziaNoleggio;
	
	@FXML
	private TableColumn<Contratto,String> agenziaConsegna;
	
	@FXML
	private TableColumn<Contratto,String> dataStipula;
	
	@FXML
	private TableColumn<Contratto,String> dataInizioNoleggio;
	
	@FXML
	private TableColumn<Contratto,String> dataFineNoleggio;
	
	@FXML
	private TableColumn<Contratto,String> dataChiusura;
	
	@FXML
	private TableColumn<Contratto,String> limitazioneChilometraggio;
	
	@FXML
	private TableColumn<Contratto,String> chilometriPrevisti;
	
	@FXML
	private TableColumn<Contratto,String> chilometriPercorsi;
	
	@FXML
	private TableColumn<Contratto,String> rifornimento;
	
	@FXML
	private TableColumn<Contratto,String> assicurazioneAvanzata;
	
	@FXML
	private TableColumn<Contratto,String> acconto;
	
	@FXML
	private TableColumn<Contratto,String> costo;
	
	@FXML
	private TableColumn<Contratto,String> chiuso;
	
	@FXML
	private TableView<Contratto> tabContratti;
	
	/*
	@FXML
	private TableView<Cliente> tabClienti;
	
	@FXML
	private TableView<Agenzia> tabAgenzie;
	
	@FXML
	private TableView<Modello> tabModelli;
	
	@FXML
	private TableView<Vettura> tabVetture;
	
	@FXML
	private TableView<Fascia> tabFasce;
	
	@FXML
	private TableView<Optional> tabOptional;
	
	@FXML
	private TableView<Operatore> tabOperatori;
	*/
	
	
	public TableContratti() {
	
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public TableContratti(ObservableList<Contratto> entities){
		System.out.println(id);
		System.out.println(entities);
		
		
        id.setCellValueFactory(new Callback<CellDataFeatures<Contratto, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<Contratto, String> c) {
            	return new ReadOnlyObjectWrapper(c.getValue().getId());
     		}
        });
      
        operatore.setCellValueFactory(new Callback<CellDataFeatures<Contratto, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<Contratto, String> c) {
            	return new ReadOnlyObjectWrapper(c.getValue().getOperatore().getUsername());
     		}
        });
        cliente.setCellValueFactory(new Callback<CellDataFeatures<Contratto, String>, ObservableValue<String>>() {
        	public ObservableValue<String> call(CellDataFeatures<Contratto, String> c) {
            	return new ReadOnlyObjectWrapper(c.getValue().getCliente().getCodicePatente());
     		}
        });
        targaVettura.setCellValueFactory(new Callback<CellDataFeatures<Contratto, String>, ObservableValue<String>>() {
        	public ObservableValue<String> call(CellDataFeatures<Contratto, String> c) {
            	return new ReadOnlyObjectWrapper(c.getValue().getVettura().getTarga());
     		}
        });
        agenziaNoleggio.setCellValueFactory(new Callback<CellDataFeatures<Contratto, String>, ObservableValue<String>>() {
        	public ObservableValue<String> call(CellDataFeatures<Contratto, String> c) {
            	return new ReadOnlyObjectWrapper(c.getValue().getAgenziaNoleggio().getId());
     		}
        });
        agenziaConsegna.setCellValueFactory(new Callback<CellDataFeatures<Contratto, String>, ObservableValue<String>>() {
        	public ObservableValue<String> call(CellDataFeatures<Contratto, String> c) {
            	return new ReadOnlyObjectWrapper(c.getValue().getAgenziaConsegna().getId());
     		}
        });
        dataStipula.setCellValueFactory(new Callback<CellDataFeatures<Contratto, String>, ObservableValue<String>>() {
        	public ObservableValue<String> call(CellDataFeatures<Contratto, String> c) {
            	return new ReadOnlyObjectWrapper(DateHelper.dateAsString(c.getValue().getDataStipula()));
     		}
        });
        dataInizioNoleggio.setCellValueFactory(new Callback<CellDataFeatures<Contratto, String>, ObservableValue<String>>() {
        	public ObservableValue<String> call(CellDataFeatures<Contratto, String> c) {
            	return new ReadOnlyObjectWrapper(DateHelper.dateAsString(c.getValue().getDataInizioNoleggio()));
     		}
        });
        dataFineNoleggio.setCellValueFactory(new Callback<CellDataFeatures<Contratto, String>, ObservableValue<String>>() {
        	public ObservableValue<String> call(CellDataFeatures<Contratto, String> c) {
            	return new ReadOnlyObjectWrapper(DateHelper.dateAsString(c.getValue().getDataFineNoleggio()));
     		}
        });
        dataChiusura.setCellValueFactory(new Callback<CellDataFeatures<Contratto, String>, ObservableValue<String>>() {
        	public ObservableValue<String> call(CellDataFeatures<Contratto, String> c) {
            	return new ReadOnlyObjectWrapper(DateHelper.dateAsString(c.getValue().getDataChiusura()));
     		}
        });
        limitazioneChilometraggio.setCellValueFactory(new Callback<CellDataFeatures<Contratto, String>, ObservableValue<String>>() {
        	public ObservableValue<String> call(CellDataFeatures<Contratto, String> c) {
            	return new ReadOnlyObjectWrapper(c.getValue().isChilometraggioLimitato());
     		}
        });
        chilometriPrevisti.setCellValueFactory(new Callback<CellDataFeatures<Contratto, String>, ObservableValue<String>>() {
        	public ObservableValue<String> call(CellDataFeatures<Contratto, String> c) {
            	return new ReadOnlyObjectWrapper(c.getValue().getChilometriPrevisti());
     		}
        });
        chilometriPercorsi.setCellValueFactory(new Callback<CellDataFeatures<Contratto, String>, ObservableValue<String>>() {
        	public ObservableValue<String> call(CellDataFeatures<Contratto, String> c) {
            	return new ReadOnlyObjectWrapper(c.getValue().getChilometriPercorsi());
     		}
        });
        rifornimento.setCellValueFactory(new Callback<CellDataFeatures<Contratto, String>, ObservableValue<String>>() {
        	public ObservableValue<String> call(CellDataFeatures<Contratto, String> c) {
            	return new ReadOnlyObjectWrapper(c.getValue().getRifornimento());
     		}
        });
        assicurazioneAvanzata.setCellValueFactory(new Callback<CellDataFeatures<Contratto, String>, ObservableValue<String>>() {
        	public ObservableValue<String> call(CellDataFeatures<Contratto, String> c) {
            	return new ReadOnlyObjectWrapper(c.getValue().isAssicurazioneAvanzata());
     		}
        });
        acconto.setCellValueFactory(new Callback<CellDataFeatures<Contratto, String>, ObservableValue<String>>() {
        	public ObservableValue<String> call(CellDataFeatures<Contratto, String> c) {
            	return new ReadOnlyObjectWrapper(c.getValue().getAcconto());
     		}
        });
        costo.setCellValueFactory(new Callback<CellDataFeatures<Contratto, String>, ObservableValue<String>>() {
        	public ObservableValue<String> call(CellDataFeatures<Contratto, String> c) {
            	return new ReadOnlyObjectWrapper(c.getValue().getCosto());
     		}
        });
        chiuso.setCellValueFactory(new Callback<CellDataFeatures<Contratto, String>, ObservableValue<String>>() {
        	public ObservableValue<String> call(CellDataFeatures<Contratto, String> c) {
            	return new ReadOnlyObjectWrapper(c.getValue().isChiuso());
     		}
        });
        
		tabContratti.setItems(entities);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		controller = new CarloanFrontController();
		
		ObservableList<Contratto> contratti = FXCollections.observableList((List<Contratto>) controller.processRequest("ReadAllContratti"));
		
		System.out.println(id);
		System.out.println(contratti);
		
		
        id.setCellValueFactory(new Callback<CellDataFeatures<Contratto, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<Contratto, String> c) {
            	return new ReadOnlyObjectWrapper(c.getValue().getId());
     		}
        });
      
        operatore.setCellValueFactory(new Callback<CellDataFeatures<Contratto, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<Contratto, String> c) {
            	return new ReadOnlyObjectWrapper(c.getValue().getOperatore().getUsername());
     		}
        });
        cliente.setCellValueFactory(new Callback<CellDataFeatures<Contratto, String>, ObservableValue<String>>() {
        	public ObservableValue<String> call(CellDataFeatures<Contratto, String> c) {
            	return new ReadOnlyObjectWrapper(c.getValue().getCliente().getCodicePatente());
     		}
        });
        targaVettura.setCellValueFactory(new Callback<CellDataFeatures<Contratto, String>, ObservableValue<String>>() {
        	public ObservableValue<String> call(CellDataFeatures<Contratto, String> c) {
            	return new ReadOnlyObjectWrapper(c.getValue().getVettura().getTarga());
     		}
        });
        agenziaNoleggio.setCellValueFactory(new Callback<CellDataFeatures<Contratto, String>, ObservableValue<String>>() {
        	public ObservableValue<String> call(CellDataFeatures<Contratto, String> c) {
            	return new ReadOnlyObjectWrapper(c.getValue().getAgenziaNoleggio().getId());
     		}
        });
        agenziaConsegna.setCellValueFactory(new Callback<CellDataFeatures<Contratto, String>, ObservableValue<String>>() {
        	public ObservableValue<String> call(CellDataFeatures<Contratto, String> c) {
            	return new ReadOnlyObjectWrapper(c.getValue().getAgenziaConsegna().getId());
     		}
        });
        dataStipula.setCellValueFactory(new Callback<CellDataFeatures<Contratto, String>, ObservableValue<String>>() {
        	public ObservableValue<String> call(CellDataFeatures<Contratto, String> c) {
            	return new ReadOnlyObjectWrapper(DateHelper.dateAsString(c.getValue().getDataStipula()));
     		}
        });
        dataInizioNoleggio.setCellValueFactory(new Callback<CellDataFeatures<Contratto, String>, ObservableValue<String>>() {
        	public ObservableValue<String> call(CellDataFeatures<Contratto, String> c) {
            	return new ReadOnlyObjectWrapper(DateHelper.dateAsString(c.getValue().getDataInizioNoleggio()));
     		}
        });
        dataFineNoleggio.setCellValueFactory(new Callback<CellDataFeatures<Contratto, String>, ObservableValue<String>>() {
        	public ObservableValue<String> call(CellDataFeatures<Contratto, String> c) {
            	return new ReadOnlyObjectWrapper(DateHelper.dateAsString(c.getValue().getDataFineNoleggio()));
     		}
        });
        dataChiusura.setCellValueFactory(new Callback<CellDataFeatures<Contratto, String>, ObservableValue<String>>() {
        	public ObservableValue<String> call(CellDataFeatures<Contratto, String> c) {
            	return new ReadOnlyObjectWrapper(DateHelper.dateAsString(c.getValue().getDataChiusura()));
     		}
        });
        limitazioneChilometraggio.setCellValueFactory(new Callback<CellDataFeatures<Contratto, String>, ObservableValue<String>>() {
        	public ObservableValue<String> call(CellDataFeatures<Contratto, String> c) {
            	return new ReadOnlyObjectWrapper(c.getValue().isChilometraggioLimitato());
     		}
        });
        chilometriPrevisti.setCellValueFactory(new Callback<CellDataFeatures<Contratto, String>, ObservableValue<String>>() {
        	public ObservableValue<String> call(CellDataFeatures<Contratto, String> c) {
            	return new ReadOnlyObjectWrapper(c.getValue().getChilometriPrevisti());
     		}
        });
        chilometriPercorsi.setCellValueFactory(new Callback<CellDataFeatures<Contratto, String>, ObservableValue<String>>() {
        	public ObservableValue<String> call(CellDataFeatures<Contratto, String> c) {
            	return new ReadOnlyObjectWrapper(c.getValue().getChilometriPercorsi());
     		}
        });
        rifornimento.setCellValueFactory(new Callback<CellDataFeatures<Contratto, String>, ObservableValue<String>>() {
        	public ObservableValue<String> call(CellDataFeatures<Contratto, String> c) {
            	return new ReadOnlyObjectWrapper(c.getValue().getRifornimento());
     		}
        });
        assicurazioneAvanzata.setCellValueFactory(new Callback<CellDataFeatures<Contratto, String>, ObservableValue<String>>() {
        	public ObservableValue<String> call(CellDataFeatures<Contratto, String> c) {
            	return new ReadOnlyObjectWrapper(c.getValue().isAssicurazioneAvanzata());
     		}
        });
        acconto.setCellValueFactory(new Callback<CellDataFeatures<Contratto, String>, ObservableValue<String>>() {
        	public ObservableValue<String> call(CellDataFeatures<Contratto, String> c) {
            	return new ReadOnlyObjectWrapper(c.getValue().getAcconto());
     		}
        });
        costo.setCellValueFactory(new Callback<CellDataFeatures<Contratto, String>, ObservableValue<String>>() {
        	public ObservableValue<String> call(CellDataFeatures<Contratto, String> c) {
            	return new ReadOnlyObjectWrapper(c.getValue().getCosto());
     		}
        });
        chiuso.setCellValueFactory(new Callback<CellDataFeatures<Contratto, String>, ObservableValue<String>>() {
        	public ObservableValue<String> call(CellDataFeatures<Contratto, String> c) {
            	return new ReadOnlyObjectWrapper(c.getValue().isChiuso());
     		}
        });
        
		tabContratti.setItems(contratti);
	}
}
