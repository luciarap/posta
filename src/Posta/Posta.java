package Posta;


import Exceptions.ZleUdajeException;
import hotovost.ManazerHotovosti;
import tovary.Zreby;

/**
 * @deprecated priebehalo tu konzolové testovanie, keïže sa používa GUI, tento main sa už nepoužíva
 */
public class Posta {
	//static double stavHotovosti = 100;
	static double suma  = 50;

	
	//static ArrayList<Zasielky> ar = new ArrayList<Zasielky>();
	//static ArrayList<Tovary> ar2 = new ArrayList<Tovary>();
	

	public static void main(String[] args) throws ZleUdajeException {

		/*Zamestnanec dorucovatel1 = new Dorucovatel("Eva", "Benkova", 4579);
		Zamestnanec pracovnik1 = new Pracovnik("Klaudia", "Novakova", 4580, "cely");
		Zamestnanec pracovnik2 = new Pracovnik("Peter", "Simko", 4581,"polovicny");
		Zamestnanec veduci1 = new VeduciPosty("Jana", "Horvathova", 4578);
		veduci1.add(dorucovatel1);
		veduci1.add(pracovnik2);
		veduci1.add(pracovnik1);
		veduci1.dostanVyplatu(); //vsetci dostanu vyplatu
		veduci1.info();
		Znamky znamkyT2 = new Znamky("ZnamkyT2", 100, "T2");
		Znamky znamkyT1 = new Znamky("ZnamkyT1", 100, "T1");
		Casopisy GEO = new Casopisy("Geo", 5, "GEO");
		stavHotovosti = znamkyT2.predatTovar(znamkyT2, 5, stavHotovosti);
		stavHotovosti = znamkyT1.predatTovar(znamkyT1, 5, stavHotovosti);
		stavHotovosti = GEO.predatTovar(GEO, 1, stavHotovosti);
		System.out.println(GEO.getPocet());
		System.out.println(stavHotovosti);
		*/
		/*ManazerHotovosti manazer = new ManazerHotovosti();
		ManageMoney pridaj = (double stavHotovosti, double suma) -> stavHotovosti = stavHotovosti + suma; 
		double result = manazer.add(ManazerHotovosti.stavHotovosti,suma, pridaj);
		//double result2 = manazer.add(stavHotovosti,suma, pridaj);
		ManazerHotovosti.stavHotovosti = result;
		System.out.println(ManazerHotovosti.stavHotovosti);*/
		
		Zreby zreb1 = new Zreby("zreb", 100, "Cierna perla");
		//System.out.println(zreb1.getDruh());
		Zreby zreb2 = new Zreby("zreb", 100, "Stastie");
		//Casopisy GEO = new Casopisy("Geo", 5, "GEO");
		/*stavHotovosti = */
		try {
			zreb1.predatTovar(zreb1, 10);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*stavHotovosti = */
		try {
			zreb2.predatTovar(zreb2, 5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*stavHotovosti = */
		//GEO.predatTovar(GEO, 1);
		System.out.println("posta main: " + ManazerHotovosti.getStavHotovosti());
		

	
	}


}
