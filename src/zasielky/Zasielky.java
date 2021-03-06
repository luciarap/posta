package zasielky;

import java.util.Date;

/**
 * Hlavn� trieda Z�sielky
 * 
 * @author Lucia Rap�nov�
 *
 */
public abstract class Zasielky implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Date datum;
	private String podacieCislo;

	/**
	 * 
	 * @return d�tum zap�sania z�sielky
	 */
	public Date getDatum() {
		return datum;
	}

	/**
	 * 
	 * @param datum je d�tum zapisovania z�sielky
	 */
	public void setDatum(Date datum) {
		this.datum = datum;
	}

	/**
	 * 
	 * @return podacie ��slo z�sielky
	 */
	public String getPodacieCislo() {
		return podacieCislo;
	}

	/**
	 * 
	 * @param podacieCislo je podacie ��slo z�sielky
	 */
	public void setPodacieCislo(String podacieCislo) {
		this.podacieCislo = podacieCislo;
	}

	/**
	 * Vnoren� trieda Adresa obsahuje �daje o adrese - meno, priezvisko, ulica,
	 * ��slo, ps�, mesto
	 * 
	 * @author Lucia Rap�nov�
	 *
	 */
	public class Adresa {
		private String meno;
		private String priezvisko;
		private String ulica;
		private int cislo;
		private int psc;
		private String mesto;
	}

	/**
	 * Kon�truktor z�sielky
	 * 
	 * @param meno       je meno adres�ta
	 * @param priezvisko je priezvisko adres�ta
	 * @param ulica      je ulica adres�ta
	 * @param cislo      je ��slo domu adres�ta
	 * @param psc        je po�tov� smerov� ��slo adres�ta
	 * @param Mesto      je mesto bydliska adres�ta
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

		System.out.println(adresa.meno + " " + adresa.priezvisko + "\n" + adresa.ulica + " " + adresa.cislo + "\n"
				+ adresa.psc + " " + adresa.mesto);
	}

	@Override
	public String toString() {
		return "Zasielky: datum =" + datum + ", podacie cislo =" + podacieCislo;
	}

	/**
	 * Met�da, ktor� sl��i na overovanie, �i je podacie ��slo v spr�vnom form�te
	 * Spr�vny form�t za��na p�smenami RE, kon�� SK, zvy�n� s� ��sla a dokopy
	 * obsahuje 13 znakov Ak je to poisten� list, tak form�t za��na s p�smena VC
	 * 
	 * @param podacieCislo je podacie ��slo, ktor� sa zapisuje do syst�mu
	 * @return funkcia vr�ti true, ak je podacie ��slo v spr�vnom form�te, false, ak
	 *         je nespr�vne
	 */
	public abstract boolean CheckPodacieCislo(String podacieCislo);

}
