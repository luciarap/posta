package Zamestnanci;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import zasielky.Dobierka;
import zasielky.Zasielky;
// Composite
public class VeduciPosty implements Zamestnanec { //COMPOSITE
	
	private String meno;
	private String priezvisko;
	private int ID;
	private double mzda;
	public VeduciPosty(String meno, String priezvisko, int ID) {
		this.meno = meno;
		this.priezvisko = priezvisko;
		this.ID = ID;
	}
	List<Zamestnanec> zamestnanci = new ArrayList<Zamestnanec>();  
	
	//private static double stavHotovostiNaPracovisku = 10000;
	//static ArrayList<Zasielky> ar = new ArrayList<Zasielky>();

	/*public VeduciPosty(String meno, String priezvisko) {
		super(meno, priezvisko);
		// TODO Auto-generated constructor stub
	}*/
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
	
	public Dobierka zapisDobierku(String podacieCislo, String meno, String priezvisko, String ulica, int cislo, int psc, String Mesto, double suma, double hmotnost) { //test
		Dobierka dobierka = new Dobierka(meno, priezvisko, ulica, cislo, psc, Mesto, suma, hmotnost);
		dobierka.podacieCislo = podacieCislo;
		//zasielka.podacieCislo = generujPodacieCislo();
		ar.add(dobierka);
		
		System.out.println("Zapisana nova dobierka s podacim cislo: " + dobierka.podacieCislo);
		
		for(Zasielky i : ar){
			System.out.println(i);
		}
		
		return dobierka;
	}

	@Override
	public double getMzda() {
		// TODO Auto-generated method stub
		return mzda;
	}
	@Override
	public void add(Zamestnanec zamestnanec) {
		zamestnanci.add(zamestnanec); 
		
	}
	@Override
	public void odstranZamestnanca(Zamestnanec zamestnanec) {
		zamestnanci.remove(zamestnanec); 
		
	}
	@Override
	public void dostanVyplatu() {
		mzda = 750;
		
	       Iterator<Zamestnanec> it = zamestnanci.iterator();  
	        
	          while(it.hasNext())  {  
	            Zamestnanec zamestnanec = it.next();  
	            zamestnanec.dostanVyplatu();  
	         }

	//to do
	}

	@Override
	public int getID() {
		return ID;
	}

	@Override
	public String getMeno() {
		return meno;
	}

	@Override
	public String getPriezvisko() {
		return priezvisko;
	}

	@Override
	public void info() {
	       System.out.println("_______________");  
	       System.out.println("ID: "+ getID());  
	       System.out.println("Meno: " + getMeno());  
	       System.out.println("Priezvisko: " + getPriezvisko());  
	       System.out.println("Mzda: " + getMzda());  
	       System.out.println("_______________");  
	       Iterator<Zamestnanec> it = zamestnanci.iterator();  
	        
	          while(it.hasNext())  {  
	            Zamestnanec zamestnanec = it.next();  
	            zamestnanec.info();  
	         }
	}
	


}
