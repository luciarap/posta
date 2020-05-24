package tovary;

import Exceptions.ZleUdajeException;

/**
 * Abstraktn� nadtrieda Tovary
 * 
 * @author Lucia Rap�nov�
 *
 */
public abstract class Tovary implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private double cena;
	private String nazov;
	private int pocet;
	private String druh;

	/**
	 * 
	 * @return druh tovaru
	 */
	public String getDruh() {
		return druh;
	}

	/**
	 * 
	 * @param druh je druh tovaru
	 */
	public void setDruh(String druh) {
		this.druh = druh;
	}

	/**
	 * 
	 * @return cenu tovaru
	 */
	public double getCena() {
		return cena;
	}

	/**
	 * 
	 * @param cena je cena tovaru
	 */
	public void setCena(double cena) {
		this.cena = cena;
	}

	/**
	 * 
	 * @return n�zov tovaru
	 */
	public String getNazov() {
		return nazov;
	}

	/**
	 * 
	 * @param nazov je n�zov tovaru
	 */
	public void setNazov(String nazov) {
		this.nazov = nazov;
	}

	/**
	 * 
	 * @return po�et tovaru
	 */
	public int getPocet() {
		return pocet;
	}

	/**
	 * 
	 * @param pocet nastav� po�et tovaru
	 */
	public void setPocet(int pocet) {
		this.pocet = pocet;
	}

	/**
	 * Kon�truktor Tovarov
	 * 
	 * @param nazov je n�zov tovaru
	 * @param pocet je po�et tovarov
	 * @param druh  je druh tovaru
	 */
	public Tovary(String nazov, int pocet, String druh) {
		this.nazov = nazov;
		this.pocet = pocet;
		this.druh = druh;

	}

	/**
	 * Met�da na predaj tovaru zmen� po�et kusov tovaru a aktualizuje stav hotovosti
	 * 
	 * @param tovar je tovar, ktor� sa pred�va
	 * @param pocet je po�et tovaru na predaj
	 * @throws ZleUdajeException ak sa vyskytne chyba pri zad�van� �dajov
	 */
	public abstract void predatTovar(Tovary tovar, int pocet) throws ZleUdajeException;

	@Override
	public String toString() {
		return "Tovary:  nazov=" + nazov + ", pocet=" + pocet;
	}
}
