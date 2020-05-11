package hotovost;

public class ManazerHotovosti {
	
	public double stavHotovosti;
	
	public ManazerHotovosti() {
		this.stavHotovosti = 10000;
	}
	
	public double add(double stav,double suma, ManageMoney manageMoney) {
	    return manageMoney.pridaj(stav,suma);
	}
	
	//public updateStav( )

}
