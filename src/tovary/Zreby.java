package tovary;


public class Zreby extends Tovary {
	
	public enum DruhZrebov {
		  PrasaVZite,
		  StastneCisla,
		  CiernaPerla,
		  Stastie
		}
	private DruhZrebov druh;
	public Zreby(double cena, String nazov, int pocet, DruhZrebov druh) {
		super(nazov, pocet);
		this.druh = druh;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void objednatTovar(Tovary tovar, int pocet) {
		tovar.setPocet(pocet + 50);
	}

	@Override
	public double predatTovar(Tovary tovar, int pocet, double stavHotovosti) {
		if (pocet > tovar.getPocet() || tovar.getPocet() < 5) {
			objednatTovar(tovar, pocet);
		}
		int aktualnyPocet = tovar.getPocet();
		tovar.setPocet(aktualnyPocet - pocet);
		switch (druh) {
		case PrasaVZite:
			stavHotovosti += pocet*0.50;
			return stavHotovosti;
			
		case StastneCisla:
			stavHotovosti += pocet*1;
			return stavHotovosti;
		
		case CiernaPerla:
			stavHotovosti += pocet*5;
			return stavHotovosti;
		
		case Stastie:
			stavHotovosti += pocet*2;
			return stavHotovosti;
		}
		return stavHotovosti;
	}
	

}
