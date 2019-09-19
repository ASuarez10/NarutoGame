package model;

import java.io.Serializable;
import java.util.Comparator;

public class Technique implements Comparable<Technique>, Comparator<Technique>, Serializable{

	//Attributes
	private String name;
	private String factor;
	
	//Relations
	private Technique next;

	public Technique(String name, String factor, Technique next) {
		this.name = name;
		this.factor = factor;
		this.next = next;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFactor() {
		return factor;
	}

	public void setFactor(String factor) {
		this.factor = factor;
	}

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
	
}//final
