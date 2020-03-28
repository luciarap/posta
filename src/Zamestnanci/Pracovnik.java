package Zamestnanci;

import java.util.ArrayList;

import zasielky.Zasielky;

public class Pracovnik extends Zamestnanci {
	
	private double stavHotovosti = 0;
	String uvazok;

	public double getStavHotovosti() {
		return stavHotovosti;
	}

	public void setStavHotovosti(double stavHotovosti) {
		this.stavHotovosti = stavHotovosti;
	}

	public Pracovnik(String meno, String priezvisko, String uvazok) {
		super(meno, priezvisko);
		this.uvazok = uvazok;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pridelVyplatu() {
		if (uvazok == "cely") setMzda(600);
		if (uvazok == "polovicny") setMzda(300);
		else System.out.println("Pracovnik nema kompletne nastavenia");
	}
	
	public void predajTovar() {
		
	}
	
	public void zapisZasielky(ArrayList<Zasielky> ar, Zasielky zasielka) {
		zasielka.podacieCislo = generujPodacieCislo();
		ar.add(zasielka);
		System.out.println("Zapisana nova zasielka s podacim cislo: " + zasielka.podacieCislo);
	}

}
