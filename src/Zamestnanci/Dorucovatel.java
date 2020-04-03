package Zamestnanci;

import java.util.ArrayList;

import zasielky.Zasielky;

public class Dorucovatel implements Zamestnanec { //LEAF
	private String meno;
	private String priezvisko;
	private int ID;
	private double mzda;
	
	private double stavHotovosti = 0;

	public double getStavHotovosti() {
		return stavHotovosti;
	}

	public void setStavHotovosti(double stavHotovosti) {
		this.stavHotovosti = stavHotovosti;
	}

	public Dorucovatel(String meno, String priezvisko, int ID) {
		this.meno = meno;
		this.priezvisko = priezvisko;
		this.ID = ID;
	}

	/*public void pridelVyplatu() {
		setMzda(700);
	}*/
	
	public void odpisZasielky(ArrayList<Zasielky> ar, Zasielky zasielka) {
		ar.remove(zasielka);
		System.out.println("Zasielka bola dorucena.");
	}
	
	public void Dorucit(Zasielky zasielka) {
		zasielka.jeDorucena = true;
		odpisZasielky(ar, zasielka);
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return ID;
	}

	@Override
	public void add(Zamestnanec zamestnanec) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void odstranZamestnanca(Zamestnanec zamestnanec) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dostanVyplatu() {
		mzda = 650;
		
	}

	@Override
	public double getMzda() {
		// TODO Auto-generated method stub
		return mzda;
	}

	@Override
	public String getMeno() {
		// TODO Auto-generated method stub
		return meno;
	}

	@Override
	public String getPriezvisko() {
		// TODO Auto-generated method stub
		return priezvisko;
	}
	
	public void info() {
	       System.out.println("_______________");  
	       System.out.println("ID: "+ getID());  
	       System.out.println("Meno: " + getMeno());  
	       System.out.println("Priezvisko: " + getPriezvisko());  
	       System.out.println("Mzda: " + getMzda());  
	       System.out.println("_______________");  
	}

	

}
