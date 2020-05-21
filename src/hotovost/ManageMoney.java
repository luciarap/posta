package hotovost;

public interface ManageMoney {
	
	double pridaj(double stavHotovosti, double suma);
	
	default void objednatPeniaze() {
		double current = ManazerHotovosti.getStavHotovosti();
		System.out.println(current);
		current += 10000;
		System.out.println(current);
		ManazerHotovosti.setStavHotovosti(current);
	}

}
