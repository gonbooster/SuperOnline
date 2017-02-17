import java.util.Scanner;

public class Super_OnLine {

	static Scanner in = new Scanner(System.in);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
					
		int opcion = 1;
		
		System.out.println("========================================================================");
		System.out.println("=                SISTEMA DE GESTI�N DE SUPER-ON_LINE                  =");
		System.out.println("========================================================================");
		System.out.println();
		System.out.println();

		
		while (opcion != 0) {
			mostrarMenuInventario();
			System.out.println("Opci�n? ");
			opcion = leerOpcion(8); 	
			
			switch(opcion) {
			case 0:	System.out.println("Termina la aplicaci�n"); 
					System.exit(0);
					
			case 1: try{ Inventario.cargarProductos();  // carga los productos del inventario
					pause();
					}catch(java.lang.NullPointerException s){
						System.out.printf("No existe ningun txt\n");
					}
					break; 
			
			case 2: Inventario.mostrarProductos(); // muestra los productos del inventario
					pause();
					break; 	
					
			case 3:                                //actualizar la cantidad de un producto en almac�n
				
				while (opcion!=0) {
						Inventario.mostrarProductos();
					System.out.println("0 - Finalizar actualizaci�n del inventario");
					System.out.println("Elige el n�mero del producto a actualizar, Id:x (/= 0):");
					System.out.println("Opci�n? ");
					try{
							int cod = Inventario.getProducto(Inventario.tamanio()).getCodigo();
						
					opcion = leerOpcion(cod+1); 	//se han mostrado todos los articulos 
																	//+ opci�n de salida
					if (opcion!=0) {
						System.out.println("Elige la nueva cantidad:");
						int cant = in.nextInt();
						in.nextLine();
						Inventario.actualizarCantidad(opcion,cant);  //actualiza el mismo producto del inventario
						System.out.println("Producto n�mero: " + opcion + " actualizado...");
						System.out.println();
						pause();
					}
					}catch(java.lang.NullPointerException s ){
						opcion=0;
					}catch(java.lang.ArrayIndexOutOfBoundsException s){
						opcion=0;
					}
				} opcion=1; 
				
				break;
				
			case 4: 	                       	//a�adir un nuevo producto al almac�n
				while (opcion!=0) {
					mostrarMenuAddNuevoProducto();
					System.out.println("Opci�n? ");
					opcion = leerOpcion(6); 	// 5 clases de productos y salida del men�
					if (opcion!=0) {
						Producto P = nuevoProducto(opcion);
						Inventario.addNuevoProducto(P);
						System.out.println("Producto a�adido, n�mero "+Inventario.tamanio());
						Inventario.getProducto(Inventario.tamanio()).imprimir(); //imprime el �ltimo producto incluido
						System.out.println();						
						System.out.println();
						pause();
					}
				} opcion=1; break;
			case 5: Inventario.mostrarProductosEnviables();  // muestra los productos enviables del inventario
					pause();
					break; 	
					
			case 6:   	// Eliminar producto del inventario en el fichero de texto
			
				while (opcion!=0) {
					Inventario.mostrarProductos();
				System.out.println("0 - Finalizar actualizaci�n del inventario");
				System.out.println("Elige el n�mero del producto a eliminar, Id:x (/= 0):");
				System.out.println("Opci�n? ");
				try{
						int cod = Inventario.getProducto(Inventario.tamanio()).getCodigo();
					
				opcion = leerOpcion(cod+1); 	//se han mostrado todos los articulos 
																//+ opci�n de salida
				if (opcion!=0) {				
					Inventario.eliminarProducto(opcion-1);
					System.out.println("Producto n�mero: " + opcion + " eliminado...");
					pause();
				}
				}catch(java.lang.NullPointerException s ){
					opcion=0;
				}catch(java.lang.ArrayIndexOutOfBoundsException s){
					opcion=0;
				}
			} opcion=1; 
			
			break;
					
			
			case 7: Inventario.guardarProductos();   	// guarda el inventario en el fichero de texto
					pause();
					break;
			}
		}	
	}

	public static void mostrarMenuInventario() {
		/* muestra el men� de actividades posibles sobre el inventario
		 **/
		
		System.out.println("====================================================================");
		System.out.println("=            MENU PRINCIPAL - GESTI�N DE INVENTARIO                =");
		System.out.println("====================================================================");
		System.out.println("            tecla:1   - Cargar productos"); 
		System.out.println("            tecla:2   - Mostrar inventario");
		System.out.println("            tecla:3   - Actualizar existencias");
		System.out.println("            tecla:4   - A�adir nuevo producto");
		System.out.println("            tecla:5   - Mostrar productos enviables");
		System.out.println("            tecla:6   - Eliminar producto");
		System.out.println("            tecla:7   - Guardar inventario");
		System.out.println("            tecla:0   - Terminar");
		System.out.println("====================================================================");
	}

	
	public static void mostrarMenuAddNuevoProducto() {
		/* muestra el men� con las clases posibles de productos
		 **/
		
		System.out.println("====================================================");
		System.out.println("=   Elige el tipo de producto que quieres a�adir:  =");
		System.out.println("====================================================");
		System.out.println("         tecla:1 - Lacteo");
		System.out.println("         tecla:2 - Frutas u hortalizas");
		System.out.println("         tecla:3 - Bebidas");
		System.out.println("         tecla:4 - Herramientas");
		System.out.println("         tecla:5 - Otros");
		System.out.println("         tecla:0 - Cancelar");
		System.out.println("====================================================");
	}
	
	public static Producto nuevoProducto (int n) {		
		Scanner es = new Scanner (System.in);
		Producto P;
		switch(n) {
			case 1: P = new Lacteo(es);break;
			case 2: P = new FrutaHortaliza(es);break;
			case 3: P = new Bebida(es);break;
			case 4: P = new Herramienta(es);break;
			default: P = new Otros(es);break;
		}
		return P;
	}

	private static void pause() {
		System.out.println("(pulsa 0 para continuar...");
		leerOpcion(1);
	}
	

	private static int leerOpcion(int max) { 
		boolean terminar = false;
		int n = 0;
		while (!terminar) {
			try {
				n = in.nextInt();
				in.nextLine();
				if (n>=max || n<0) {
					throw new Exception();
				}
				terminar = true;
			} catch (Exception e) {
				System.out.println("Opci�n incorrecta! elije de nuevo");
				 in.nextLine();
			}
		}
		return n;
	}
}
	

