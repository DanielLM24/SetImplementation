/**
 * @author Peter Bennett/Daniel Lara
 *
 */

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.TreeSet;

import javax.swing.JOptionPane;


public class Driver {

	public static <E> void main(String[] args) {
		Database<String> organizador = null;
		System.out.println("----------Bienvenido al organizador de desarrolladores.----------\n\n");
		System.out.println("Seleccione el tipo de implementacion que desea utilizar:\n");
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
			menu();
			String area = userInput();
			switch(area){
			case("1"):
				organizador.getJava().add(name);
			break;
			case("2"):
				organizador.getWeb().add(name);
			break;
			case("3"):
				organizador.getMovil().add(name);
			break;
			case("4"):
				organizador.getJava().add(name);
			organizador.getWeb().add(name);
			break;
			case("5"):
				organizador.getJava().add(name);
			organizador.getMovil().add(name);
			break;
			case("6"):
				organizador.getWeb().add(name);
			organizador.getMovil().add(name);
			break;
			case("7"):
				organizador.getWeb().add(name);
			organizador.getMovil().add(name);
			organizador.getJava().add(name);
			break;
			default:
				break;
			}
		}
		interseccion(organizador);
		java_not_web(organizador);
		web_y_movil_no_java(organizador);
		excepto_java(organizador);
		subconjunto(organizador);
		mayor(organizador);
		mayor_ordenado(organizador);
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

	public static void menu(){
		System.out.println("Seleccione el area de experiencia del desarrollador:\n");
		System.out.println("1) Java\n");
		System.out.println("2) Web\n");
		System.out.println("3) Celular\n");
		System.out.println("4) Java y Web\n");
		System.out.println("5) Java y Celular\n");
		System.out.println("6) Web y Celular\n");
		System.out.println("7) Java, Web y Celular\n");
	}

	public static <E> void interseccion(Database<E> organizador){
		ArrayList<E> intersecto = new ArrayList<E>();
		for(E s:organizador.getJava()){
			if(organizador.getMovil().contains(s) && organizador.getWeb().contains(s))
				intersecto.add(s);
		}
		System.out.println("Desarrolladores en los tres conjuntos: \n");
		for(E item:intersecto)
			System.out.println(item + "\n");
	}

	public static <E> void java_not_web(Database<E> organizador){
		ArrayList<E> java_no_web = new ArrayList<E>();
		for(E s:organizador.getJava()){
			if(!organizador.getWeb().contains(s))
				java_no_web.add(s);
		}
		System.out.println("Desarrolladores con experiencia en Java pero no Web: \n");
		for(E item:java_no_web)
			System.out.println(item + "\n");
	}

	public static <E> void web_y_movil_no_java(Database<E> organizador){
		ArrayList<E>  web_y_movil_no_java = new ArrayList<E>();
		for(E s:organizador.getWeb()){
			if(organizador.getMovil().contains(s) && !organizador.getJava().contains(s))
				web_y_movil_no_java.add(s);
		}
		System.out.println("Desarrolladores con experiencia en Web y Celular pero no Java: \n");
		for(E item:web_y_movil_no_java)
			System.out.println(item + "\n");
	}

	public static <E> void excepto_java(Database <E> organizador){
		ArrayList<E>  excepto_java = new ArrayList<E>();
		for(E s:organizador.getWeb()){
			if(!organizador.getJava().contains(s))
				if(!excepto_java.contains(s))
					excepto_java.add(s);
		}
		for(E s:organizador.getMovil()){
			if(!organizador.getJava().contains(s))
				if(!excepto_java.contains(s))
					excepto_java.add(s);
		}
		System.out.println("Desarrolladores sin experiencia en Java: \n");
		for(E item:excepto_java)
			System.out.println(item + "\n");
	}

	public static <E> void subconjunto(Database<E> organizador){
		for(E s:organizador.getJava()){
			if(!organizador.getMovil().contains(s)){
				System.out.println("El conjunto de programadores de Java no es subconjunto de Web.");
				return;
			}
		}
		System.out.println("El conjunto de programadores de Java es un subconjunto de Web.");
	}

	public static <E> void mayor(Database<E> organizador){
		int x = organizador.getJava().size();
		int y = organizador.getWeb().size();
		int z = organizador.getMovil().size();
		int mayor = 0;

		if ( x > y && x > z )
			mayor = 1;
		else if ( y > x && y > z )
			mayor = 2;
		else if ( z > x && z > y )
			mayor = 3;
		else;
		
		switch(mayor){
		case(1):
			System.out.println("Hay mas desarrolladores en Java. Ellos son:\n");
		for(E s:organizador.getJava())
			System.out.println(s + "\n");
			break;
		case(2):
			System.out.println("Hay mas desarrolladores en Web. Ellos son:\n");
		for(E s:organizador.getWeb())
			System.out.println(s + "\n");
			break;
		case(3):
			System.out.println("Hay mas desarrolladores en Celular. Ellos son:\n");
		for(E s:organizador.getMovil())
			System.out.println(s + "\n");
			break;
		default:
			System.out.println("No hay un conjunto mas grande.");
			break;
		}
	}
	
	public static <E> void mayor_ordenado(Database<E> organizador){
		TreeSet<E> ordenado = new TreeSet<E>();
		int x = organizador.getJava().size();
		int y = organizador.getWeb().size();
		int z = organizador.getMovil().size();
		int mayor = 0;

		if ( x > y && x > z )
			mayor = 1;
		else if ( y > x && y > z )
			mayor = 2;
		else if ( z > x && z > y )
			mayor = 3;
		else;
		
		switch(mayor){
		case(1):
			System.out.println("Hay mas desarrolladores en Java. Ellos son (en orden alfabetico):\n");
		for(E s:organizador.getJava())
			ordenado.add(s);
		System.out.println(ordenado.tailSet(ordenado.first(), true));
			break;
		case(2):
			System.out.println("Hay mas desarrolladores en Web. Ellos son (en orden alfabetico):\n");
		for(E s:organizador.getWeb())
			ordenado.add(s);
		System.out.println(ordenado.tailSet(ordenado.first(),true));			
		break;
		case(3):
			for(E s:organizador.getMovil())
				ordenado.add(s);
		System.out.println(ordenado.tailSet(ordenado.first(),true));			
		break;
		default:
			System.out.println("No hay un conjunto mas grande.");
			break;
		}
	}
	
}
