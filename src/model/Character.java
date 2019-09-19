package model;

import java.io.Serializable;
import java.util.Comparator;

public class Character implements Comparable<Character>, Comparator<Character>, Serializable{

	//Attributes
	private String name;
	private String personality;
	private String creationDate;
	private long power;
	
	//Relations
	private Character previous;
	private Character next;
	private Technique techniques;
	
	//Constructor
	public Character(String name, String personality, String creationDate, long power, Character previous,	
			Character next, Technique techniques) {
		this.name = name;
		this.personality = personality;
		this.creationDate = creationDate;
		this.power = power;
		this.previous = previous;
		this.next = next;
		this.techniques = techniques;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPersonality() {
		return personality;
	}

	public void setPersonality(String personality) {
		this.personality = personality;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public long getPower() {
		return power;
	}

	public void setPower(long power) {
		this.power = power;
	}

	public Character getPrevious() {
		return previous;
	}

	public void setPrevious(Character previous) {
		this.previous = previous;
	}

	public Character getNext() {
		return next;
	}

	public void setNext(Character next) {
		this.next = next;
	}

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

	
}//final
