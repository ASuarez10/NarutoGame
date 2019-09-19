package model;
import java.util.ArrayList;

public class Principal {

	//Relations
	
	/**
	 * Clan's list
	 */
	private ArrayList<Clan> clans;
	
	//Constructor
	
	/**
	 * Constructor of Principal's class
	 */
	public Principal() {
		clans = new ArrayList<Clan>();
		init();
	}

	/**
	 * Method to give the ArrayList clans
	 * @return Clan's list
	 */
	public ArrayList<Clan> getClans() {
		return clans;
	}

	public void setClans(ArrayList<Clan> clans) {
		this.clans = clans;
	}
	
	//addClan
	public String addClan(Clan c) {
		String msj = "El clan ya esta registrado";
		boolean esta = false;
		
		for(int i = 0; i < clans.size() && !esta; i++) {
			if(c.getName().equals(clans.get(i).getName())) {
				esta = true;
			}else {
				clans.add(c);
				msj = "El nuevo clan ha sido registrado";
			}
		}
		
		return msj;
	}

	public void init() {
		Clan s = new Clan("Uchiha", null);
		clans.add(s);
	}
}//final
