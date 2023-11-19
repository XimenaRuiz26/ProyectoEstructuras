package controllers;

import aplication.Aplicacion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import model.Proceso;

public class PrincipalController {
	
	private Aplicacion aplicacion;
	
	ModelFactoryController modelFactoryController;
	
	private String usuarioAdmin;
	
	//---------TAB PROCESO------------
	
    @FXML
    private TextField txtNombreProceso;

    @FXML
    private TextField txtIdProcesos;

    @FXML
    private TextField txtDescripcionProcesos;

    @FXML
    private TableView<Proceso> tableProcesos;

    @FXML
    private TableColumn<Proceso, String> columnProceso;

    @FXML
    private Button btnCrearProceso;

    @FXML
    private Label labelNombreP;

    @FXML
    private Label labelIdP;

    @FXML
    private Label labelDescripcionP;

    @FXML
    private Label labelDuracionMinP;

    @FXML
    private Label labelDuracionMaxP;

    @FXML
    private ImageView flechaRegresar;
    
    Proceso procesoSeleccionado;
    
    ObservableList<Proceso> listaProcesosData = FXCollections.observableArrayList();
    
    private ObservableList<Proceso> getListaProcesosData(){
		listaProcesosData.addAll(modelFactoryController.obtenerProcesos());
		return listaProcesosData;
	}

    @FXML
    void crearProcesoEvent(ActionEvent event) {
    	crearProcesoAction();
    }

    @FXML
    void flechaRegresarEvent(MouseEvent event) {
    	flechaRegresar.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent ->{
    		aplicacion.mostrarVentanaIniciar();
    	});
    }
    
    private void crearProcesoAction(){
    	String nombreP = txtNombreProceso.getText();
    	String idP = txtIdProcesos.getText();
    	String descripcionP = txtDescripcionProcesos.getText();
    	
    	if(datosValidosP(nombreP, idP, descripcionP)){
    		if(modelFactoryController.crearProceso(nombreP, idP, descripcionP)){
    			mostrarMensaje("Notificacion creación", "Proceso creado", "Se ha creado con exito el proceso", AlertType.INFORMATION);
    			tableProcesos.setItems(getListaProcesosData());
                tableProcesos.refresh();
    			txtNombreProceso.setText("");
    			txtIdProcesos.setText("");
    			txtDescripcionProcesos.setText("");
    		}else{
    			mostrarMensaje("Notificacion creación", "Proceso no creado", "Ya existe un proceso con el id "+idP+" No se puede crear", AlertType.INFORMATION);
    		}
    	}else {
			mostrarMensaje("Notificación creación", "Informacion invalida", "Informacion invalida", AlertType.ERROR);
		}
    }
    
    private boolean datosValidosP(String nombre, String id, String descripcion) {
		if (nombre.equals("")) {
			return false;
		}
		if (id.equals("")) {
			return false;
		}
		if (descripcion.equals("")) {
			return false;
		}
		return true;

	}

    
    //-----------------------------


	public void setAplicacion(Aplicacion aplicacion, String usuarioAdmin) {
		this.aplicacion = aplicacion;
		this.usuarioAdmin = usuarioAdmin;
		tableProcesos.getItems().clear();
		//tableProcesos.setItems(getListaProcesosData());
	}
	
	@FXML
	void initialize() {
		modelFactoryController = ModelFactoryController.getInstance();
		
		this.columnProceso.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		
		tableProcesos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {

	   		procesoSeleccionado = newSelection;
	   	
	   		mostrarInformacionProceso(procesoSeleccionado);
	   	});
	}
	
	private void mostrarInformacionProceso(Proceso procesoSeleccionado2) {
		labelNombreP.setText(procesoSeleccionado2.getNombre());
		labelIdP.setText(procesoSeleccionado2.getId());
		labelDescripcionP.setText(procesoSeleccionado2.getDescripcion());
		
	}

	public void mostrarMensaje(String titulo, String header, String contenido, AlertType alertType) {

		Alert alert = new Alert(alertType);
		alert.setTitle(titulo);
		alert.setHeaderText(header);
		alert.setContentText(contenido);
		alert.showAndWait();
	}

	
	

}
