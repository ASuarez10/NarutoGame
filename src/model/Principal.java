package model;
import java.util.ArrayList;

public class Principal {

	//Relations
	
	private ArrayList<Clan> clans;
	
	public Principal() {
		clans = new ArrayList<Clan>();
	}

	public ArrayList<Clan> getClans() {
		return clans;
	}

	public void setClans(ArrayList<Clan> clans) {
		this.clans = clans;
	}

}//final
