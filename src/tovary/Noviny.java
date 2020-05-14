package tovary;

import Posta.ZleUdajeException;
import tovary.Zreby.DruhZrebov;

public class Noviny extends Tovary {
	
	private boolean isValid = false;
	private int flag = 0;
	
	public enum DruhNovin {
		  NovyCas("Novy cas"),
		  Sme("Sme"),
		  Pravda("Pravda"),
		  Hospodarske("Hospodarske noviny"),
		  Dnes("Dnes");
		  
	        private String nazovDruhu;
        
	        private DruhNovin(String nazov) {
	            this.nazovDruhu = nazov;
	        }
	        
	        public boolean equalsName(String otherName) {
	            return nazovDruhu.equals(otherName);
	        }
	        
	        public String toString() {
	            return this.nazovDruhu;
	         }

		}
	
	public boolean isValid() {
	    return isValid;
	}
	//private DruhNovin druh;
	public Noviny(String nazov, int pocet, String druh) {
		super(nazov, pocet, druh);
		try {
			
			
		for (DruhNovin typ : DruhNovin.values()) { 
			if (typ.equalsName(druh)) {
				flag = 1;
			}
		}

		if (flag == 1) isValid = true;
		
		if (flag == 0) throw new ZleUdajeException("Udaje neboli spravne zadane");
		
		}
		
		catch (ZleUdajeException e ) {
			isValid = false;
			System.out.println(e);
			e.ShowAlert();
		}
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
