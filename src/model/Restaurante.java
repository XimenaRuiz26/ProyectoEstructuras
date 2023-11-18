package model;

import structures.Lista;

public class Restaurante {
	
	private String nombre; 
	private String direccion; 
	private Lista<Proceso> listaProcesos;
	private Admin admin;
	
	public Restaurante(String nombre, String direccion) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		listaProcesos = new Lista<Proceso>();
		admin= new Admin();
	}
	
	public Restaurante(){
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Lista<Proceso> getListaProcesos() {
		return listaProcesos;
	}

	public void setListaProcesos(Lista<Proceso> listaProcesos) {
		this.listaProcesos = listaProcesos;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	
	
	
	
	

}
