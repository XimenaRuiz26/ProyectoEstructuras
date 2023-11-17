package model;

import structures.ListaSimple;

public class Proceso {
	private int id; 
	private String nombre; 
	private ListaSimple<Actividad> actividades;
	
	public Proceso(int id, String nombre, ListaSimple<Actividad> actividades) {
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

	public ListaSimple<Actividad> getActividades() {
		return actividades;
	}

	public void setActividades(ListaSimple<Actividad> actividades) {
		this.actividades = actividades;
	}
	
	
	
	

}
