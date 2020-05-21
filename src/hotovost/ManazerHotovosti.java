package hotovost;

public class ManazerHotovosti  {
	
	private static double stavHotovosti = 10000;
	
	public double add(double stav, double suma, ManageMoney manageMoney) {
	    return manageMoney.pridaj(stav, suma);
	}
	

	public static double getStavHotovosti() {
		return stavHotovosti;
	}

	public static void setStavHotovosti(double stavHotovosti) {
		ManazerHotovosti.stavHotovosti = stavHotovosti;
	}
	

}
