package model;

import java.util.ArrayList;
import java.util.Iterator;

import structures.Lista;
import structures.Nodo;

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

	public ArrayList<String> obtenerActividades() {
		ArrayList<String> listaActividades = new ArrayList <String>();
		Nodo<Actividad> actual = actividades.getNodoPrimero();
		while (actual != null) {
			Actividad actividad = (Actividad) actual.getValorNodo();
			listaActividades.add(actividad.getNombre());
			actual = actual.getSiguienteNodo();
		}
		return listaActividades;
	}

	public boolean crearActividad(String nombreA, String descripcion2, String preceder, String seleccion) {
		Actividad actividad = new Actividad();
		actividad.setNombre(nombreA);
		actividad.setDescripcion(descripcion2);
		actividad.setObligatoria(verificarObligatoria(seleccion));
		
		if(verificarActividad(nombreA)== true){
			return false;
		}else{
			
			return true;
		}
	}

	private boolean verificarActividad(String nombreA) {
		Iterator<Actividad> iterator = actividades.iterator();
        while (iterator.hasNext()) {
            Actividad aux = iterator.next();
            if (aux.getNombre().equals(nombreA)) {
                return true;
            }
        }
		return false;
	}

	private boolean verificarObligatoria(String seleccion) {
		if(seleccion.equals("Si")){
			return true;
		}
		else if(seleccion.equals("No")){
			return false;
		}
		return false;
	}
}
