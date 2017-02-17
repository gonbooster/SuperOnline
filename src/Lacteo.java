import java.util.Scanner;


public class Lacteo extends Perecedero{

	private String lote;
	private double VALOR_IVA= 0.04;
	
	public Lacteo(int codigo, String nombre, double precio, int cantidad,
			double peso, String fechacad, String lote) {
		super(codigo, nombre, precio, cantidad, peso, fechacad);

		this.lote=lote;
		this.setIVA(VALOR_IVA);
	}
	
	public Lacteo(Scanner in) 
	{
		  super(in);
		  this.setIVA(VALOR_IVA);
		  System.out.println("Introduce el lote del producto (String):");
		  String l =  "";
		  try {
		   l = in.next();
		   in.nextLine();
		  } 
		  catch (Exception e) {
		   l = "Ninguna";
		  }
		  finally {
		   this.lote = l;		  
		  }
	}
	
	public String guardar()
	{
		return super.guardar() + " " + this.lote + " Lacteo";
	}
	public void imprimir()
	{
		super.imprimir();
		System.out.println(" Lácteo: " + this.lote);
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
