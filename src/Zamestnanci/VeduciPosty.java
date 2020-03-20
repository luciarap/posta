package Zamestnanci;

import java.util.ArrayList;
import zasielky.Zasielky;

public class VeduciPosty extends Zamestnanci {

	public VeduciPosty(String meno, String priezvisko) {
		super(meno, priezvisko);
		// TODO Auto-generated constructor stub
	}
	
	public String generujPodacieCislo() {
		return "RE" + generovatCislo() + "SK";
	}
	
	public static long generovatCislo() {
	    final long leftLimit = 000000000 ; //final
	    final long rightLimit = 999999999;
	    long cislo = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
	    return cislo;
	}
	
	public void zapisZasielky(ArrayList<Zasielky> ar, Zasielky zasielka) {
		zasielka.podacieCislo = generujPodacieCislo();
		ar.add(new Zasielky());
		System.out.println("Zapisana nova zasielka s podacim cislo: " + zasielka.podacieCislo);
		
	}

}
