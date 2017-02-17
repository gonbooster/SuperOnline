import java.util.Scanner;


public class Otros extends NoPerecedero{

	private String categoria;
	private double VALOR_IVA= 0.4;
	
	public Otros(int codigo, String nombre, double precio, int cantidad,
			double peso, String categoria) {
		super(codigo, nombre, precio, cantidad, peso);

		this.categoria=categoria;
		this.setIVA(VALOR_IVA);
	}

	 public Otros (Scanner in){
		  super(in);
		  this.setIVA(VALOR_IVA);
		  System.out.println("Introduce la categoría producto (String):");
		  String c =  "";
		  try {
		   c = in.next();
		   in.nextLine();
		  } 
		  catch (Exception e) {
		   c = "Ninguna";
		  }
		  finally {
		   this.categoria = c;
		  }
		 }
	 
	public String guardar()
	{
		return super.guardar() + " " + this.categoria + " Otros";
	}
	public void imprimir()
	{
		super.imprimir();
		System.out.println(" Categoría: " + this.categoria);
	}

}
