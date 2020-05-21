package tovary;

import Exceptions.ZleUdajeException;
import hotovost.ManageMoney;
import hotovost.ManazerHotovosti;

public class Znamky extends Tovary {
	
	private boolean isValid = false;
	private int flag = 0;
	
	private enum DruhZnamok {
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
	public void odpisatTovar(Tovary tovar) {
		//tovar.setPocet(pocet + 10);
	}

	@Override
	public void predatTovar(Tovary tovar, int pocet) {
		
		double celkovaSuma;
		
		ManazerHotovosti manazer = new ManazerHotovosti();
		ManageMoney pridaj = (double stavHotovosti, double suma) -> stavHotovosti = stavHotovosti + suma; 
		System.out.println("PredatTovar pred predajom " + ManazerHotovosti.getStavHotovosti());
		
		if (pocet > tovar.getPocet()) {
			System.out.println("Nekorektne mnozstvo tovaru.");
			//showAlert();
			return;
		}
		
		int aktualnyPocet = tovar.getPocet();
		tovar.setPocet(aktualnyPocet - pocet);
	/*	if (pocet > tovar.getPocet() || tovar.getPocet() < 5) {
			objednatTovar(tovar, pocet);
		}
		int aktualnyPocet = tovar.getPocet();
		tovar.setPocet(aktualnyPocet - pocet);*/
		switch (tovar.getDruh()) {
		case "T1":
			celkovaSuma = pocet*0.80;
			double result1 = manazer.add(ManazerHotovosti.getStavHotovosti(), celkovaSuma, pridaj);
			ManazerHotovosti.setStavHotovosti(result1); 
			break;
		
			
		case "T2":
			celkovaSuma = pocet*0.65;
			double result2 = manazer.add(ManazerHotovosti.getStavHotovosti(), celkovaSuma, pridaj);
			ManazerHotovosti.setStavHotovosti(result2); 
			break;
		
		case "eur1":
			System.out.println("Pocet: " + pocet);
			celkovaSuma = pocet*1;
			System.out.println("Celkova: " + celkovaSuma);
			double result3 = manazer.add(ManazerHotovosti.getStavHotovosti(),celkovaSuma, pridaj);
			System.out.println("Result: " + result3);
			ManazerHotovosti.setStavHotovosti(result3); 
			System.out.println(ManazerHotovosti.getStavHotovosti());
			break;
		
		case "eur2":
			celkovaSuma = pocet*2;
			double result4 = manazer.add(ManazerHotovosti.getStavHotovosti(),celkovaSuma, pridaj);
			ManazerHotovosti.setStavHotovosti(result4); 
			break;
		
		case "eur050":
			celkovaSuma = pocet*0.50;
			double result5 = manazer.add(ManazerHotovosti.getStavHotovosti(),celkovaSuma, pridaj);
			ManazerHotovosti.setStavHotovosti(result5); 
			break;
		default: System.out.println("CHYBA");
			
			
		}
	//	return stavHotovosti;
		
	}


}
