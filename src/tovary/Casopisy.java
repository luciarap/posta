package tovary;

import Posta.ZleUdajeException;
import tovary.Noviny.DruhNovin;

public class Casopisy extends Tovary {
	
	private boolean isValid = false;
	private int flag = 0;
	
	public enum DruhCasopisov {
		  Zahradkar("Zahradkar"),
		  Byvanie("Byvanie"),
		  Tyzden("Tyzden"),
		  Kreativ("Kreativ"),
		  Geo("Geo");
		
        private String nazovDruhu;
        
        private DruhCasopisov(String nazov) {
            this.nazovDruhu = nazov;
        }
        
        public boolean equalsName(String otherName) {
            return nazovDruhu.equals(otherName);
        }
        
        public String toString() {
            return this.nazovDruhu;
         }
		}
	//private DruhCasopisov druh;
	public Casopisy(String nazov, int pocet, String druh) {
		super(nazov, pocet, druh);
		
		try {
			
			
			for (DruhCasopisov typ : DruhCasopisov.values()) { 
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

	public boolean isValid() {
	    return isValid;
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
		case "Zahradkar":
			stavHotovosti += pocet*1.30;
			return stavHotovosti;
			
		case "Byvanie":
			stavHotovosti += pocet*2;
			return stavHotovosti;
		
		case "Tyzden":
			stavHotovosti += pocet*1;
			return stavHotovosti;
		
		case "Kreativ":
			stavHotovosti += pocet*2.80;
			return stavHotovosti;
		
		case "Geo":
			stavHotovosti += pocet*3;
			return stavHotovosti;
		default: System.out.println("CHYBA");
			
			
		}
		return stavHotovosti;*/
		
	}

}
