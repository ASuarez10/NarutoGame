package ui;
import model.*;
import java.util.Scanner;

public class Main {

	private Scanner reader;
	private Principal principal;
	
	public Main() {
		
		init();
	      reader = new Scanner(System.in);
	}

	public static void main(String[] args) {
		Main m = new Main ();
        m. showMessageExample();
	}
	
	private void showMessageExample() {
		System.out.println("-----------------------------------------------------------");
        System.out.println("--------------------Club de mascotas-----------------------");
        System.out.println("-----------------------------------------------------------");
        int a;
        Scanner Menu = new Scanner(System.in);

        do{
          System.out.println("-----------------Introduce una opcion valida---------------------");
          System.out.println("-----------------------------------------------------------------");
          System.out.println("1. Crear un clan");
          System.out.println("-----------------------------------------------------------------");
          System.out.println("2. Crear un personaje");
          System.out.println("-----------------------------------------------------------------");
          System.out.println("3. Crear una tecnica");
          System.out.println("-----------------------------------------------------------------");
          System.out.println("4. Borrar un clan");
          System.out.println("-----------------------------------------------------------------");
          System.out.println("5. Borrar un personaje");
          System.out.println("-----------------------------------------------------------------");
          System.out.println("6. Borrar una tecnica");
          System.out.println("-----------------------------------------------------------------");
          System.out.println("7. Generar archivo serializado con la informacion de todos los clanes");
          System.out.println("-----------------------------------------------------------------");

          a = Menu.nextInt();



          switch (a){
              case 1:
            	  System.out.println("Ingresa el nombre del clan");
            	  String nC = reader.nextLine();
            	  
            	  Clan c = new Clan(nC, null, null, null);
            	  System.out.println(principal.addClan(c));
            	 break;
              case 2:
            	 break;

              case 3:
            	 break;
              case 4:
            	  System.out.println("Ingrese el nombre del clan a borrar");
            	  String nameC = reader.nextLine();
            	  
            	  System.out.println(principal.deleteClan(nameC));
            	 break;
              case 5:
            	 break;
              case 6:
            	 break;
              case 7:
            	 break;

          }
        }while(a != 8);
		
	}

	private void init() {
		// TODO Auto-generated method stub
		
	}

}//final
