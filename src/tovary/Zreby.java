package tovary;

import Exceptions.ZleUdajeException;
import hotovost.ManageMoney;
import hotovost.ManazerHotovosti;

/**
 * Trieda žreby dedí z nadtriedy Tovary
 * 
 * @author Lucia Rapánová
 *
 */
public class Zreby extends Tovary {

	private static final long serialVersionUID = 1L;
	private boolean isValid = false;
	private int flag = 0;

	/**
	 * Druh žrebov, ktoré sa dajú vytvori
	 * 
	 * @author Lucia Rapánová
	 */
	private enum DruhZrebov {
		PrasaVZite("Prasa v zite"), StastneCisla("Stastne cisla"), CiernaPerla("Cierna perla"), Stastie("Stastie");

		private String nazovDruhu;

		private DruhZrebov(String nazov) {
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
	 * Konštruktor žrebov, v ktorom sa kontroluje, èi bol zadaný korektný druh
	 * tovaru
	 * 
	 * @param nazov je názov žrebu
	 * @param pocet ko¾ko tovaru chceme vytvori
	 * @param druh  je druh tovaru (enum)
	 * @throws ZleUdajeException pri zle zadaných údajoch
	 */
	public Zreby(String nazov, int pocet, String druh) throws ZleUdajeException {
		super(nazov, pocet, druh);

		try {

			for (DruhZrebov typ : DruhZrebov.values()) {
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

	public boolean isValid() {
		return isValid;
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

		case "Prasa v zite":
			celkovaSuma = pocet * 0.50;
			double result1 = manazer.add(ManazerHotovosti.getStavHotovosti(), celkovaSuma, pridaj);
			ManazerHotovosti.setStavHotovosti(result1);
			break;

		case "Stastne cisla":
			celkovaSuma = pocet * 1;
			double result2 = manazer.add(ManazerHotovosti.getStavHotovosti(), celkovaSuma, pridaj);
			ManazerHotovosti.setStavHotovosti(result2);
			break;

		case "Cierna perla":
			celkovaSuma = pocet * 5;
			double result3 = manazer.add(ManazerHotovosti.getStavHotovosti(), celkovaSuma, pridaj);
			ManazerHotovosti.setStavHotovosti(result3);
			break;

		case "Stastie":
			celkovaSuma = pocet * 2;
			double result4 = manazer.add(ManazerHotovosti.getStavHotovosti(), celkovaSuma, pridaj);
			ManazerHotovosti.setStavHotovosti(result4);
			break;

		default:
			System.out.println("CHYBA");
		}
	}

}
