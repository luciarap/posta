package Zamestnanci;

import java.util.ArrayList;

import javafx.geometry.Insets;
import zasielky.Zasielky;

public class VeduciPosty extends Zamestnanci {
	
	private static double stavHotovostiNaPracovisku = 10000;
	//static ArrayList<Zasielky> ar = new ArrayList<Zasielky>();

	public VeduciPosty(String meno, String priezvisko) {
		super(meno, priezvisko);
		// TODO Auto-generated constructor stub
	}
	//spravit Zapis metody pre rozne zasielky, radio button
	public Zasielky zapisZasielku(String podacieCislo, String meno, String priezvisko, String ulica, int cislo, int psc, String Mesto) { //test
		Zasielky zasielka = new Zasielky(meno, priezvisko, ulica, cislo, psc, Mesto);
		zasielka.podacieCislo = podacieCislo;
		//zasielka.podacieCislo = generujPodacieCislo();
		ar.add(zasielka);
		
		System.out.println("Zapisana nova zasielka s podacim cislo: " + zasielka.podacieCislo);
		
		for(Zasielky i : ar){
			System.out.println(i);
		}
		
		return zasielka;
	}
	
	public void pridelPeniaze(Zamestnanci zamestnanec, double suma) {
		if (zamestnanec instanceof Dorucovatel) {
			if (stavHotovostiNaPracovisku > suma) {
				((Dorucovatel) zamestnanec).setStavHotovosti(suma);
				System.out.println(((Dorucovatel) zamestnanec).getStavHotovosti());
			}
		}
		
		if (zamestnanec instanceof Pracovnik) {
			if (stavHotovostiNaPracovisku > suma) {
				((Pracovnik) zamestnanec).setStavHotovosti(suma);
				System.out.println(((Pracovnik) zamestnanec).getStavHotovosti());
			}
		}	
	}

	@Override
	public void pridelVyplatu() {
		setMzda(800);
		
	}

	
	//veduci objedna tovar, ak je ho malo

}
