package controllers;

import aplication.Aplicacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class AdminController {
	
	private Aplicacion aplicacion;
	
	@FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField txtContrasenia;

    @FXML
    private Button btnEntrar;

    @FXML
    void entrarEvent(ActionEvent event) {

    }


	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;

	}

}
