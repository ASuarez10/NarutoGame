package model;
import java.util.ArrayList;

public class Principal {

	//Relations
	
	/**
	 * Clan's list
	 */
	private Clan clans;
	
	//Constructor
	
	/**
	 * Constructor of Principal's class
	 */
	public Principal(Clan clans) {
		this.clans = clans;
		init();
	}

	/**
	 * Method to give the ArrayList clans
	 * @return Clan's list
	 */
	public Clan getClans() {
		return clans;
	}

	public void setClans(Clan clans) {
		this.clans = clans;
	}
	
	//addClan
	public String addClan(Clan c) {
		String msj = "";
		
		Clan e = clans;
		
		if(e == null) {
			clans = c;
			msj = "El clan ha sido registrado";
		}else {
			boolean esta = false;
			while(!esta && e.getNext() != null) {
					if(c.getName().equals(e.getName())) {
						esta = true;
						msj = "El clan ya esta registrado";
				}else {
					e = e.getNext();
				}
			}
			if(esta == false) {
				c.setNext(e);
				e.setPrevious(c);
				clans = c;
				msj = "El clan ha sido registrado";
			}
		}
		
		return msj;
	}
	
	//deleteClan
	public String deleteClan(String nameC) {
		String msj = "";
		
		Clan c = clans;
		
		if(clans.getName().equals(nameC)) {
			clans = clans.getNext();
			msj = "El clan ha sido borrado";
		}else {
			boolean esta = false;
			while(!esta && c.getNext() != null) {
				if(c.getNext().getName() == nameC) {
					esta = true;
					Clan sg = c.getNext().getNext();
					c.setNext(sg);
					sg.setPrevious(c);
					msj = "El clan ha sido borrado";
				}else {
					c = c.getNext();
				}
			}
			if(esta == false) {
				msj = "El clan no esta registrado";
			}
		}
		
		return msj;
	}

	public void init() {
		
	}
}//final
