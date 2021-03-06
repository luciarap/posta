package Zamestnanci;

import java.util.ArrayList;

import Exceptions.PodacieCisloException;
import zasielky.Dobierka;
import zasielky.PoistenyList;
import zasielky.Zasielky;

/**
 * Trieda doručovateľ je list v návrhovom vzore Composite, implementuje
 * interface Zamestnanec Môže doručovať a zapisovať zásielky
 * 
 * @author Lucia Rapánová
 *
 */
public class Dorucovatel implements Zamestnanec {
	private String meno;
	private String priezvisko;
	private int ID;
	private double mzda;
	private String pohlavie;

	/**
	 * Konštruktor Doručovateľa
	 * 
	 * @param meno       je meno doručovateľa
	 * @param priezvisko je priezvisko doručovateľa
	 * @param ID         je unikátne identifikačné čislo doručovateľa
	 * @param pohlavie   je pohlavie doručovateľa
	 */
	public Dorucovatel(String meno, String priezvisko, int ID, String pohlavie) {
		this.meno = meno;
		this.priezvisko = priezvisko;
		this.ID = ID;
		this.pohlavie = pohlavie;
	}

	@Override
	public String getPohlavie() {
		return pohlavie;
	}

	@Override
	public void odpisZasielky(ArrayList<Zasielky> ar, Zasielky zasielka) {
		ar.remove(zasielka);
		System.out.println("Zasielka bola dorucena.");
	}

	@Override
	public void Dorucit(Zasielky zasielka) {
		odpisZasielky(ar, zasielka);
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return ID;
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
		mzda = 650;

	}

	@Override
	public double getMzda() {
		// TODO Auto-generated method stub
		return mzda;
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
	public void info() {
		System.out.println("_______________");
		System.out.println("ID: " + getID());
		System.out.println("Meno: " + getMeno());
		System.out.println("Priezvisko: " + getPriezvisko());
		System.out.println("Mzda: " + getMzda());
		System.out.println("_______________");
	}

	@Override
	public String toString() {
		return "meno: " + meno + ", priezvisko: " + priezvisko;
	}

	@Override
	public Zasielky zapisZasielku(String podacieCislo, String meno, String priezvisko, String ulica, int cislo, int psc,
			String Mesto) throws PodacieCisloException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dobierka zapisDobierku(String podacieCislo, String meno, String priezvisko, String ulica, int cislo, int psc,
			String Mesto, double suma, double hmotnost) throws PodacieCisloException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PoistenyList zapisPL(String podacieCislo, String meno, String priezvisko, String ulica, int cislo, int psc,
			String Mesto, double suma) throws PodacieCisloException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean CheckDuplicate(String podacieCislo) {
		// TODO Auto-generated method stub
		return false;
	}

}
