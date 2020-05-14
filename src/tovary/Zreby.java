package tovary;

import Posta.ZleUdajeException;
import hotovost.ManageMoney;
import hotovost.ManazerHotovosti;

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
	            return nazovDruhu.equals(otherName);
	        }
	        
	        public String toString() {
	            return this.nazovDruhu;
	         }

		}
	public Zreby(String nazov, int pocet, String druh) throws ZleUdajeException{
		super(nazov, pocet, druh);
		
		try {
		
		
		for (DruhZrebov typ : DruhZrebov.values()) { 
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
		}

	}

	public boolean isValid() {
	    return isValid;
	}
	@Override
	public void objednatTovar(Tovary tovar, int pocet) {
		tovar.setPocet(pocet + 50);
	}

	@Override
	public void predatTovar(Tovary tovar, int pocet) {
		
		double celkovaSuma;
		
		ManazerHotovosti manazer = new ManazerHotovosti();
		ManageMoney pridaj = (double stavHotovosti, double suma) -> stavHotovosti = stavHotovosti + suma; 
		System.out.println("PredatTovar pred predajom " + ManazerHotovosti.getStavHotovosti());

		if (pocet > tovar.getPocet() || tovar.getPocet() < 5) {
			objednatTovar(tovar, pocet);
		}
		
		int aktualnyPocet = tovar.getPocet();
		tovar.setPocet(aktualnyPocet - pocet);
		
		switch (tovar.getDruh()) {
		
		case "Prasa v zite":
			celkovaSuma = pocet*0.50;
			double result1 = manazer.add(ManazerHotovosti.getStavHotovosti(), celkovaSuma, pridaj);
			ManazerHotovosti.setStavHotovosti(result1); 
		
		case "Stastne cisla":
			celkovaSuma = pocet*1;
			double result2 = manazer.add(ManazerHotovosti.getStavHotovosti(), celkovaSuma, pridaj);
			ManazerHotovosti.setStavHotovosti(result2); 
		
		case "Cierna perla":
			celkovaSuma = pocet*5;
			double result3 = manazer.add(ManazerHotovosti.getStavHotovosti(),celkovaSuma, pridaj);
			ManazerHotovosti.setStavHotovosti(result3); 
		
		case "Stastie":
			celkovaSuma = pocet*2;
			double result4 = manazer.add(ManazerHotovosti.getStavHotovosti(),celkovaSuma, pridaj);
			ManazerHotovosti.setStavHotovosti(result4); 
			
	//	default: System.out.println("CHYBA");
		}
		//return stavHotovosti;
	}
	

}
