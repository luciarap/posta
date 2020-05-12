package tovary;
public class Noviny extends Tovary {
	
	public enum DruhNovin {
		  NovyCas,
		  Sme,
		  Pravda,
		  Hospodarske,
		  Dnes
		}
	//private DruhNovin druh;
	public Noviny(String nazov, int pocet, String druh) {
		super(nazov, pocet, druh);
		//this.druh = druh;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void objednatTovar(Tovary tovar, int pocet) {
		tovar.setPocet(pocet + 1);
	}

	@Override
	public void predatTovar(Tovary tovar, int pocet) {
		/*if (pocet > tovar.getPocet() || tovar.getPocet() < 5) {
			objednatTovar(tovar, pocet);
		}
		int aktualnyPocet = tovar.getPocet();
		tovar.setPocet(aktualnyPocet - pocet);
		switch (tovar.getDruh()) {
		case "NovyCas":
			stavHotovosti += pocet*0.65;
			return stavHotovosti;
			
		case "Hospodarske":
			stavHotovosti += pocet*1.20;
			return stavHotovosti;
		
		case "Pravda":
			stavHotovosti += pocet*0.80;
			return stavHotovosti;
		
		case "Sme":
			stavHotovosti += pocet*0.90;
			return stavHotovosti;
		
		case "Dnes":
			stavHotovosti += pocet*1;
			return stavHotovosti;
		default: System.out.println("CHYBA");
			
			
		}
		return stavHotovosti;*/
		
	}

}
