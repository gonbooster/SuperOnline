import java.util.Scanner;


public class Herramienta extends NoPerecedero implements Enviable  {

	private double VALOR_IVA= 0.4;
	
	public Herramienta(int codigo, String nombre, double precio, int cantidad,
			double peso) {
		super(codigo, nombre, precio, cantidad, peso);
		this.setIVA(VALOR_IVA);
	}

	public Herramienta(Scanner in) 
	{
		super(in);
		this.setIVA(VALOR_IVA);
	}
	
	public boolean envioFragil()
	{
		return false;
	}
	public double tarifaEnvio()
	{
		return 3.71;
	}
	public String guardar()
	{
		return (super.guardar() + " " + " Herramienta");
	}
	public void imprimir()
	{
		super.imprimir();
		System.out.println(" Herramienta");
	}
	public void imprimirEnvio()
	{
		super.imprimirEnvio();
		System.out.printf(", Tarifa de envío: " + this.tarifaEnvio());
		System.out.printf(" PRECIO_TOTAL: ");
		System.out.printf("%.2f",this.tarifaEnvio()+(this.getPrecio()*this.calcularPrecioIVA()));
		System.out.println("");
	}
}
