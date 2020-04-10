package tovary;


public class Pohladnice extends Tovary {
	
	public enum DruhPohladnic {
		  Narodeniny1,
		  Narodeniny2,
		  Vianoce,
		  VelkaNoc,
		  Meniny
		}
	//private DruhPohladnic druh;
	public Pohladnice(String nazov, int pocet, String druh) {
		super(nazov, pocet, druh);
		//this.druh = druh;
		// TODO Auto-generated constructor stub
	}


	@Override
	public void objednatTovar(Tovary tovar, int pocet) {
		tovar.setPocet(pocet + 5);
	}


	@Override
	public double predatTovar(Tovary tovar, int pocet, double stavHotovosti) {
		if (pocet > tovar.getPocet() || tovar.getPocet() < 5) {
			objednatTovar(tovar, pocet);
		}
		int aktualnyPocet = tovar.getPocet();
		tovar.setPocet(aktualnyPocet - pocet);
		switch (tovar.getDruh()) {
		case "Narodeniny1":
			stavHotovosti += pocet*0.40;
			return stavHotovosti;
			
		case "Narodeniny2":
			stavHotovosti += pocet*0.80;
			return stavHotovosti;
		
		case "Vianoce":
			stavHotovosti += pocet*1;
			return stavHotovosti;
		
		case "VelkaNoc":
			stavHotovosti += pocet*1;
			return stavHotovosti;
		
		case "Meniny":
			stavHotovosti += pocet*0.50;
			return stavHotovosti;
			
		default: System.out.println("CHYBA");
		}
		return stavHotovosti;
		
	}

}
