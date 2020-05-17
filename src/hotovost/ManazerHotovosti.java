package hotovost;

public class ManazerHotovosti implements java.io.Serializable {
	
	private static double stavHotovosti = 10000;
	
	/*public ManazerHotovosti() {
		ManazerHotovosti.stavHotovosti = 10000;
	}*/
	
	public double add(double stav, double suma, ManageMoney manageMoney) {
	    return manageMoney.pridaj(stav, suma);
	}
	
	/*public double substract(double stav, double suma, ManageMoney manageMoney) {
	    return manageMoney.odrataj(stav, suma);
	}*/

	public static double getStavHotovosti() {
		return stavHotovosti;
	}

	public static void setStavHotovosti(double stavHotovosti) {
		ManazerHotovosti.stavHotovosti = stavHotovosti;
	}
	

	//public updateStav( )

}
