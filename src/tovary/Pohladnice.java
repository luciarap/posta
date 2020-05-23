package tovary;

import Exceptions.ZleUdajeException;
import hotovost.ManageMoney;
import hotovost.ManazerHotovosti;

/**
 * Trieda poh¾adnice dedí z nadtriedy Tovary
 * 
 * @author Lucia Rapánová
 *
 */
public class Pohladnice extends Tovary {

	private static final long serialVersionUID = 1L;
	private boolean isValid = false;
	private int flag = 0;

	/**
	 * Druh poh¾adníc, ktoré sa dajú vytvori
	 * 
	 * @author Lucia Rapánová
	 */
	private enum DruhPohladnic {
		Narodeniny1("Narodeniny druh 1"), Narodeniny2("Narodeniny druh 2"), Vianoce("Vianoce"), VelkaNoc("Velka noc"),
		Meniny("Meniny");

		private String nazovDruhu;

		private DruhPohladnic(String nazov) {
			this.nazovDruhu = nazov;
		}

		/**
		 * Slúži na porovananie, èi zadaný druh existuje - èi sa rovná nejakému
		 * existujúcemu druhu
		 * 
		 * @param otherName je názov druhu, s ktorým sa porovnáva, èi je druh korektný
		 * @return true, ak sa názvy rovnajú, false, ak nie sú rovnaké
		 */
		public boolean equalsName(String otherName) {
			return nazovDruhu.equals(otherName);
		}

		public String toString() {
			return this.nazovDruhu;
		}
	}

	public boolean isValid() {
		return isValid;
	}

	/**
	 * Konštruktor poh¾adníc, v ktorom sa kontroluje, èi bol zadaný korektný druh
	 * tovaru
	 * 
	 * @param nazov je názov poh¾adnice
	 * @param pocet ko¾ko tovaru chceme vytvori
	 * @param druh  je druh tovaru (enum)
	 */
	public Pohladnice(String nazov, int pocet, String druh) {
		super(nazov, pocet, druh);

		try {

			for (DruhPohladnic typ : DruhPohladnic.values()) {
				if (typ.equalsName(druh)) {
					flag = 1;
				}
			}

			if (flag == 1)
				isValid = true;

			if (flag == 0)
				throw new ZleUdajeException("Udaje neboli spravne zadane");

		}

		catch (ZleUdajeException e) {
			isValid = false;
			System.out.println(e);
			e.ShowAlert();
		}
	}

	@Override
	public void predatTovar(Tovary tovar, int pocet) {

		double celkovaSuma;

		ManazerHotovosti manazer = new ManazerHotovosti();
		ManageMoney pridaj = (double stavHotovosti, double suma) -> stavHotovosti = stavHotovosti + suma;
		/**
		 * lambda výraz na matematickú operáciu, ktorá aktualizuje stav hotovosti
		 */

		if (pocet > tovar.getPocet()) {
			System.out.println("Nekorektne mnozstvo tovaru.");
			return;
		}
		int aktualnyPocet = tovar.getPocet();
		tovar.setPocet(aktualnyPocet - pocet);
		/**
		 * polymorfizmus
		 */
		switch (tovar.getDruh()) {

		case "Narodeniny druh 1":
			celkovaSuma = pocet * 0.40;
			double result1 = manazer.add(ManazerHotovosti.getStavHotovosti(), celkovaSuma, pridaj);
			ManazerHotovosti.setStavHotovosti(result1);
			break;

		case "Narodeniny druh 2":
			celkovaSuma = pocet * 0.80;
			double result2 = manazer.add(ManazerHotovosti.getStavHotovosti(), celkovaSuma, pridaj);
			ManazerHotovosti.setStavHotovosti(result2);
			break;

		case "Vianoce":
			celkovaSuma = pocet * 1;
			double result3 = manazer.add(ManazerHotovosti.getStavHotovosti(), celkovaSuma, pridaj);
			ManazerHotovosti.setStavHotovosti(result3);
			break;

		case "Velka noc":
			celkovaSuma = pocet * 1;
			double result4 = manazer.add(ManazerHotovosti.getStavHotovosti(), celkovaSuma, pridaj);
			ManazerHotovosti.setStavHotovosti(result4);
			break;

		case "Meniny":
			celkovaSuma = pocet * 0.50;
			double result5 = manazer.add(ManazerHotovosti.getStavHotovosti(), celkovaSuma, pridaj);
			ManazerHotovosti.setStavHotovosti(result5);
			break;

		default:
			System.out.println("CHYBA");
		}

	}

}
