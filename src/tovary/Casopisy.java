package tovary;
public class Casopisy extends Tovary {
	
	public enum DruhCasopisov {
		  Zahradkar,
		  Byvanie,
		  Tyzden,
		  Kreativ,
		  Geo
		}
	private DruhCasopisov druh;
	public Casopisy(String nazov, int pocet, DruhCasopisov druh) {
		super(nazov, pocet);
		this.druh = druh;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void objednatTovar(Tovary tovar, int pocet) {
		tovar.setPocet(pocet + 1);
	}



	@Override
	public double predatTovar(Tovary tovar, int pocet, double stavHotovosti) {
		if (pocet > tovar.getPocet() || tovar.getPocet() < 5) {
			objednatTovar(tovar, pocet);
		}
		int aktualnyPocet = tovar.getPocet();
		tovar.setPocet(aktualnyPocet - pocet);
		switch (druh) {
		case Zahradkar:
			stavHotovosti += pocet*1.30;
			return stavHotovosti;
			
		case Byvanie:
			stavHotovosti += pocet*2;
			return stavHotovosti;
		
		case Tyzden:
			stavHotovosti += pocet*1;
			return stavHotovosti;
		
		case Kreativ:
			stavHotovosti += pocet*2.80;
			return stavHotovosti;
		
		case Geo:
			stavHotovosti += pocet*3;
			return stavHotovosti;
			
			
		}
		return stavHotovosti;
		
	}

}
