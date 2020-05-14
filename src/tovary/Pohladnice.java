package tovary;

import Posta.ZleUdajeException;
import tovary.Noviny.DruhNovin;

public class Pohladnice extends Tovary {
	
	private boolean isValid = false;
	private int flag = 0;
	
	public enum DruhPohladnic {
		  Narodeniny1("Narodeniny druh 1"),
		  Narodeniny2("Narodeniny druh 2"),
		  Vianoce("Vianoce"),
		  VelkaNoc("Velka noc"),
		  Meniny("Meniny");
		  
	        private String nazovDruhu;
	        
	        private DruhPohladnic(String nazov) {
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
	//private DruhPohladnic druh;
	public Pohladnice(String nazov, int pocet, String druh) {
		super(nazov, pocet, druh);
		
		try {
			
			
		for (DruhPohladnic typ : DruhPohladnic.values()) { 
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
		tovar.setPocet(pocet + 5);
	}


	@Override
	public void predatTovar(Tovary tovar, int pocet) {
		/*if (pocet > tovar.getPocet() || tovar.getPocet() < 5) {
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
		return stavHotovosti;*/
		
	}

}
