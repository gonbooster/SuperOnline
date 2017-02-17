import java.util.Scanner;


public abstract class NoPerecedero extends Producto {

	public NoPerecedero(int codigo, String nombre, double precio, int cantidad,
			double peso) {
		super(codigo, nombre, precio, cantidad, peso);
	}
	
	public NoPerecedero(Scanner in) 
	{
		super(in);
	}

	public void imprimir()
	{
		super.imprimir();
		System.out.printf(" (Producto no perecedero) Producto");
	}
}
