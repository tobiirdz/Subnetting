import java.util.Scanner;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		//System.out.println("ingrese direccion ip: ");
		//String ip = entrada.nextLine();
		//System.out.println("ingrese mascara: ");
		//int mascara = entrada.nextInt();
		//System.out.println("ingrese numero de host separados por coma: ");
		//String host = entrada.nextLine();
		
		Subnet red = new Subnet();
		
		System.out.println(red);
	}
	
	public static void claseRed(Subnet r) {
		char clase = r.claseRed();
		switch(clase) {
		case Subnet.claseA:
			System.out.println("Es clase A");
			break;
		case Subnet.claseB:
			System.out.println("Es clase B");
			break;
		case Subnet.claseC:
			System.out.println("Es Clase C");
			break;
		case Subnet.claseD:
			System.out.println("Es clase D");
			break;
		}
	}
}
