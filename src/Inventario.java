import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

public class Inventario 
{
private static Vector<Producto> listaProductos ;
private static final String ficheroInventario="productos.txt";
private static int ultimoCodigo;

@SuppressWarnings("serial")
public static class ProductoDesconocido extends Exception {
	 public ProductoDesconocido(String s){
		   super(s);
		  }
}
	public Inventario(){}
	
	public static void cargarProductos(){ 
		listaProductos = new Vector<Producto>();
		
		System.out.println("   [[Cargando productos...]]");
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(ficheroInventario));
		    String linea = br.readLine();
	        while (linea != null) {
	        	try {
	            String[] elementos = linea.split(" ");
	            
	            if (elementos[elementos.length-1].equals("Lacteo")) {
	            	listaProductos.add(new Lacteo(Integer.parseInt(elementos[0]), elementos[1], Double.parseDouble(elementos[2]),Integer.parseInt(elementos[3]),Double.parseDouble(elementos[4]),elementos[5],elementos[6]));
	            }
	            else if (elementos[elementos.length-1].equals("FrutaHortaliza")) {
	            	listaProductos.add(new FrutaHortaliza(Integer.parseInt(elementos[0]), elementos[1], Double.parseDouble(elementos[2]),Integer.parseInt(elementos[3]),Double.parseDouble(elementos[4]),elementos[5],elementos[6]));
	            }
	            else if (elementos[elementos.length-1].equals("Otros")) {
	            	listaProductos.add(new Otros(Integer.parseInt(elementos[0]), elementos[1], Double.parseDouble(elementos[2]),Integer.parseInt(elementos[3]),Double.parseDouble(elementos[4]),elementos[5]));
	            }
	            else if (elementos[elementos.length-1].equals("Bebida")) {
	            	listaProductos.add(new Bebida(Integer.parseInt(elementos[0]), elementos[1], Double.parseDouble(elementos[2]),Integer.parseInt(elementos[3]),Double.parseDouble(elementos[4]),elementos[5],elementos[6]));
	            }
	            else if (elementos[elementos.length-1].equals("Herramienta")) {
	            	listaProductos.add(new Herramienta(Integer.parseInt(elementos[0]), elementos[1], Double.parseDouble(elementos[2]),Integer.parseInt(elementos[3]),Double.parseDouble(elementos[4])));
	            }
                else {throw new ProductoDesconocido("Producto desconocido");}  
	            linea = br.readLine();
	            ultimoCodigo = Integer.parseInt(elementos[0]);
	        	}catch (ProductoDesconocido e){
	    			System.out.println(linea);
	    			System.out.println(".....[[Es un producto desconocido, no se procesará. Revise el catálogo!]]");
		            linea = br.readLine();      		
	        	}
	        }
	        System.out.println("   [[...Productos cargados en inventario!]]");
		} catch (IOException e) {
			System.out.println(".....[[No se han podido cargar los productos!]]");
			System.out.println();
		} finally {
	        try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
		System.out.println();
	}
	public static void guardarProductos()
	{
		 FileWriter fichero = null;
	        PrintWriter pw = null;
	        try
	        {
	            fichero = new FileWriter(ficheroInventario);
	            pw = new PrintWriter(fichero);
	 
	            for (int i = 0; i < listaProductos.size(); i++)
	                pw.println(listaProductos.elementAt(i).guardar());
	 
	        } catch (Exception e) {
	        } finally {
	           try {
	           if (null != fichero)
	              fichero.close();
	           } catch (Exception e2) {
	              e2.printStackTrace();
	           }
	        }
	}
	public static void addNuevoProducto(Producto p)
	{
		
		listaProductos.add(p);
		p.setCodigo(ultimoCodigo+1);}
			
		
	
	public static void mostrarProductos()
	{
		try{
		for (int i = 0; i < listaProductos.size(); i++)
			listaProductos.elementAt(i).imprimir();
		}catch(java.lang.NullPointerException s){
			System.out.printf("No hay ninguna lista de productos cargada\n");
		}
		
	}
	public static Producto getProducto( int id)
	{
		
		return listaProductos.elementAt(id-1);
		
	
	}
	public static void actualizarCantidad( int codigo, int cant)
	{
		try{
			for (int i = 0; i < listaProductos.size(); i++)
				{
					if (listaProductos.elementAt(i).getCodigo() == codigo)
					{
					listaProductos.elementAt(i).setCantidad(cant);
					}
				}
			}catch (java.lang.NullPointerException s){
				System.out.printf("No hay ninguna lista cargada\n");
			}
	}
	public static int tamanio()
	{
		try{
		return listaProductos.size();}
		catch(java.lang.NullPointerException s){
			return -1;
		}
		
	}
	public static void mostrarProductosEnviables()
	{
		try{
		for (int i = 0; i < listaProductos.size(); i++){
			if (listaProductos.elementAt(i) instanceof Enviable)
			{
			listaProductos.elementAt(i).imprimirEnvio();
			}
		}
		}catch (java.lang.NullPointerException s){
			System.out.printf("No hay ninguna lista cargada\n");
		}
	}
		
	
	public static void eliminarProducto( int id)
	{
		listaProductos.remove(id);
	}
}
