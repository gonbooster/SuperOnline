import java.util.Scanner;

public abstract class Producto {
	
	private double iva;
	private int codigo;
	private String nombre; 
	private double precio;
	private int cantidad;
	private double peso;

	public Producto (int codigo, String nombre, double precio, int cantidad, double peso)
	{
		this.codigo=codigo;
		this.nombre=nombre; 
		this.precio=precio;
		this.cantidad=cantidad;
		this.peso=peso;
	}

public Producto(Scanner in) {	
		
		System.out.println("Introduce la descripción del producto (string): ");
		String desc = null;
		try {
			desc = in.nextLine();
		}
		catch (Exception e) {
			desc = "Descripción -producto-erróneo";
		}
		finally {
			nombre = desc.replace(" ","-");
		}
		
		System.out.println("Introduce el precio del producto por unidad en € (0.0):  ");
		double prec =  0.0;
		try {
			prec = in.nextDouble();
			in.nextLine();
		}
		catch (Exception e) {
			prec = 0.0;
		}
		finally {
			precio = prec;
		}
		
		System.out.println("Introduce la cantidad (número de unidades):");
		int cant = 0;
		try {
			cant = in.nextInt();
			in.nextLine();
		}
		catch (Exception e) {
			cant = 0;
		}
		finally {
			cantidad = cant;
		}
		
		System.out.println("Introduce el peso del producto por unidad (en kg)(0.0):");
		double p =  0.0;
		try {
			p = in.nextDouble();
			in.nextLine();
		}
		catch (Exception e) {
			p = 0.0;
		}
		finally {
			peso = p;   
		}
	}
	
	// Visualizadoras
	
	public double getIVA()
	{
		return this.iva;
	}
	public int getCodigo()
	{
		return this.codigo;
	}
	public String getNombre()
	{
		return this.nombre;
	}
	public double getPrecio()
	{
		return this.precio;
	}
	public int getCantidad()
	{
		return this.cantidad;
	}
	public double getPeso()
	{
		return this.peso;
	}
	
	// Modificadoras
	
	public void setIVA(double d)
	{
		this.iva=d;
	}
	public void setCodigo(int id)
	{
		this.codigo=id;
	}
	public void setNombre(String n)
	{
		this.nombre=n;
	}
	public void setPrecio(double pr)
	{
		this.precio=pr;
	}
	public void setCantidad(int c)
	{
		this.cantidad=c;
	}
	
	public double calcularPrecioIVA()
	{
		return (this.precio + this.precio * this.iva);
	}
	public void imprimir()
	{
		System.out.printf("ID: " + this.codigo + " Nombre: " + this.nombre + " Cantidad: " + this.cantidad + " Precio: " + this.precio);
	}
	public void imprimirEnvio()
	{
		System.out.printf("ID: " + this.codigo + " Nombre: " + this.nombre + " Peso: " + this.peso + " IVA: " + this.iva);
		
	}
	public String guardar()
	{
		  return (this.codigo + " " + this.nombre + " " + this.precio  + " " + this.cantidad + " " + this.peso);
	}
}