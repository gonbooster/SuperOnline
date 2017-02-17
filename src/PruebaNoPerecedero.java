import java.util.Scanner;


public class PruebaNoPerecedero {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int H=0;
		int O=0;
		// Lectura por teclado.
		Scanner Scan = new Scanner(System.in);
		
		// Objeto Herramienta
		Herramienta HerramientaM = new Herramienta(H,"Martillo",10.0,100,5.5);
		System.out.println("Datos insertados HerramientaM.");
		System.out.println("Insertar datos HerramientaS:");
		Herramienta HerramientaS = new Herramienta(Scan);
		HerramientaS.setCodigo(H+1);
		
		// Objeto Otros
		Otros ObjetoOtrosM = new Otros(O,"TV",50.0,200,10.5,"Buena calidad.");
		System.out.println("Datos insertados OtrosM.");
		System.out.println("Insertar datos OtrosS:");
		Otros ObjetoOtrosS = new Otros(Scan);
		ObjetoOtrosS.setCodigo(O+1);
		
		// Guardar y mostrar guardado
		System.out.println("Mostrando datos guardados de HerramientaM:");
		System.out.println(HerramientaM.guardar());
		System.out.println("Mostrando datos guardados de HerramientaS:");
		System.out.println(HerramientaS.guardar());
		System.out.println("Mostrando datos guardados de ObjetoOtrosM:");
		System.out.println(ObjetoOtrosM.guardar());
		System.out.println("Mostrando datos guardados de ObjetoOtrosS:");
		System.out.println(ObjetoOtrosS.guardar());
		
		// Imprimir
		HerramientaM.imprimir();
		HerramientaS.imprimir();
		ObjetoOtrosM.imprimir();
		ObjetoOtrosS.imprimir();		
	}

}
