package hotovost;

public interface ManageMoney {
	
	double pridaj(double stavHotovosti, double suma);
	default void skontrolujStav() {
		System.out.println();
		//return stav;
	}

}
