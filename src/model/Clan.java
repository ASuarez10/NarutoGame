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
	
	/**
	 * Constructor of Clan's class
	 * @param name - Clan's name
	 * @param characters - Characters in the clan
	 */
	public Clan(String name, Character characters) {
		this.name = name;
		this.characters = characters;
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

	@Override
	public int compare(Clan o1, Clan o2) {
		return o1.getName().compareToIgnoreCase(o2.getName());
	}

	@Override
	public int compareTo(Clan o) {
		return name.compareToIgnoreCase(o.getName());
	}

	
}//final
