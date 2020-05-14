package tovary;

import Posta.ZleUdajeException;
import hotovost.ManageMoney;
import hotovost.ManazerHotovosti;
import tovary.Zreby.DruhZrebov;

public class Znamky extends Tovary {
	
	private boolean isValid = false;
	private int flag = 0;
	
	public enum DruhZnamok {
		  T1("T1"),
		  T2("T2"),
		  eur1("eur1"),
		  eur2("eur2"),
		  eur050("eur050");
        private String nazovDruhu;
        
        private DruhZnamok(String nazov) {
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
	//private String druh;
	//private DruhZnamok druhZ;
	public Znamky(String nazov, int pocet, String druh) {
		super(nazov, pocet, druh);
		
		try {
			
			
		for (DruhZnamok typ : DruhZnamok.values()) { 
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
			//alert tu ako, osetrenie
		}

	}

	@Override
	public void objednatTovar(Tovary tovar, int pocet) {
		tovar.setPocet(pocet + 10);
	}

	@Override
	public void predatTovar(Tovary tovar, int pocet) {
		
	/*	if (pocet > tovar.getPocet() || tovar.getPocet() < 5) {
			objednatTovar(tovar, pocet);
		}
		int aktualnyPocet = tovar.getPocet();
		tovar.setPocet(aktualnyPocet - pocet);
		switch (tovar.getDruh()) {
		case "T1":
			stavHotovosti += pocet*0.80;
			return stavHotovosti;
			
		case "T2":
			stavHotovosti += pocet*0.65;
			return stavHotovosti;
		
		case "eur1":
			stavHotovosti += pocet*1;
			return stavHotovosti;
		
		case "eur2":
			stavHotovosti += pocet*2;
			return stavHotovosti;
		
		case "eur050":
			stavHotovosti += pocet*0.50;
			return stavHotovosti;
		default: System.out.println("CHYBA");
			
			
		}
		return stavHotovosti;
		*/
	}


}
