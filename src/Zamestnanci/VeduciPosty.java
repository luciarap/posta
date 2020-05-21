package Zamestnanci;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Exceptions.PodacieCisloException;
import hotovost.ManageMoney;
import hotovost.ManazerHotovosti;
import zasielky.Dobierka;
import zasielky.PoistenyList;
import zasielky.Zasielky;
// Composite
public class VeduciPosty implements Zamestnanec, ManageMoney { //COMPOSITE
	
	private String meno;
	private String priezvisko;
	private int ID;
	private double mzda;
	private String pohlavie;
	
	public VeduciPosty(String meno, String priezvisko, int ID, String pohlavie) {
		this.meno = meno;
		this.priezvisko = priezvisko;
		this.ID = ID;
		this.pohlavie = pohlavie;
	}
	public String getPohlavie() {
		return pohlavie;
	}

	public void setPohlavie(String pohlavie) {
		this.pohlavie = pohlavie;
	}
	List<Zamestnanec> zamestnanci = new ArrayList<Zamestnanec>();  
	
	public void odpisZasielky(ArrayList<Zasielky> ar, Zasielky zasielka) {
		ar.remove(zasielka);
		System.out.println("Zasielka bola dorucena.");
	}
	
	public void Dorucit(Zasielky zasielka) {
		odpisZasielky(ar, zasielka);
	}
	
	public Zasielky zapisZasielku(String podacieCislo, String meno, String priezvisko, String ulica, int cislo, int psc, String Mesto) throws PodacieCisloException { //test
		Zasielky zasielka = new Zasielky(meno, priezvisko, ulica, cislo, psc, Mesto);
		if (zasielka.CheckPodacieCislo(podacieCislo) == false || (CheckDuplicate(podacieCislo) == false)) {
			throw new PodacieCisloException("Zle podacie cislo");
		}
		zasielka.setPodacieCislo(podacieCislo);
		ar.add(zasielka);
		
		
		return zasielka;
	}
	
	public Dobierka zapisDobierku(String podacieCislo, String meno, String priezvisko, String ulica, int cislo, int psc, String Mesto, double suma, double hmotnost) throws PodacieCisloException { //test
		Dobierka dobierka = new Dobierka(meno, priezvisko, ulica, cislo, psc, Mesto, suma, hmotnost);
		if (dobierka.CheckPodacieCislo(podacieCislo) == false || (CheckDuplicate(podacieCislo) == false)) {
			throw new PodacieCisloException("Zle podacie cislo");
		}
		dobierka.setPodacieCislo(podacieCislo);
		ar.add(dobierka);
		
		
		return dobierka;
	}
	
	public PoistenyList zapisPL(String podacieCislo, String meno, String priezvisko, String ulica, int cislo, int psc, String Mesto, double suma) throws PodacieCisloException { //test
		PoistenyList pl = new PoistenyList(meno, priezvisko, ulica, cislo, psc, Mesto, suma);
		if ((pl.CheckPodacieCislo(podacieCislo)) == false || (CheckDuplicate(podacieCislo) == false) ) {
			throw new PodacieCisloException("Zle podacie cislo");
		}
		pl.setPodacieCislo(podacieCislo);
		ar.add(pl);
		
		return pl;
	}
	
	public boolean CheckDuplicate(String podacieCislo) {
		System.out.println("Cekujem duplikaty");
		
	      for (int counter = 0; counter < ar.size(); counter++) { 	
        		System.out.println(ar.get(counter).getPodacieCislo());
        		System.out.println(podacieCislo);
	          	if (ar.get(counter).getPodacieCislo().contentEquals(podacieCislo)) {

	          		return false;
	          	}
	      }
	      
	      return true;
		
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
	            double current = ManazerHotovosti.getStavHotovosti();
	            current -= mzda;
	            if (current < 0) {
	            	System.out.println("Pred " + ManazerHotovosti.getStavHotovosti());
	            	objednatPeniaze();
	            }
	            else {
	            ManazerHotovosti.setStavHotovosti(current);
	            System.out.println("Po: " + ManazerHotovosti.getStavHotovosti());
	            }
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

	@Override
	public String toString() {
		return "meno: " + meno + ", priezvisko: " + priezvisko;
	}

	@Override
	public double pridaj(double stavHotovosti, double suma) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	

	


}
