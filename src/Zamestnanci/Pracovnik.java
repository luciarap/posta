package Zamestnanci;

import java.util.ArrayList;

import zasielky.Zasielky;

public class Pracovnik implements Zamestnanec { //LEAF
	
	private String meno;
	private String priezvisko;
	private int ID;
	private double mzda;
	
	private double stavHotovosti = 0;
	String uvazok;

	public double getStavHotovosti() {
		return stavHotovosti;
	}

	public void setStavHotovosti(double stavHotovosti) {
		this.stavHotovosti = stavHotovosti;
	}

	public Pracovnik(String meno, String priezvisko, int ID, String uvazok) {
		this.meno = meno;
		this.priezvisko = priezvisko;
		this.ID = ID;
		this.uvazok = uvazok;
	}


	
	public void predajTovar() {
		
	}
	
	/*public void zapisZasielky(ArrayList<Zasielky> ar, Zasielky zasielka) {
		//zasielka.podacieCislo = generujPodacieCislo();
		ar.add(zasielka);
		System.out.println("Zapisana nova zasielka s podacim cislo: " + zasielka.podacieCislo);
	}*/

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return ID;
	}

	@Override
	public double getMzda() {
		// TODO Auto-generated method stub
		return mzda;
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
		if (uvazok == "cely") mzda = 600;
		if (uvazok == "polovicny") mzda = 300;
		// TODO Auto-generated method stub
		
	}
	
	public void info() {
	       System.out.println("_______________");  
	       System.out.println("ID: "+ getID());  
	       System.out.println("Meno: " + getMeno());  
	       System.out.println("Priezvisko: " + getPriezvisko());  
	       System.out.println("Mzda: " + getMzda());  
	       System.out.println("_______________");  
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

	@Override
	public String toString() {
		return "Pracovnik [meno=" + meno + ", priezvisko=" + priezvisko + ", ID=" + ID + ", mzda=" + mzda + ", uvazok="
				+ uvazok + "]";
	}

	public String getUvazok() {
		return uvazok;
	}

	public void setUvazok(String uvazok) {
		this.uvazok = uvazok;
	}


	

}
