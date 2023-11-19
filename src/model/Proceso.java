package model;

import structures.Lista;

public class Proceso {
	private String id; 
	private String nombre; 
	private String descripcion; 
	private Lista<Actividad> actividades;
	
	public Proceso(String id, String nombre, Lista<Actividad> actividades, String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.actividades = actividades;
		this.descripcion = descripcion;
		
	}
	
	public Proceso(){
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
	
	

}
