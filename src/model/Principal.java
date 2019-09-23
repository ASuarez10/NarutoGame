package model;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

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
			if(clans.getName().equals(c.getName())) {
				msj = "El personaje ya esta registrado";
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
		}
		
		return msj;
	}
	
	//deleteClan
	public String deleteClan(String nameC) {
		String msj = "";
		
		Clan c = clans;
		
		if(clans == null) {
			msj = "El clan no esta registrado";
		}else {	
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
		}
		return msj;
	}

	//addCharacter
	public String addCharacter(String nCl, Character ch) {
		String msj = "";
		
		if(clans == null) {
			msj = "El clan no esta registrado";
		}else {
			if(clans.getName().equals(nCl)) {
				msj = clans.addCharacter(ch);
			}else {
				boolean esta = false;
				Clan temp = clans;
				while(!esta && temp.getNext() != null) {
					if(temp.getName().equals(nCl)) {
						esta = true;
						msj = temp.addCharacter(ch);
					}else {
						temp = temp.getNext();
					}
				}
				if(esta == false) {
					msj = "El clan no esta registrado";
				}
			}
		}
		
		return msj;
	}
	
	//deleteCharacter
	
	public String deleteCharacter(String nCL, String nameCh) {
		String msj = "";
		
		if(clans == null) {
			msj = "El clan no esta gregado";
		}else {
			if(clans.getName().equals(nCL)) {
				msj = clans.deleteCharacter(nameCh);
			}else {
				boolean esta = false;
				Clan temp = clans;
				while(!esta && temp.getNext() != null) {
					if(temp.getName().equals(nCL)) {
						esta = true;
						msj = temp.deleteCharacter(nameCh);
					}else {
						temp = temp.getNext();
					}
				}
				if(esta == false) {
					msj = "El clan no esta registrado";
				}
			}
		}
		
		return msj;
	}
	
	//addTechnique
	public String addTechnique(String nT, String cN, Technique t) {
		String msj = "";
		
		if(clans == null) {
			msj = "El clan no esta registrado";
		}else {
			if(clans.getName().equals(nT)) {
				msj = clans.addTechnique(cN, t);
			}else {
				boolean esta = false;
				Clan temp = clans;
				while(!esta && temp.getNext() != null) {
					if(temp.getName().equals(nT)) {
						esta = true;
						msj = temp.addTechnique(cN, t);
					}else {
						temp = temp.getNext();
					}
				}
				if(esta == false) {
					msj = "El clan no esta registrado";
				}
			}
		}
		
		return msj;
	}
	
	//deleteTechnique
	public String deleteTechnique(String nTD, String cN1, String nameT) {
		String msj = "";
		
		if(clans == null) {
			msj = "El clan no esta gregado";
		}else {
			if(clans.getName().equals(nTD)) {
				msj = clans.deleteTechnique(cN1, nameT);
			}else {
				boolean esta = false;
				Clan temp = clans;
				while(!esta && temp.getNext() != null) {
					if(temp.getName().equals(nTD)) {
						esta = true;
						msj = temp.deleteTechnique(cN1, nameT);
					}else {
						temp = temp.getNext();
					}
				}
				if(esta == false) {
					msj = "El clan no esta registrado";
				}
			}
		}
		
		return msj;
	}
	
	//serializeClans
	public void serializeClans() {
		File f = new File("files/SerializedArchive");
		Vector v = new Vector();
		ObjectOutputStream oos;
		ObjectInputStream ois;
		
		v.add(clans);
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream(f));
			oos.writeObject(v);
			oos.close();
		}catch(IOException e){	
		}
		try {
			ois = new ObjectInputStream(new FileInputStream(f));
			v = (Vector)ois.readObject();
		}catch(ClassNotFoundException ex) {
			Logger.getLogger(Clan.class.toString()).log(Level.SEVERE, null, ex);
		}catch(IOException e) {			
		}catch(ArrayIndexOutOfBoundsException ae) {
			System.out.println(ae.getMessage());
		}
	}
	public void init() {
		
	}
}//final
