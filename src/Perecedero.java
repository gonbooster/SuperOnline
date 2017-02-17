import java.util.Scanner;


public abstract class Perecedero extends Producto implements Enviable{

	private String fechacad;
	
	public Perecedero(int codigo, String nombre, double precio, int cantidad,
			double peso, String fechacad) {
		super(codigo, nombre, precio, cantidad, peso);
		
		this.fechacad=fechacad;
	}

	public Perecedero(Scanner in) 
	{
		  super(in);
		  System.out.println("Introduce la fecha del producto (String):");
		  String f =  "";
		  try {
		   f = in.next();
		   in.nextLine();
		  } 
		  catch (Exception e) {
		   f = "Ninguna";
		  }
		  finally {
		   this.fechacad = f;   
		  }
	}
	
	public double tarifaEnvio()
	{
		return 1.71;
	}
	public void imprimir()
	{
		super.imprimir();
		System.out.printf(" (Producto perecedero:" + this.fechacad + ") Producto");
	}
	public String guardar()
	{
		return super.guardar() + " " + this.fechacad;
	}
	public void imprimirEnvio()
	{
		super.imprimirEnvio();
		System.out.printf(", Tarifa de envío: " + this.tarifaEnvio());
		if (envioFragil()){
			   System.out.print(" Producto fragil" );
			  }
		System.out.printf(" PRECIO_TOTAL: ");
		System.out.printf("%.2f",this.tarifaEnvio()+(this.getPrecio()*this.calcularPrecioIVA()));
		System.out.println("");
	}
	public boolean envioFragil()
	{
		return true;
	}
}
