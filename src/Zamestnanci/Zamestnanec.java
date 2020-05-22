package Zamestnanci;

import java.util.ArrayList;

import Exceptions.PodacieCisloException;
import zasielky.Dobierka;
import zasielky.PoistenyList;
import zasielky.Zasielky;

/**
 * Interface, ktor� slu�� na pou�itie n�vrhov�ho vzoru Composite Je to takzvan�
 * component
 * 
 * @author Lucia Rap�nov�
 *
 */
public interface Zamestnanec { // COMPONENT
	/**
	 * @return vr�ti ID zamestnanca
	 */
	public int getID();

	/**
	 * @return vr�ti mzdu zamestnanca
	 */
	public double getMzda();

	/**
	 * Prid� zamestnanca do zoznamu
	 * 
	 * @param zamestnanec je zamestnanec, ktor� sa prid�va do zoznamu
	 */
	public void add(Zamestnanec zamestnanec);

	/**
	 * Odstr�ni zamestanca zo zoznamu
	 * 
	 * @param zamestnanec je zamestannec, ktor� sa bude odstra�ova�
	 */
	public void odstranZamestnanca(Zamestnanec zamestnanec);

	/**
	 * Pridel� v�platu v�etk�m zamestancom
	 */
	public void dostanVyplatu();

	/**
	 * Je zoznam z�sielok, kam sa zapisuj� jednotliv� z�sielky
	 */
	static ArrayList<Zasielky> ar = new ArrayList<Zasielky>();

	/**
	 * 
	 * @return vr�ti meno zamestannca
	 */
	public String getMeno();

	/**
	 * 
	 * @return v�rit priezvisko zamestannca
	 */
	public String getPriezvisko();

	/**
	 * 
	 * @return v�rit pohlavie zamestanca
	 */
	public String getPohlavie();

	/**
	 * Do konzoly vyp�e inform�cie o zamestanncoch
	 */
	public void info();

	/**
	 * Doru�enie z�sielky
	 * 
	 * @param zasielka je z�sielka na doru�enie
	 */
	public void Dorucit(Zasielky zasielka);

	/**
	 * Odp�sanie z�sielky z arraylistu z�sielok
	 * @param ar       je array list z�sielok
	 * @param zasielka je z�sielka, ktor� sa m� odstr�ni�
	 */
	public void odpisZasielky(ArrayList<Zasielky> ar, Zasielky zasielka);
	
	/**
	 * Zap�sanie doporu�en�ho listu
	 * @param podacieCislo je podacie ��slo z�sielky
	 * @param meno je meno adres�ta
	 * @param priezvisko je priezvisko adres�ta
	 * @param ulica je ulica adres�ta
	 * @param cislo je ��slo domu adres�ta
	 * @param psc je PS� adres�ta
	 * @param Mesto je mesto adres�ta
	 * @return vr�ti nov� in�tanciu dan�ho objektu
	 * @throws PodacieCisloException vyhod� chybu, ak bol zadan� nekorektn� form�t podacieho ��sla
	 */
	public Zasielky zapisZasielku(String podacieCislo, String meno, String priezvisko, String ulica, int cislo, int psc,
			String Mesto) throws PodacieCisloException;
	/**
	 * Zap�sanie dobierky
	 * @param podacieCislo je podacie ��slo dobierky
	 * @param meno je meno adres�ta
	 * @param priezvisko je priezvisko adres�ta
	 * @param ulica je ulica adres�ta
	 * @param cislo je ��slo domu adres�ta
	 * @param psc je PS� adres�ta
	 * @param Mesto je mesto adres�ta
	 * @param suma je suma dobierky
	 * @param hmotnost je hmotnos� dobierky
	 * @return vr�ti nov� in�tanciu dan�ho objektu
	 * @throws PodacieCisloException vyhod� chybu, ak bol zadan� nekorektn� form�t podacieho ��sla
	 */
	Dobierka zapisDobierku(String podacieCislo, String meno, String priezvisko, String ulica, int cislo, int psc,
			String Mesto, double suma, double hmotnost) throws PodacieCisloException;
	/**
	 * Zap�sanie poisten�ho listu
	 * @param podacieCislo je podacie ��slo poisten�ho listu
	 * @param meno je meno adres�ta
	 * @param priezvisko je priezvisko adres�ta
	 * @param ulica je ulica adres�ta
	 * @param cislo je ��slo domu adres�ta
	 * @param psc je PS� adres�ta
	 * @param Mesto je mesto adres�ta
	 * @param suma je v��ka poistenia
	 * @return vr�ti nov� in�tanciu dan�ho objektu
	 * @throws PodacieCisloException vyhod� chybu, ak bol zadan� nekorektn� form�t podacieho ��sla
	 */
	PoistenyList zapisPL(String podacieCislo, String meno, String priezvisko, String ulica, int cislo, int psc,
			String Mesto, double suma) throws PodacieCisloException;
	/**
	 * Skontroluje, �i podacie ��slo u� existuje
	 * @param podacieCislo je podacie ��slo, ktor� sa bude kontrolova�
	 * @return true, ak podacie ��slo e�te neexistuje, false, ak sa u� na�lo existuj�ce podacie ��slo
	 */
	public boolean CheckDuplicate(String podacieCislo);
}
