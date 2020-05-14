package hotovost;

public interface ManageMoney {
	
	double pridaj(double stavHotovosti, double suma);
	
	//double odrataj(double stavHotovosti, double suma);
	
	default void objednatPeniaze() {
		double current = ManazerHotovosti.getStavHotovosti();
		current += 10000;
		ManazerHotovosti.setStavHotovosti(current);
	}

}
