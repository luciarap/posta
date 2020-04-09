package Posta;


import Zamestnanci.Dorucovatel;
import Zamestnanci.Pracovnik;
import Zamestnanci.VeduciPosty;
import Zamestnanci.Zamestnanec;
import tovary.Casopisy;
import tovary.Znamky;
import tovary.Znamky.DruhZnamok;
import tovary.Casopisy.DruhCasopisov;


public class Posta {
	static double stavHotovosti;

	
	//static ArrayList<Zasielky> ar = new ArrayList<Zasielky>();
	//static ArrayList<Tovary> ar2 = new ArrayList<Tovary>();
	

	public static void main(String[] args) {

		Zamestnanec dorucovatel1 = new Dorucovatel("Eva", "Benkova", 4579);
		Zamestnanec pracovnik1 = new Pracovnik("Klaudia", "Novakova", 4580, "cely");
		Zamestnanec pracovnik2 = new Pracovnik("Peter", "Simko", 4581,"polovicny");
		Zamestnanec veduci1 = new VeduciPosty("Jana", "Horvathova", 4578);
		veduci1.add(dorucovatel1);
		veduci1.add(pracovnik2);
		veduci1.add(pracovnik1);
		veduci1.dostanVyplatu(); //vsetci dostanu vyplatu
		veduci1.info();
		Znamky znamkyT2 = new Znamky("ZnamkyT2", 100, DruhZnamok.T2);
		Znamky znamkyT1 = new Znamky("ZnamkyT1", 100, DruhZnamok.T1);
		Casopisy GEO = new Casopisy("Geo", 5, DruhCasopisov.Geo);
		stavHotovosti = znamkyT2.predatTovar(znamkyT2, 5, stavHotovosti);
		stavHotovosti = znamkyT1.predatTovar(znamkyT1, 5, stavHotovosti);
		stavHotovosti = GEO.predatTovar(GEO, 1, stavHotovosti);
		System.out.println(GEO.getPocet());
		System.out.println(stavHotovosti);
	
	}


}
