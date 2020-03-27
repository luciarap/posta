package Zamestnanci;

public class Dorucovatel extends Zamestnanci {
	
	private double stavHotovosti = 0;

	public double getStavHotovosti() {
		return stavHotovosti;
	}

	public void setStavHotovosti(double stavHotovosti) {
		this.stavHotovosti = stavHotovosti;
	}

	public Dorucovatel(String meno, String priezvisko) {
		super(meno, priezvisko);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pridelVyplatu(double suma) {
		// TODO Auto-generated method stub
		
	}
	
	public void dorucitZasielku() {
		
	}
	

}
