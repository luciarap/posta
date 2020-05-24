package hotovost;

/**
 * Manaér hotovosti obsahuje "globálnu" premennú stav hotovosti, ktorá sa
 * prenáša medzi scénami
 * 
 * @author Lucia Rapánová
 *
 */
public class ManazerHotovosti {

	private static double stavHotovosti = 10000;

	/**
	 * Pouíva sa pri predaji tovaru
	 * 
	 * @param stav        momentálny stav hotovosti
	 * @param suma        suma, o ktorú sa ide stav navıši
	 * @param manageMoney funkènı interface
	 * @return vráti upravenı stav hotovosti
	 */
	public double add(double stav, double suma, ManageMoney manageMoney) {
		return manageMoney.pridaj(stav, suma);
	}

	/**
	 * 
	 * @return stav hotovosti na pošte
	 */
	public static double getStavHotovosti() {
		return stavHotovosti;
	}

	/**
	 * 
	 * @param stavHotovosti je stav hotovosti na pošte
	 */
	public static void setStavHotovosti(double stavHotovosti) {
		ManazerHotovosti.stavHotovosti = stavHotovosti;
	}

}
