package zasielky;

import java.util.Date;
/**
 * 
 * @author Lucia Rap�nov�
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
 * Vnoren� trieda Adresa obsahuje �daje o adrese - meno, priezvisko, ulica, ��slo, ps�, mesto
 * @author Lucia Rap�nov�
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
	 * @param meno je meno adres�ta
	 * @param priezvisko je priezvisko adres�ta
	 * @param ulica je ulica adres�ta
	 * @param cislo je ��slo domu adres�ta
	 * @param psc je po�tov� smerov� ��slo adres�ta
	 * @param Mesto je mesto bydliska adres�ta
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
	 * Met�da, ktor� sl��i na overovanie, �i je podacie ��slo v spr�vnom form�te
	 * Spr�vny form�t za��na p�smenami RE, kon�� SK, zvy�n� s� ��sla a dokopy obsahuje 13 znakov
	 * @param podacieCislo je podacie ��slo, ktor� sa zapisuje do syst�mu
	 * @return funkcia vr�ti true, ak je podacie ��slo v spr�vnom form�te, false, ak je nespr�vne
	 */
	public boolean CheckPodacieCislo(String podacieCislo) {
		int i;
		if (podacieCislo.length() == 13) {
			if (podacieCislo.startsWith("RE") && podacieCislo.endsWith("SK"))  {
				for (i = 2; i <= 10; i++) {
					/**
					 * znamen� to, �e konstroluje, �i je to ��slo
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


