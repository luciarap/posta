package tovary;

import Exceptions.ZleUdajeException;
import hotovost.ManageMoney;
import hotovost.ManazerHotovosti;

/**
 * Trieda známky dedí z nadtriedy Tovary
 * 
 * @author Lucia Rapánová
 *
 */
public class Znamky extends Tovary {

	private static final long serialVersionUID = 1L;
	private boolean isValid = false;
	private int flag = 0;

	/**
	 * Druh známok, ktoré sa dajú vytvori
	 * 
	 * @author Lucia Rapánová
	 */
	private enum DruhZnamok {
		T1("T1"), T2("T2"), eur1("eur1"), eur2("eur2"), eur050("eur050");

		private String nazovDruhu;

		/**
		 * Konštruktor na enum
		 * 
		 * @param nazov je názov druhu tovaru
		 */
		private DruhZnamok(String nazov) {
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

	/**
	 * 
	 * @return vracia boolean hodnotu, èi je druh tovaru korektný
	 */
	public boolean isValid() {
		return isValid;
	}

	/**
	 * Konštruktor známok, v ktorom sa kontroluje, èi bol zadaný korektný druh
	 * tovaru
	 * 
	 * @param nazov je názov známky
	 * @param pocet ko¾ko tovaru chceme vytvori
	 * @param druh  je druh tovaru (enum)
	 */
	public Znamky(String nazov, int pocet, String druh) {
		super(nazov, pocet, druh);

		try {

			for (DruhZnamok typ : DruhZnamok.values()) {
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

		case "T1":
			celkovaSuma = pocet * 0.80;
			double result1 = manazer.add(ManazerHotovosti.getStavHotovosti(), celkovaSuma, pridaj);
			ManazerHotovosti.setStavHotovosti(result1);
			break;

		case "T2":
			celkovaSuma = pocet * 0.65;
			double result2 = manazer.add(ManazerHotovosti.getStavHotovosti(), celkovaSuma, pridaj);
			ManazerHotovosti.setStavHotovosti(result2);
			break;

		case "eur1":
			System.out.println("Pocet: " + pocet);
			celkovaSuma = pocet * 1;
			System.out.println("Celkova: " + celkovaSuma);
			double result3 = manazer.add(ManazerHotovosti.getStavHotovosti(), celkovaSuma, pridaj);
			System.out.println("Result: " + result3);
			ManazerHotovosti.setStavHotovosti(result3);
			System.out.println(ManazerHotovosti.getStavHotovosti());
			break;

		case "eur2":
			celkovaSuma = pocet * 2;
			double result4 = manazer.add(ManazerHotovosti.getStavHotovosti(), celkovaSuma, pridaj);
			ManazerHotovosti.setStavHotovosti(result4);
			break;

		case "eur050":
			celkovaSuma = pocet * 0.50;
			double result5 = manazer.add(ManazerHotovosti.getStavHotovosti(), celkovaSuma, pridaj);
			ManazerHotovosti.setStavHotovosti(result5);
			break;

		default:
			System.out.println("CHYBA");

		}

	}

}
