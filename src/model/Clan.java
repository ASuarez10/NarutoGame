package model;

import java.io.Serializable;
import java.util.Comparator;

public class Clan implements Comparable<Clan>, Comparator<Clan>, Serializable{

	//Attributes
	private String name;
	
	//Relations
	private Character characters;
	
	public Clan(String name, Character characters) {
		this.name = name;
		this.characters = characters;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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
