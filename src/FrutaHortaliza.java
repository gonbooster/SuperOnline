import java.util.Scanner;


public class FrutaHortaliza extends Perecedero {
	

	private String origen;
	private double VALOR_IVA= 0.15;
	
	public FrutaHortaliza(int codigo, String nombre, double precio,
			int cantidad, double peso, String fechacad, String origen) {
		super(codigo, nombre, precio, cantidad, peso, fechacad);
		
		this.origen=origen;
		this.setIVA(VALOR_IVA);
	}
	
	public FrutaHortaliza(Scanner in)
	{
			  super(in);
			  this.setIVA(VALOR_IVA);
			  System.out.println("Introduce el origen del producto (String):");
			  String o =  "";
			  try {
			   o = in.next();
			   in.nextLine();
			  } 
			  catch (Exception e) {
			   o = "Ninguna";
			  }
			  finally {
			   this.origen = o; 
			  }
			 
	}
	
	public String guardar()
	{
		return super.guardar() + " " + this.origen + " FrutaHortaliza";
	}
	public void imprimir()
	{
		super.imprimir();
		System.out.println(" Origen: " + this.origen);
	}
	public boolean envioFragil()
	{
		return false;
	}

	@Override
	public double tarifaEnvio() {
		return super.tarifaEnvio();
	}
}
