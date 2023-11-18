package controllers;

import aplication.Aplicacion;

public class PrincipalController {
	
	private Aplicacion aplicacion;
	
	private String usuarioAdmin;


	public void setAplicacion(Aplicacion aplicacion, String usuarioAdmin) {
		this.aplicacion = aplicacion;
		this.usuarioAdmin = usuarioAdmin;

	}

}
