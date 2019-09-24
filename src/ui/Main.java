package ui;
import model.*;
import model.Character;

import java.util.Scanner;

import exceptions.InvalidInputException;

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
          System.out.println("8. Buscar");
          System.out.println("-----------------------------------------------------------------");
          System.out.println("9. Salir");
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
            	  System.out.println("Ingresa el nombre del club");
            	  String nCl = reader.nextLine();
            	  
            	  System.out.println("Ingresa el nombre del personaje");
            	  String n1 = reader.nextLine();
            	  
            	  System.out.println("Ingresa la personalidad");
            	  String p1 = reader.nextLine();
            	  
            	  System.out.println("Ingresa la fecha de creacion");
            	  String cd1 = reader.nextLine();
            	  
            	  System.out.println("Ingresa el poder");
            	  long pw1 = reader.nextLong();
            	  
            	  Character ch = new Character(n1, p1, cd1, pw1, null, null, null);
            	  
            	  System.out.println(principal.addCharacter(nCl, ch));
            	  
            	 break;
              case 3:
            	  System.out.println("Ingresa el nombre del clan");
            	  String nT = reader.nextLine();
            	  
            	  System.out.println("Ingresa el nombre del personaje");
            	  String cN = reader.nextLine();
            	  
            	  System.out.println("Ingresa el nombre de la tecnica");
            	  String n2 = reader.nextLine();
            	  
            	  System.out.println("Ingresa el factor que influye en el poder");
            	  String f2 = reader.nextLine();
            	  
            	  Technique t = new Technique(n2, f2, null);
            	  
            	  System.out.println(principal.addTechnique(nT, cN, t));
            	 break;
              case 4:
            	  System.out.println("Ingrese el nombre del clan a borrar");
            	  String nameC = reader.nextLine();
            	  
            	  System.out.println(principal.deleteClan(nameC));
            	 break;
              case 5:
            	  System.out.println("Ingresa el nombre del clan donde esta el personaje");
            	  String nCL = reader.nextLine();
            	  
            	  System.out.println("Ingresa el nombre del personaje a borrar");
            	  String nameCh = reader.nextLine();
            	  
            	  System.out.println(principal.deleteCharacter(nCL, nameCh));
            	 break;
              case 6:
            	  System.out.println("Ingresa el nombre del clan");
            	  String nTD = reader.nextLine();
            	  
            	  System.out.println("Ingresa el nombre del personaje");
            	  String cN1 = reader.nextLine();
            	  
            	  System.out.println("Ingresa el nombre de la tecnica a borrar");
            	  String nameT = reader.nextLine();
            	  
            	  System.out.println(principal.deleteTechnique(nTD, cN1, nameT));
            	 break;
              case 7:
            	  principal.serializeClans();
            	  System.out.println("Archivo serializado creado");
            	 break;
              case 8:
            	  System.out.println("Ingresa: \n "
            	  		+ "1. Para buscar un clan \n"
            	  		+ "2. Para buscar un personaje \n"
            	  		+ "3. Para buscar una tecnica");
            	  int selection = reader.nextInt();
            	  
            	  try {
            		  if(selection < 1 || selection > 3) {
            			throw new InvalidInputException("El valor ingresado es incorrecto");  
            		  }
            	  }catch(Exception e) {
            		  System.out.println(e.getMessage());
            	  }
            	  
            	  if(selection == 1) {
            		  System.out.println("Ingresa el nombre del clan");
            		  reader.nextLine();
            		  String snC = reader.nextLine();
            		  
            		  System.out.println(principal.searchClan(snC));
            	  }else if(selection == 2) {
            		  System.out.println("Ingresa el nombre del clan");
            		  reader.nextLine();
            		  String snC1 = reader.nextLine();
            		  
            		  System.out.println("Ingresa el nombre del personaje");
            		  String snCh = reader.nextLine();
            		  
            		  System.out.println(principal.searchCharacter(snC1, snCh));
            	  }else if(selection == 3) {
            		  System.out.println("Ingresa el nombre del clan");
            		  reader.nextLine();
            		  String snC2 = reader.nextLine();
            		  
            		  System.out.println("Ingresa el nombre del personaje");
            		  String snCh1 = reader.nextLine();
            		  
            		  System.out.println("Ingresa el nombre de la tecnica");
            		  String snt = reader.nextLine();
            		  
            		  System.out.println(principal.searchTechnique(snC2, snCh1, snt));
            	  }
            	 break;
            	 
          }
        }while(a != 9);
		
	}

	private void init() {
	
		Technique a2 = new Technique("Rasengan", "Viento", null); 
		Technique a1 = new Technique("Chidori", "Rayo", a2);	
		Character ch1 = new Character("Naruto", "Hiperactivo", "10 de mayo de 2001", 1000, null, null, a1);
		Clan c1 = new Clan("Uzumaki", ch1, null, null);
		
		principal = new Principal(c1);
	}

}//final
