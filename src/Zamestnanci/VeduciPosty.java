package Zamestnanci;

import java.util.ArrayList;
import zasielky.Zasielky;

public class VeduciPosty extends Zamestnanci {
	
	private static double stavHotovostiNaPracovisku = 10000;

	public VeduciPosty(String meno, String priezvisko) {
		super(meno, priezvisko);
		// TODO Auto-generated constructor stub
	}
	
	public void zapisZasielky(ArrayList<Zasielky> ar, Zasielky zasielka) {
		zasielka.podacieCislo = generujPodacieCislo();
		ar.add(zasielka);
		System.out.println("Zapisana nova zasielka s podacim cislo: " + zasielka.podacieCislo);
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
