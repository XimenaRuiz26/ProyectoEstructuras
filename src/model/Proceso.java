package model;

import structures.Lista;

public class Proceso {
	private int id; 
	private String nombre; 
	private Lista<Actividad> actividades;
	
	public Proceso(int id, String nombre, Lista<Actividad> actividades) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.actividades = actividades;
	}
	
	public Proceso(){
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Lista<Actividad> getActividades() {
		return actividades;
	}

	public void setActividades(Lista<Actividad> actividades) {
		this.actividades = actividades;
	}
	
	
	
	

}
