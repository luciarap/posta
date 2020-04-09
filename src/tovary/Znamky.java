package tovary;

public class Znamky extends Tovary {
	
	public enum DruhZnamok {
		  T1,
		  T2,
		  eur1,
		  eur2,
		  eur050,
		}

	private DruhZnamok druh;
	public Znamky(String nazov, int pocet, DruhZnamok druh) {
		super(nazov, pocet);
		this.druh = druh;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void objednatTovar(Tovary tovar, int pocet) {
		tovar.setPocet(pocet + 10);
	}

	@Override
	public double predatTovar(Tovary tovar, int pocet, double stavHotovosti) {
		if (pocet > tovar.getPocet() || tovar.getPocet() < 5) {
			objednatTovar(tovar, pocet);
		}
		int aktualnyPocet = tovar.getPocet();
		tovar.setPocet(aktualnyPocet - pocet);
		switch (druh) {
		case T1:
			stavHotovosti += pocet*0.80;
			return stavHotovosti;
			
		case T2:
			stavHotovosti += pocet*0.65;
			return stavHotovosti;
		
		case eur1:
			stavHotovosti += pocet*1;
			return stavHotovosti;
		
		case eur2:
			stavHotovosti += pocet*2;
			return stavHotovosti;
		
		case eur050:
			stavHotovosti += pocet*0.50;
			return stavHotovosti;
			
			
		}
		return stavHotovosti;
		
	}


}
