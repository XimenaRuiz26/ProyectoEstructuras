package aplication;

import java.io.IOException;

import controllers.AdminController;
import controllers.InicioController;
import controllers.PrincipalController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Aplicacion extends Application{

	private Stage primaryStage;

	@Override
	public void start(Stage primaryStage) {

		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Alcanzando la nota");

		mostrarVentanaIniciar();

	}

	//Procedimientos que muestra las ventanas del proyecto
	
	public void mostrarVentanaIniciar() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/Inicio.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			InicioController inicioController= loader.getController();
			inicioController.setAplicacion(this);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			//primaryStage.setResizable(false);
			primaryStage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void mostrarVentanaLoginA() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/LoginAdmin.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			AdminController adminController= loader.getController();
			adminController.setAplicacion(this);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			//primaryStage.setResizable(false);
			primaryStage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void mostrarVentanaPrincipal(String usuarioAdmin) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/Principal.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			PrincipalController principalController= loader.getController();
			principalController.setAplicacion(this, usuarioAdmin);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			//primaryStage.setResizable(false);
			primaryStage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//procedimiento main 
	
	public static void main(String[] args) {
		launch(args);
	}
}