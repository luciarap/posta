package Zamestnanci;

import java.util.ArrayList;

import Exceptions.PodacieCisloException;
import zasielky.Dobierka;
import zasielky.PoistenyList;
import zasielky.Zasielky;

/**
 * Interface, ktorı sluí na pouitie návrhového vzoru Composite Je to takzvanı
 * component
 * 
 * @author Lucia Rapánová
 *
 */
public interface Zamestnanec { // COMPONENT
	/**
	 * @return vráti ID zamestnanca
	 */
	public int getID();

	/**
	 * @return vráti mzdu zamestnanca
	 */
	public double getMzda();

	/**
	 * Pridá zamestnanca do zoznamu
	 * 
	 * @param zamestnanec je zamestnanec, ktorı sa pridáva do zoznamu
	 */
	public void add(Zamestnanec zamestnanec);

	/**
	 * Odstráni zamestanca zo zoznamu
	 * 
	 * @param zamestnanec je zamestannec, ktorı sa bude odstraòova
	 */
	public void odstranZamestnanca(Zamestnanec zamestnanec);

	/**
	 * Pridelí vıplatu všetkım zamestancom
	 */
	public void dostanVyplatu();

	/**
	 * Je zoznam zásielok, kam sa zapisujú jednotlivé zásielky
	 */
	static ArrayList<Zasielky> ar = new ArrayList<Zasielky>();

	/**
	 * 
	 * @return vráti meno zamestannca
	 */
	public String getMeno();

	/**
	 * 
	 * @return várit priezvisko zamestannca
	 */
	public String getPriezvisko();

	/**
	 * 
	 * @return várit pohlavie zamestanca
	 */
	public String getPohlavie();

	/**
	 * Do konzoly vypíše informácie o zamestanncoch
	 */
	public void info();

	/**
	 * Doruèenie zásielky
	 * 
	 * @param zasielka je zásielka na doruèenie
	 */
	public void Dorucit(Zasielky zasielka);

	/**
	 * Odpísanie zásielky z arraylistu zásielok
	 * @param ar       je array list zásielok
	 * @param zasielka je zásielka, ktorá sa má odstráni
	 */
	public void odpisZasielky(ArrayList<Zasielky> ar, Zasielky zasielka);
	
	/**
	 * Zapísanie doporuèeného listu
	 * @param podacieCislo je podacie èíslo zásielky
	 * @param meno je meno adresáta
	 * @param priezvisko je priezvisko adresáta
	 * @param ulica je ulica adresáta
	 * @param cislo je èíslo domu adresáta
	 * @param psc je PSÈ adresáta
	 * @param Mesto je mesto adresáta
	 * @return vráti novú inštanciu daného objektu
	 * @throws PodacieCisloException vyhodí chybu, ak bol zadanı nekorektnı formát podacieho èísla
	 */
	public Zasielky zapisZasielku(String podacieCislo, String meno, String priezvisko, String ulica, int cislo, int psc,
			String Mesto) throws PodacieCisloException;
	/**
	 * Zapísanie dobierky
	 * @param podacieCislo je podacie èíslo dobierky
	 * @param meno je meno adresáta
	 * @param priezvisko je priezvisko adresáta
	 * @param ulica je ulica adresáta
	 * @param cislo je èíslo domu adresáta
	 * @param psc je PSÈ adresáta
	 * @param Mesto je mesto adresáta
	 * @param suma je suma dobierky
	 * @param hmotnost je hmotnos dobierky
	 * @return vráti novú inštanciu daného objektu
	 * @throws PodacieCisloException vyhodí chybu, ak bol zadanı nekorektnı formát podacieho èísla
	 */
	Dobierka zapisDobierku(String podacieCislo, String meno, String priezvisko, String ulica, int cislo, int psc,
			String Mesto, double suma, double hmotnost) throws PodacieCisloException;
	/**
	 * Zapísanie poisteného listu
	 * @param podacieCislo je podacie èíslo poisteného listu
	 * @param meno je meno adresáta
	 * @param priezvisko je priezvisko adresáta
	 * @param ulica je ulica adresáta
	 * @param cislo je èíslo domu adresáta
	 * @param psc je PSÈ adresáta
	 * @param Mesto je mesto adresáta
	 * @param suma je vıška poistenia
	 * @return vráti novú inštanciu daného objektu
	 * @throws PodacieCisloException vyhodí chybu, ak bol zadanı nekorektnı formát podacieho èísla
	 */
	PoistenyList zapisPL(String podacieCislo, String meno, String priezvisko, String ulica, int cislo, int psc,
			String Mesto, double suma) throws PodacieCisloException;
	/**
	 * Skontroluje, èi podacie èíslo u existuje
	 * @param podacieCislo je podacie èíslo, ktoré sa bude kontrolova
	 * @return true, ak podacie èíslo ešte neexistuje, false, ak sa u našlo existujúce podacie èíslo
	 */
	public boolean CheckDuplicate(String podacieCislo);
}
