package model;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import exceptions.PersonalException;
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

	public Boolean crearPersonal(String nombre2, String apellido, String documento, String direccion2,
			String contrasenia, String email, String usuario, String cargo) {
		Personal personal = new Personal();
		personal.setNombre(nombre2);
		personal.setApellido(apellido);
		personal.setId(documento);
		personal.setDireccion(direccion);
		personal.setContrasenia(contrasenia);
		personal.setEmail(email);
		personal.setUsuario(usuario);
		personal.setCargo(verificarCargo(cargo));

		if(listaPersonal.add(personal) == false){
			return false;
		}else{
			listaPersonal.add(personal);
			return true;
		}
	}

	private Cargo verificarCargo(String cargo) {
		if(cargo.equals("CAMARERO")){
			return Cargo.CAMARERO;
		}
		else if(cargo.equals("COCINERO")){
			return Cargo.COCINERO;
		}
		else if(cargo.equals("CAJERO")){
			return Cargo.CAJERO;
		}
		return null;
	}

	public String traerNombre(String correo) {
		String nombre= "";
		Iterator<Personal> iterator = listaPersonal.iterator();
        while (iterator.hasNext()) {
            Personal aux = iterator.next();
            if (aux.getEmail().equals(correo)) {
                nombre= aux.getNombre();
            }
        }
		return nombre;
	}
}
