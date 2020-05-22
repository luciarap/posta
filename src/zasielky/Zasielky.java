package zasielky;

import java.util.Date;
/**
 * 
 * @author Lucia Rapánová
 *
 */
public class Zasielky implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date datum;
	private String podacieCislo;
	//public boolean jeDorucena;
	
	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getPodacieCislo() {
		return podacieCislo;
	}

	public void setPodacieCislo(String podacieCislo) {
		this.podacieCislo = podacieCislo;
	}
/**
 * Vnorená trieda Adresa obsahuje údaje o adrese - meno, priezvisko, ulica, èíslo, psè, mesto
 * @author Lucia Rapánová
 *
 */
	public class Adresa {
		String meno;
		String priezvisko;
		String ulica;
		int cislo;
		int psc;
		String mesto;
	}
	/**
	 * 
	 * @param meno je meno adresáta
	 * @param priezvisko je priezvisko adresáta
	 * @param ulica je ulica adresáta
	 * @param cislo je èíslo domu adresáta
	 * @param psc je poètové smerové èíslo adresáta
	 * @param Mesto je mesto bydliska adresáta
	 */
	public Zasielky(String meno, String priezvisko, String ulica, int cislo, int psc, String Mesto) {
		Date date = new Date();
		this.datum = date;
		Zasielky.Adresa adresa = new Zasielky.Adresa();
		adresa.meno = meno;
		adresa.priezvisko = priezvisko;
		adresa.ulica = ulica;
		adresa.cislo = cislo;
		adresa.psc = psc;
		adresa.mesto = Mesto;
		
		System.out.println(adresa.meno +" "+ adresa.priezvisko +"\n"+ adresa.ulica +" "+ adresa.cislo +"\n"+ adresa.psc +" "+ adresa.mesto);
	}

	@Override
	public String toString() {
		return "Zasielky: datum=" + datum + ", podacieCislo=" + podacieCislo;
	}
	/**
	 * Metóda, ktorá slúži na overovanie, èi je podacie èíslo v správnom formáte
	 * Správny formát zaèína písmenami RE, konèí SK, zvyšné sú èísla a dokopy obsahuje 13 znakov
	 * @param podacieCislo je podacie èíslo, ktoré sa zapisuje do systému
	 * @return funkcia vráti true, ak je podacie èíslo v správnom formáte, false, ak je nesprávne
	 */
	public boolean CheckPodacieCislo(String podacieCislo) {
		int i;
		if (podacieCislo.length() == 13) {
			if (podacieCislo.startsWith("RE") && podacieCislo.endsWith("SK"))  {
				for (i = 2; i <= 10; i++) {
					/**
					 * znamená to, že konstroluje, èi je to èíslo
					 */
					if (podacieCislo.matches(".*\\d.*")) continue; 
					else return false;
				}
				
				return true;
			}

		}
		return false;
		
	}



}


