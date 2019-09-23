package model;

import java.io.Serializable;
import java.util.Comparator;

public class Character implements Comparable<Character>, Comparator<Character>, Serializable{

	//Attributes
	
	/**
	 * Character's name
	 */
	private String name;
	/**
	 * Character's last name
	 */
	private String lastName;
	/**
	 * Character's personality
	 */
	private String personality;
	/**
	 * Character's creation date
	 */
	private String creationDate;
	/**
	 * Character's power
	 */
	private long power;
	
	//Relations
	
	/**
	 * Previous character in the list
	 */
	private Character previous;
	/**
	 * Next character in the list
	 */
	private Character next;
	/**
	 * Character's techniques
	 */
	private Technique techniques;
	
	//Constructor
	
	/**
	 * Constructor of Character's class
	 * @param name - Character's name
	 * @param lastName - Character's last name
	 * @param personality - Character's personality
	 * @param creationDate - Character's creation date
	 * @param power - Character's power
	 * @param previous - previous character in the list
	 * @param next - next character in the list
	 * @param techniques - Technique's list
	 */
	public Character(String name, String lastName, String personality, String creationDate, long power, Character previous,	
			Character next, Technique techniques) {
		this.name = name;
		this.lastName = lastName;
		this.personality = personality;
		this.creationDate = creationDate;
		this.power = power;
		this.previous = previous;
		this.next = next;
		this.techniques = techniques;
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
	 * Method to give the attribute lastName
	 * @return last name
	 */
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Method to give the attribute personality
	 * @return personality
	 */
	public String getPersonality() {
		return personality;
	}

	public void setPersonality(String personality) {
		this.personality = personality;
	}

	/**
	 * Method to give the attribute creationDate
	 * @return creation date
	 */
	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * Method to give the attribute power
	 * @return power
	 */
	public long getPower() {
		return power;
	}

	public void setPower(long power) {
		this.power = power;
	}

	/**
	 * Method to give the previous object
	 * @return previous character in the list
	 */
	public Character getPrevious() {
		return previous;
	}

	public void setPrevious(Character previous) {
		this.previous = previous;
	}

	/**
	 * Method to give the next technique
	 * @return next technique in the list
	 */
	public Character getNext() {
		return next;
	}

	public void setNext(Character next) {
		this.next = next;
	}

	/**
	 * Method to give character's techniques
	 * @return character's techniques
	 */
	public Technique getTechniques() {
		return techniques;
	}

	public void setTechniques(Technique techniques) {
		this.techniques = techniques;
	}

	@Override
	public int compare(Character o1, Character o2) {
		return o1.getName().compareToIgnoreCase(o2.getName());
	}

	@Override
	public int compareTo(Character o) {
		return name.compareToIgnoreCase(o.getName());
	}

	//addTechnique
	public String addCharacter(Technique t) {
		String msj = "";
		
		if(techniques == null) {
			techniques = t;
		}else {
			Technique temp = techniques;
			boolean esta = false;
			while(!esta && temp.getNext() != null) {
				if(temp.getName().equals(t.getName())) {
					esta = true;
					msj = "El personaje ya esta agregado";
				}else {
					temp = temp.getNext();
				}
			}
			if(esta == false) {
				temp.setNext(techniques);
				techniques = temp;
				msj = "El clan ha sido agregado";
			}
		}
		
		return msj;
	}
	
	//deleteTechnique
	public String deleteTechnique(String nameT) {
		String msj = "";
		
		Technique t = techniques;
		
		if(techniques.getName().equals(nameT)) {
			techniques = techniques.getNext();
			msj = "El personaje ha sido borrado";
		}else {
			boolean esta = false;
			while(!esta && t.getNext() != null) {
				if(t.getNext().getName() == nameT) {
					esta = true;
					Technique sg = t.getNext().getNext();
					t.setNext(sg);
					msj = "El personaje ha sido borrado";
				}else {
					t = t.getNext();
				}
			}
			if(esta == false) {
				msj = "El personaje no esta registrado";
			}
		}
		
		return msj;
	}
	
}//final
