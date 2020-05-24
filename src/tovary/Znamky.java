package tovary;

import Exceptions.ZleUdajeException;
import hotovost.ManageMoney;
import hotovost.ManazerHotovosti;

/**
 * Trieda zn�mky ded� z nadtriedy Tovary
 * 
 * @author Lucia Rap�nov�
 *
 */
public class Znamky extends Tovary {

	private static final long serialVersionUID = 1L;
	private boolean isValid = false;
	private int flag = 0;

	/**
	 * Druh zn�mok, ktor� sa daj� vytvori�
	 * 
	 * @author Lucia Rap�nov�
	 */
	private enum DruhZnamok {
		T1("T1"), T2("T2"), eur1("eur1"), eur2("eur2"), eur050("eur050");

		private String nazovDruhu;

		/**
		 * Kon�truktor na enum
		 * 
		 * @param nazov je n�zov druhu tovaru
		 */
		private DruhZnamok(String nazov) {
			this.nazovDruhu = nazov;
		}

		/**
		 * Sl��i na porovananie, �i zadan� druh existuje - �i sa rovn� nejak�mu
		 * existuj�cemu druhu
		 * 
		 * @param otherName je n�zov druhu, s ktor�m sa porovn�va, �i je druh korektn�
		 * @return true, ak sa n�zvy rovnaj�, false, ak nie s� rovnak�
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
	 * @return vracia boolean hodnotu, �i je druh tovaru korektn�
	 */
	public boolean isValid() {
		return isValid;
	}

	/**
	 * Kon�truktor zn�mok, v ktorom sa kontroluje, �i bol zadan� korektn� druh
	 * tovaru
	 * 
	 * @param nazov je n�zov zn�mky
	 * @param pocet ko�ko tovaru chceme vytvori�
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
		 * lambda v�raz na matematick� oper�ciu, ktor� aktualizuje stav hotovosti
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
