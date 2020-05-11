package hotovost;

public interface ManageMoney {
	
	double pridaj(double stav, double suma);
	default void skontrolujStav() {
		
	}

}
