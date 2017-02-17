import java.util.Scanner;


public class PruebaPerecedero {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int F=0;
		int L=0;
		int B=0;
		// Lectura por teclado.
		Scanner Scan = new Scanner(System.in);
		
		// Objeto FrutaHortaliza
		FrutaHortaliza FrutaHortalizaM = new FrutaHortaliza(F,"Manzana",10.0,100,5.5,"04/05/1991","España");
		System.out.println("Datos insertados FrutaHortalizaM.");
		System.out.println("Insertar datos FrutaHortalizaS:");
		FrutaHortaliza FrutaHortalizaS = new FrutaHortaliza(Scan);
		FrutaHortalizaS.setCodigo(F+1);
		
		// Objeto Lacteo
		Lacteo LacteoM = new Lacteo(L,"Leche",50.0,200,10.5,"01/02/1900.","Lote");
		System.out.println("Datos insertados LacteoM.");
		System.out.println("Insertar datos LacteoS:");
		Lacteo LacteoS = new Lacteo(Scan);
		LacteoS.setCodigo(L+1);
		
		// Objeto Bebida
		Bebida BebidaM = new Bebida(B,"Ron",50.0,200,10.5,"01/02/1900.","Alcohol");
		System.out.println("Datos insertados BebidaM.");
		System.out.println("Insertar datos BebidaS:");
		Bebida BebidaS = new Bebida(Scan);
		BebidaS.setCodigo(B+1);
		
		// Guardar y mostrar guardado
		System.out.println("Mostrando datos guardados de FrutaHortalizaM:");
		System.out.println(FrutaHortalizaM.guardar());
		System.out.println("Mostrando datos guardados de FrutaHortalizaS:");
		System.out.println(FrutaHortalizaS.guardar());
		System.out.println("Mostrando datos guardados de LacteoM:");
		System.out.println(LacteoM.guardar());
		System.out.println("Mostrando datos guardados de LacteoS:");
		System.out.println(LacteoS.guardar());
		System.out.println("Mostrando datos guardados de BebidaM:");
		System.out.println(BebidaM.guardar());
		System.out.println("Mostrando datos guardados de BebidaS:");
		System.out.println(BebidaS.guardar());
		
		// Imprimir
		FrutaHortalizaM.imprimir();
		FrutaHortalizaS.imprimir();
		LacteoM.imprimir();
		LacteoS.imprimir();
		BebidaM.imprimir();
		BebidaS.imprimir();		
	}

}
