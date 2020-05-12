package tovary;

import Posta.ZleUdajeException;

//konstruktor moze vyhodit vynimku ked dostane udaje, ktore nie su platne pre druh
public class Zreby extends Tovary {
	
	private boolean isValid = false;
	private int flag = 0;
	public enum DruhZrebov {
		  PrasaVZite("Prasa v zite"),
		  StastneCisla("Stastne cislo"),
		  CiernaPerla("Cierna perla"),
		  Stastie("Stastie");
		  
	        private String nazovDruhu;
	        
	        private DruhZrebov(String nazov) {
	            this.nazovDruhu = nazov;
	        }
	        
	        public boolean equalsName(String otherName) {
	            // (otherName == null) check is not needed because name.equals(null) returns false 
	            return nazovDruhu.equals(otherName);
	        }
	        
	        public String toString() {
	            return this.nazovDruhu;
	         }

		}
	//private DruhZrebov druh;
	public Zreby(String nazov, int pocet, String druh) throws ZleUdajeException{
		super(nazov, pocet, druh);
		
		try {
		
		
		for (DruhZrebov typ : DruhZrebov.values()) { 
			if (typ.equalsName(druh)) {
				flag = 1;
			}
		   // System.out.println(typ); 
		}
		
		System.out.println(flag);
		if (flag == 1) isValid = true;
		
		if (flag == 0) throw new ZleUdajeException("Udaje neboli spravne zadane");
		
		}
		
		catch (ZleUdajeException e ) {
			isValid = false;
			System.out.println(e);
		}
		//this.druh = druh;
		// TODO Auto-generated constructor stub
	}

	public boolean isValid() {
	    return isValid;
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
		switch (tovar.getDruh()) {
		case "PrasaVZite":
			stavHotovosti += pocet*0.50;
			return stavHotovosti;
			
		case "StastneCisla":
			stavHotovosti += pocet*1;
			return stavHotovosti;
		
		case "CiernaPerla":
			stavHotovosti += pocet*5;
			return stavHotovosti;
		
		case "Stastie":
			stavHotovosti += pocet*2;
			return stavHotovosti;
		default: System.out.println("CHYBA");
		}
		return stavHotovosti;
	}
	

}
