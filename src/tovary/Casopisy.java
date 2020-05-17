package tovary;

import Posta.ZleUdajeException;
import hotovost.ManageMoney;
import hotovost.ManazerHotovosti;
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
		case "Zahradkar":
			celkovaSuma = pocet*1.30;
			double result1 = manazer.add(ManazerHotovosti.getStavHotovosti(), celkovaSuma, pridaj);
			ManazerHotovosti.setStavHotovosti(result1); 
			break;
		
			
		case "Byvanie":
			celkovaSuma = pocet*2;
			double result2 = manazer.add(ManazerHotovosti.getStavHotovosti(), celkovaSuma, pridaj);
			ManazerHotovosti.setStavHotovosti(result2); 
		
		case "Tyzden":
			celkovaSuma = pocet*1;
			double result3 = manazer.add(ManazerHotovosti.getStavHotovosti(),celkovaSuma, pridaj);
			ManazerHotovosti.setStavHotovosti(result3); 
			break;
		
		case "Kreativ":
			celkovaSuma = pocet*2.80;
			double result4 = manazer.add(ManazerHotovosti.getStavHotovosti(),celkovaSuma, pridaj);
			ManazerHotovosti.setStavHotovosti(result4); 
			break;
		
		case "Geo":
			celkovaSuma = pocet*3;
			double result5 = manazer.add(ManazerHotovosti.getStavHotovosti(),celkovaSuma, pridaj);
			ManazerHotovosti.setStavHotovosti(result5); 
			break;
			
		default: System.out.println("CHYBA");
			
			
		}
		//return stavHotovosti;*/
		
	}

}
