import java.util.Scanner;


public class Bebida extends Perecedero{

	private String graduacion;
	private double VALOR_IVA= 0.16;
	
	public Bebida(int codigo, String nombre, double precio, int cantidad,
			double peso, String fechacad, String graduacion) {
		super(codigo, nombre, precio, cantidad, peso, fechacad);

		this.graduacion=graduacion;
		this.setIVA(VALOR_IVA);
	}
	
	public Bebida(Scanner in) 
	{
		  super(in);
		  this.setIVA(VALOR_IVA);
		  System.out.println("Introduce la graduacion del producto (String):");
		  String g =  "";
		  try {
		   g = in.next();
		   in.nextLine();
		  } 
		  catch (Exception e) {
		   g = "Ninguna";
		  }
		  finally {
		   this.graduacion = g;
		  }
	}
	
	public String guardar()
	{
		return super.guardar() + " " + this.graduacion + " Bebida";
	}
	public void imprimir()
	{
		super.imprimir();
		System.out.println(" Graduación: " + this.graduacion);
	}
	public boolean envioFragil()
	{
		return true;
	}

	@Override
	public double tarifaEnvio() {
		return super.tarifaEnvio();
	}
}
