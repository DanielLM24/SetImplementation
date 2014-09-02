import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class Driver {

	public static <E> void main(String[] args) {
		Database<String> organizador = null;
		System.out.println("----------Bienvenido al organizador de desarrolladores.----------\n\n");
		System.out.println("Seleccion el tipo de implementacion que desea utilizar:\n");
		System.out.println("1) HashSet\n");
		System.out.println("2) LinkedHashSet\n");
		System.out.println("3) TreeSet\n");
		String entrada = userInput();
		switch(entrada){
		case("1"):
			organizador = new Database<String>("HashSet");
		break;
		case("2"):
			organizador = new Database<String>("LinkedHashSet");
		break;
		case("3"):
			organizador = new Database<String>("TreeSet");
		break;
		default:
			break;
		}
		for(int i = 0; i < 10; i++){
			System.out.println("Ingrese un nombre: \n");
			String name = userInput();
			organizador.getJava().add(name);
		}

	}

	public static String userInput(){
		/**
		 * Scanner for user input.
		 */
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		/**
		 * Variable to store user input.
		 */
		String entrada="";
		try{
			entrada = in.next();
		}
		catch(InputMismatchException e){
			JOptionPane.showMessageDialog(null, "Ingreso invalido", "ERROR", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		return entrada;
	}

}
