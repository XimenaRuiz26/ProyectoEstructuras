package controllers;
import model.Admin;
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
    	
    	Admin admin= new Admin();
    	admin.setNombre("Pepe");
    	admin.setId("105465465");
    	admin.setUsuario("pepito12");
    	admin.setContrasenia("12345");

<<<<<<< Updated upstream
    }
=======
    }
>>>>>>> Stashed changes
	
	public Restaurante getRed() {
		return restaurante;
	}

	public void setRed(Restaurante restaurante) {
		this.restaurante= restaurante;
	}

	public boolean verificarAdmin(String usuarioAdmin, String contraseniaAdmin) {
		return restaurante.verificarAdmin(usuarioAdmin, contraseniaAdmin);
	}

}
