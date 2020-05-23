package tovary;

import Exceptions.ZleUdajeException;

/**
 * Abstraktná nadtrieda Tovary
 * 
 * @author Lucia Rapánová
 *
 */
public abstract class Tovary implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private double cena;
	private String nazov;
	private int pocet;
	private String druh;

	public String getDruh() {
		return druh;
	}

	public void setDruh(String druh) {
		this.druh = druh;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public String getNazov() {
		return nazov;
	}

	public void setNazov(String nazov) {
		this.nazov = nazov;
	}

	public int getPocet() {
		return pocet;
	}

	public void setPocet(int pocet) {
		this.pocet = pocet;
	}

	/**
	 * Konštruktor Tovarov
	 * 
	 * @param nazov je názov tovaru
	 * @param pocet je poèet tovarov
	 * @param druh  je druh tovaru
	 */
	public Tovary(String nazov, int pocet, String druh) {
		this.nazov = nazov;
		this.pocet = pocet;
		this.druh = druh;

	}

	/**
	 * Metóda na predaj tovaru zmení poèet kusov tovaru a aktualizuje stav hotovosti
	 * 
	 * @param tovar je tovar, ktorý sa predáva
	 * @param pocet je poèet tovaru na predaj
	 * @throws ZleUdajeException ak sa vyskytne chyba pri zadávaní údajov
	 */
	public abstract void predatTovar(Tovary tovar, int pocet) throws ZleUdajeException;

	@Override
	public String toString() {
		return "Tovary:  nazov=" + nazov + ", pocet=" + pocet;
	}
}
