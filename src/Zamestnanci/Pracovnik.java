package Zamestnanci;

import java.util.ArrayList;

import Exceptions.PodacieCisloException;
import zasielky.Dobierka;
import zasielky.PoistenyList;
import zasielky.Zasielky;

/**
 * Trieds Pracovnik implementuje interface Zamestnanec, list v návrhovom vzore
 * Composit
 * 
 * @author Lucia Rapánová
 *
 */
public class Pracovnik implements Zamestnanec { // LEAF

	private String meno;
	private String priezvisko;
	private int ID;
	private double mzda;
	private String pohlavie;

	private double stavHotovosti = 0;
	private String uvazok;

	public double getStavHotovosti() {
		return stavHotovosti;
	}

	public void setStavHotovosti(double stavHotovosti) {
		this.stavHotovosti = stavHotovosti;
	}

	/**
	 * Konštruktor pracovníka
	 * 
	 * @param meno       je meno pracovníka
	 * @param priezvisko je priezvisko pracovníka
	 * @param ID         je unikátne identifikaèné èislo doruèovate¾a
	 * @param pohlavie   je pohlavie doruèovate¾a
	 * @param uvazok     je úväzok pracovníka, buï celý alebo polovièný
	 * 
	 */
	public Pracovnik(String meno, String priezvisko, int ID, String uvazok, String pohlavie) {
		this.meno = meno;
		this.priezvisko = priezvisko;
		this.ID = ID;
		this.uvazok = uvazok;
		this.pohlavie = pohlavie;
	}

	public String getPohlavie() {
		return pohlavie;
	}

	public void setPohlavie(String pohlavie) {
		this.pohlavie = pohlavie;
	}

	public void predajTovar() {

	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return ID;
	}

	@Override
	public double getMzda() {
		// TODO Auto-generated method stub
		return mzda;
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
		if (uvazok == "cely")
			mzda = 600;
		if (uvazok == "polovicny")
			mzda = 300;
		// TODO Auto-generated method stub

	}

	public void info() {
		System.out.println("_______________");
		System.out.println("ID: " + getID());
		System.out.println("Meno: " + getMeno());
		System.out.println("Priezvisko: " + getPriezvisko());
		System.out.println("Mzda: " + getMzda());
		System.out.println("_______________");
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
	public String toString() {
		return "meno: " + meno + ", priezvisko: " + priezvisko;
	}

	public String getUvazok() {
		return uvazok;
	}

	public void setUvazok(String uvazok) {
		this.uvazok = uvazok;
	}

	@Override
	public void Dorucit(Zasielky zasielka) {
		// TODO Auto-generated method stub

	}

	@Override
	public void odpisZasielky(ArrayList<Zasielky> ar, Zasielky zasielka) {
		// TODO Auto-generated method stub

	}

	@Override
	public Zasielky zapisZasielku(String podacieCislo, String meno, String priezvisko, String ulica, int cislo, int psc,
			String Mesto) throws PodacieCisloException {
		Zasielky zasielka = new Zasielky(meno, priezvisko, ulica, cislo, psc, Mesto);
		if (zasielka.CheckPodacieCislo(podacieCislo) == false || (CheckDuplicate(podacieCislo) == false)) {
			throw new PodacieCisloException("Zle podacie cislo");
		}
		zasielka.setPodacieCislo(podacieCislo);
		ar.add(zasielka);

		return zasielka;
	}

	@Override
	public Dobierka zapisDobierku(String podacieCislo, String meno, String priezvisko, String ulica, int cislo, int psc,
			String Mesto, double suma, double hmotnost) throws PodacieCisloException {
		Dobierka dobierka = new Dobierka(meno, priezvisko, ulica, cislo, psc, Mesto, suma, hmotnost);
		if (dobierka.CheckPodacieCislo(podacieCislo) == false || (CheckDuplicate(podacieCislo) == false)) {
			throw new PodacieCisloException("Zle podacie cislo");
		}
		dobierka.setPodacieCislo(podacieCislo);
		ar.add(dobierka);

		return dobierka;
	}

	@Override
	public PoistenyList zapisPL(String podacieCislo, String meno, String priezvisko, String ulica, int cislo, int psc,
			String Mesto, double suma) throws PodacieCisloException {
		PoistenyList pl = new PoistenyList(meno, priezvisko, ulica, cislo, psc, Mesto, suma);
		if ((pl.CheckPodacieCislo(podacieCislo)) == false || (CheckDuplicate(podacieCislo) == false)) {
			throw new PodacieCisloException("Zle podacie cislo");
		}
		pl.setPodacieCislo(podacieCislo);
		ar.add(pl);

		return pl;
	}

	@Override
	public boolean CheckDuplicate(String podacieCislo) {
		for (int counter = 0; counter < ar.size(); counter++) {
			System.out.println(ar.get(counter).getPodacieCislo());
			System.out.println(podacieCislo);
			if (ar.get(counter).getPodacieCislo().contentEquals(podacieCislo)) {

				return false;
			}
		}

		return true;
	}

}
