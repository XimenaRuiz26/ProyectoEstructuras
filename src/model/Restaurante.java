package model;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import structures.Lista;

public class Restaurante {
	
	private String nombre; 
	private String direccion; 
	private Lista<Proceso> listaProcesos;
	private Admin admin;
	private Set<Personal> listaPersonal;
	
	public Restaurante(String nombre, String direccion) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		listaProcesos = new Lista<Proceso>();
		admin= new Admin();
		listaPersonal = new HashSet<Personal>();
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
	
	public Set<Personal> getListaPersonal() {
		return listaPersonal;
	}

	public void setListaPersonal(Set<Personal> listaPersonal) {
		this.listaPersonal = listaPersonal;
	}

	public boolean verificarAdmin(String usuarioAdmin, String contraseniaAdmin) {
		if(admin.getUsuario().equals(usuarioAdmin)&& admin.getContrasenia().equals(contraseniaAdmin)){
			return true;
		}
		return false;
	}
	
	public boolean verificarPersonal(String usuario, String contrasenia) {
		Iterator<Personal> iterator = listaPersonal.iterator();
        while (iterator.hasNext()) {
            Personal aux = iterator.next();
            if (aux.getUsuario().equals(usuario) && aux.getContrasenia().equals(contrasenia)) {
                return true;
            }
        }
		return false;
	}
	
	
	
	
	
	

}
