package controllers;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import exceptions.PersonalException;
import model.Admin;
import model.Cargo;
import model.Personal;
import model.Restaurante;
public class ModelFactoryController {
	Restaurante restaurante;
	

	//------------------------------  Singleton ------------------------------------------------
	// Clase estatica oculta. Tan solo se instanciara el singleton una vez
	private static class SingletonHolder {
		// El constructor de Singleton puede ser llamado desde aquï¿½ al ser protected
		private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
	}

	// Mï¿½todo para obtener la instancia de nuestra clase
	public static ModelFactoryController getInstance() {
		return SingletonHolder.eINSTANCE;
	}

	public ModelFactoryController() {
		//1. inicializar datos y luego guardarlo en archivos
				//iniciarSalvarDatosPrueba();

				//2. Cargar los datos de los archivos
				//cargarDatosDesdeArchivos();
		
				//3. Guardar y Cargar el recurso serializable binario
				//guardarResourceBinario();
				//cargarResourceBinario();

				//4. Guardar y Cargar el recurso serializable XML

//				try {
//					guardarResourceXML();
//					guardarResourceBinario();
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
		
				// Siempre se debe verificar si la raiz del recurso es null
				if (restaurante== null) {
					System.out.println("es null el restaurante");
					iniciarSalvarDatosPrueba();
					// crearCopias();
					// guardarResourceSerializable();
//					guardarResourceXML();
//					guardarResourceBinario();
		
				}
	}
	
	
    private void iniciarSalvarDatosPrueba() {
		inicializarDatos();
//		try {
//
//			Persistencia.guardarVendedores(getRed().getlistaClientes());
//			Persistencia.guardarAdministrador(getRed().getAdministrador());
//			Persistencia.guardarProductos(getRed().getlistaClientes());
//			
//			Persistencia.guardarRecursoBancoBinario(red);
//			Persistencia.guardarRecursoBancoXML(red);
//
//			//Persistencia.cargarDatosArchivos(getBanco());
//
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		System.out.println("Se inicializaron los datos");
	}
    
    private void inicializarDatos() {
    	
    	restaurante= new Restaurante("Sr. Don Platano", "Calarcá");
    	
    	Set <Personal> listaPersonal= new HashSet<Personal>();
    	
    	Admin admin= new Admin();
    	admin.setNombre("Pepe");
    	admin.setId("105465465");
    	admin.setUsuario("pepito12");
    	admin.setContrasenia("12345");
    	
    	Personal personal = new Personal();
    	personal.setNombre("Edd");
    	personal.setApellido("Gutierrez");
    	personal.setId("5345465454");
    	personal.setDireccion("cra 30");
    	personal.setEmail("eddg@gmail.com");
    	personal.setUsuario("eddg");
    	personal.setContrasenia("0000");
    	personal.setCargo(Cargo.CAMARERO);
    	
    	listaPersonal.add(personal);
    	restaurante.setAdmin(admin);

    }
	
	public Restaurante getRed() {
		return restaurante;
	}

	public void setRed(Restaurante restaurante) {
		this.restaurante= restaurante;
	}

	public boolean verificarAdmin(String usuarioAdmin, String contraseniaAdmin) {
		return restaurante.verificarAdmin(usuarioAdmin, contraseniaAdmin);
	}

	public boolean verificarPersonal(String usuario, String contrasenia) {
		return restaurante.verificarPersonal(usuario, contrasenia);
	}

	public boolean crearPersonal(String nombre, String apellido, String documento, String direccion,
			String contrasenia, String email, String usuario, String cargo)  {
		return restaurante.crearPersonal(nombre, apellido, documento, direccion, contrasenia, email, usuario, cargo);
	}
	
	public String traerNombre(String correo){
		return restaurante.traerNombre(correo);
	}

}
