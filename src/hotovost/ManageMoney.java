package hotovost;

public interface ManageMoney {
	
	double pridaj(double stavHotovosti, double suma);
	default void skontrolujStav(double stav) {
		System.out.println(stav);
		//return stav;
	}

}
