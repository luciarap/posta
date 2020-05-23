package hotovost;

/**
 * Functional interface pouívanı na metódu s lambda vırazom Obsahuje jednu
 * default method
 * 
 * @author Lucia Rapánová
 *
 */
public interface ManageMoney {
	/**
	 * Metóda pouívaná na lambda vıraz
	 * 
	 * @param stavHotovosti je aktuálny stav hotovosti, ktorı sa bude aktualizova
	 * @param suma          je suma, o ktorú sa bude stav hotovosti navyšova
	 * @return vráti upravenı stav hotovosti
	 */
	double pridaj(double stavHotovosti, double suma);

	/**
	 * Default metóda spraví to, e ak by bolo na pošte menej peòazí, tak sa peniaze
	 * navıšia Môe sa to sta pri vyplácaní vıplaty zamestnancom
	 * 
	 * @see Zamestnanci#VeduciPosty#dostanVyplatu() metóda na vyplácanie vıplat
	 */
	default void objednatPeniaze() {
		double current = ManazerHotovosti.getStavHotovosti();
		System.out.println(current);
		current += 10000;
		System.out.println(current);
		ManazerHotovosti.setStavHotovosti(current);
	}

}
