package model;

import java.io.Serializable;
import java.util.Comparator;

public class Clan implements Comparable<Clan>, Comparator<Clan>, Serializable{

	//Attributes
	/**
	 * Clan's name
	 */
	private String name;
	
	//Relations
	/**
	 * Characters in the clan
	 */
	private Character characters;
	
	private Clan next, previous;
	
	/**
	 * Constructor of Clan's class
	 * @param name - Clan's name
	 * @param characters - Characters in the clan
	 */
	public Clan(String name, Character characters, Clan next, Clan previous) {
		this.name = name;
		this.characters = characters;
		this.next = next;
		this.previous = previous;
	}

	/**
	 * Method to give the attribute name
	 * @return name
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Method to give the attribute characters
	 * @return character's list of the clan
	 */
	public Character getCharacters() {
		return characters;
	}

	public void setCharacters(Character characters) {
		this.characters = characters;
	}
	
	public Clan getNext() {
	return next;
	}
	
	public void setNext(Clan next) {
		this.next = next;
	}
	
	public Clan getPrevious() {
		return previous;
		}
		
	public void setPrevious(Clan previous) {
			this.previous = previous;
	}
	
	@Override
	public int compare(Clan o1, Clan o2) {
		return o1.getName().compareToIgnoreCase(o2.getName());
	}

	@Override
	public int compareTo(Clan o) {
		return name.compareToIgnoreCase(o.getName());
	}
	
	//addCharacter
	public String addCharacter(Character ch) {
		String msj = "";
		
		if(characters == null) {
			characters = ch;
		}else {
			if(characters.getName().equals(ch.getName())) {
				msj = "El personaje ya esta registrado";
			}else {
				Character temp = characters;
				boolean esta = false;
				while(!esta && temp != null) {
					if(temp.getName().equals(ch.getName())) {
						esta = true;
						msj = "El personaje ya esta agregado";
					}else {
						temp = temp.getNext();
					}
				}
				
				if(esta == false) {
					temp.setNext(characters);
					characters.setPrevious(temp);
					characters = temp;
					msj = "El personaje ha sido agregado";
				}
			}		
		}
			
		
		return msj;
	}

	//deleteCharacter
	public String deleteCharacter(String nameCh) {
		String msj = "";
		
		Character ch = characters;
		
		if(characters == null) {
			msj = "El clan no esta registrado";
		}else {
		
			if(characters.getName().equals(nameCh)) {
				characters = characters.getNext();
				msj = "El personaje ha sido borrado";
			}else {
				boolean esta = false;
				while(!esta && ch != null) {
					if(ch.getNext().getName() == nameCh) {
						esta = true;
						Character sg = ch.getNext().getNext();
						ch.setNext(sg);
						sg.setPrevious(ch);
						msj = "El personaje ha sido borrado";
					}else {
						ch = ch.getNext();
					}
				}
				if(esta == false) {
					msj = "El personaje no esta registrado";
				}
			}
		}
		
		return msj;
	}
	
	//addTechnique
	public String addTechnique(String cN, Technique t) {
		String msj = "";
		
		if(characters == null) {
			msj = "El personaje no esta registrado";
		}else {
			if(characters.getName().equals(cN)) {
				msj = characters.addTechnique(t);
			}else {
				boolean esta = false;
				Character temp = characters;
				while(!esta && temp != null) {
					if(temp.getName().equals(cN)) {
						esta = true;
						msj = temp.addTechnique(t);
					}else {
						temp = temp.getNext();
					}
				}
				if(esta == false) {
					msj = "El personaje no esta registrado";
				}
			}
		}
		
		return msj;
	}
	
	//deleteTechnique
	public String deleteTechnique(String cN1, String nameT) {
		String msj = "";
		
		if(characters == null) {
			msj = "El personaje no esta gregado";
		}else {
			if(characters.getName().equals(cN1)) {
				msj = characters.deleteTechnique(nameT);
			}else {
				boolean esta = false;
				Character temp = characters;
				while(!esta && temp != null) {
					if(temp.getName().equals(cN1)) {
						esta = true;
						msj = temp.deleteTechnique(nameT);
					}else {
						temp = temp.getNext();
					}
				}
				if(esta == false) {
					msj = "El personaje no esta registrado";
				}
			}
		}
		
		return msj;
	}

	@Override
	public String toString() {
		return "Clan [name=" + name + ", characters=" + characters + ", next=" + next + ", previous=" + previous + "]";
	}
	
	//searchCharacter
	public String searchCharacter(String snCh) {
		String msj = "";
		
		if(characters == null) {
			msj= "El personaje no esta agregado";
		}else {
			if(characters.getName().equals(snCh)) {
				msj = "El personaje ya esta registrado";
			}else {
				Character temp = characters;
				boolean esta = false;
				while(!esta && temp != null) {
					if(temp.getName().equals(snCh)) {
						esta = true;
						msj = "El personaje ya esta agregado";
					}else {
						temp = temp.getNext();
					}
				}
				
				if(esta == false) {
					msj = "El personaje no esta agregado";
				}
			}		
		}	
		return msj;
	}
	
	//searchTechnique
	public String searchTechnique(String snCh1, String snt) {
		String msj = "";
		
		if(characters == null) {
			msj= "El personaje no esta agregado";
		}else {
			if(characters.getName().equals(snCh1)) {
				msj = characters.searchTechnique(snt);
			}else {
				Character temp = characters;
				boolean esta = false;
				while(!esta && temp != null) {
					if(temp.getName().equals(snCh1)) {
						esta = true;
						msj = temp.searchTechnique(snt);
					}else {
						temp = temp.getNext();
					}
				}
				
				if(esta == false) {
					msj = "El personaje no esta agregado";
				}
			}		
		}	
		return msj;
	}
	
}//final
