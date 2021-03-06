package hotovost;

/**
 * Mana��r hotovosti obsahuje "glob�lnu" premenn� stav hotovosti, ktor� sa
 * pren�a medzi sc�nami
 * 
 * @author Lucia Rap�nov�
 *
 */
public class ManazerHotovosti {

	private static double stavHotovosti = 10000;

	/**
	 * Pou��va sa pri predaji tovaru
	 * 
	 * @param stav        moment�lny stav hotovosti
	 * @param suma        suma, o ktor� sa ide stav nav��i�
	 * @param manageMoney funk�n� interface
	 * @return vr�ti upraven� stav hotovosti
	 */
	public double add(double stav, double suma, ManageMoney manageMoney) {
		return manageMoney.pridaj(stav, suma);
	}

	/**
	 * 
	 * @return stav hotovosti na po�te
	 */
	public static double getStavHotovosti() {
		return stavHotovosti;
	}

	/**
	 * 
	 * @param stavHotovosti je stav hotovosti na po�te
	 */
	public static void setStavHotovosti(double stavHotovosti) {
		ManazerHotovosti.stavHotovosti = stavHotovosti;
	}

}
