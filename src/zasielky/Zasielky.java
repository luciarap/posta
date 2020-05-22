package zasielky;

import java.util.Date;
/**
 * 
 * @author lucia
 *
 */
public class Zasielky implements java.io.Serializable {
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
 * 
 * @author lucia
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
	 * @param meno
	 * @param priezvisko
	 * @param ulica
	 * @param cislo
	 * @param psc
	 * @param Mesto
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
		//this.jeDorucena = false;
		
		System.out.println(adresa.meno +" "+ adresa.priezvisko +"\n"+ adresa.ulica +" "+ adresa.cislo +"\n"+ adresa.psc +" "+ adresa.mesto);
	}

	@Override
	public String toString() {
		return "Zasielky: datum=" + datum + ", podacieCislo=" + podacieCislo;
	}
	/**
	 * 
	 * @param podacieCislo
	 * @return
	 */
	public boolean CheckPodacieCislo(String podacieCislo) {
		int i;
		if (podacieCislo.length() == 13) {
			if (podacieCislo.startsWith("RE") && podacieCislo.endsWith("SK"))  {
				for (i = 2; i <= 10; i++) {
					if (podacieCislo.matches(".*\\d.*")) continue;
					else return false;
				}
				
				return true;
			}

		}
		return false;
		
	}



}


