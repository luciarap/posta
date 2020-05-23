package hotovost;

/**
 * Functional interface pou��van� na met�du s lambda v�razom Obsahuje jednu
 * default method
 * 
 * @author Lucia Rap�nov�
 *
 */
public interface ManageMoney {
	/**
	 * Met�da pou��van� na lambda v�raz
	 * 
	 * @param stavHotovosti je aktu�lny stav hotovosti, ktor� sa bude aktualizova�
	 * @param suma          je suma, o ktor� sa bude stav hotovosti navy�ova�
	 * @return vr�ti upraven� stav hotovosti
	 */
	double pridaj(double stavHotovosti, double suma);

	/**
	 * Default met�da sprav� to, �e ak by bolo na po�te menej pe�az�, tak sa peniaze
	 * nav��ia M��e sa to sta� pri vypl�can� v�platy zamestnancom
	 * 
	 * @see Zamestnanci#VeduciPosty#dostanVyplatu() met�da na vypl�canie v�plat
	 */
	default void objednatPeniaze() {
		double current = ManazerHotovosti.getStavHotovosti();
		System.out.println(current);
		current += 10000;
		System.out.println(current);
		ManazerHotovosti.setStavHotovosti(current);
	}

}
