package Posta;
//import javafx.application.Application;

import java.util.ArrayList;

import Zamestnanci.Dorucovatel;
import Zamestnanci.VeduciPosty;
import tovary.Tovary;
import zasielky.DoporucenyList;
import zasielky.Zasielky;
import zasielky.Zasielky.Adresa;

public class Posta {
	static ArrayList<Zasielky> ar = new ArrayList<Zasielky>();
	static ArrayList<Tovary> ar2 = new ArrayList<Tovary>();
	

	public static void main(String[] args) {

		VeduciPosty veduci1 = new VeduciPosty("Jana", "Horvathova");
		DoporucenyList doplist1 = new DoporucenyList("Jozef", "Mak", "Nizovecka", 4, 97223, "Dolne Vestenice");
		DoporucenyList doplist2 = new DoporucenyList("Jano", "Kovac", "Komenskeho", 12, 97222, "Nitrica");
		veduci1.zapisZasielky(ar, doplist1);
		veduci1.zapisZasielky(ar, doplist2);
		Dorucovatel dorucovatel1 = new Dorucovatel("Eva", "Benkova");
		veduci1.pridelPeniaze(dorucovatel1, 4000);
		
	
	}

}