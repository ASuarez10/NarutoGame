package model;

import java.io.Serializable;
import java.util.Comparator;

public class Technique implements Comparable<Technique>, Comparator<Technique>, Serializable{

	//Attributes
	/**
	 * Technique's name
	 */
	private String name;
	/**
	 * Technique's factor
	 */
	private String factor;
	
	//Relations
	
	/**
	 * Next technique in the list
	 */
	private Technique next;

	/**
	 * Constructor of Technique's class
	 * @param name - Technique's name
	 * @param factor - Technique's factor
	 * @param next - next technique in the list
	 */
	public Technique(String name, String factor, Technique next) {
		this.name = name;
		this.factor = factor;
		this.next = next;
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
	 * Method to give the attribute factor
	 * @return factor
	 */
	public String getFactor() {
		return factor;
	}

	public void setFactor(String factor) {
		this.factor = factor;
	}

	/**
	 * Method to give the next object
	 * @return next Technique in the list
	 */
	public Technique getNext() {
		return next;
	}

	public void setNext(Technique next) {
		this.next = next;
	}

	@Override
	public int compare(Technique o1, Technique o2) {
		return o1.getName().compareToIgnoreCase(o2.getName());
	}

	@Override
	public int compareTo(Technique o) {
		return name.compareToIgnoreCase(o.getName());
	}

	@Override
	public String toString() {
		return "Technique [name=" + name + ", factor=" + factor + ", next=" + next + "]";
	}
	
	
}//final
