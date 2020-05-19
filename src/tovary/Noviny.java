package tovary;

import Exceptions.ZleUdajeException;
import hotovost.ManageMoney;
import hotovost.ManazerHotovosti;
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
	public void odpisatTovar(Tovary tovar) {
		//tovar.setPocet(pocet + 1);
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
		

		switch (tovar.getDruh()) {
		case "Novy cas":
			celkovaSuma = pocet*0.65;
			double result1 = manazer.add(ManazerHotovosti.getStavHotovosti(), celkovaSuma, pridaj);
			ManazerHotovosti.setStavHotovosti(result1); 
			break;
		
			
		case "Hospodarske noviny":
			celkovaSuma = pocet*1.20;
			double result2 = manazer.add(ManazerHotovosti.getStavHotovosti(), celkovaSuma, pridaj);
			ManazerHotovosti.setStavHotovosti(result2); 
			break;
		
		case "Pravda":
			celkovaSuma = pocet*0.80;
			double result3 = manazer.add(ManazerHotovosti.getStavHotovosti(),celkovaSuma, pridaj);
			ManazerHotovosti.setStavHotovosti(result3); 
			break;
		
		case "Sme":
			celkovaSuma = pocet*0.90;
			double result4 = manazer.add(ManazerHotovosti.getStavHotovosti(),celkovaSuma, pridaj);
			ManazerHotovosti.setStavHotovosti(result4); 
			break;
		
		case "Dnes":
			celkovaSuma = pocet*1;
			double result5 = manazer.add(ManazerHotovosti.getStavHotovosti(),celkovaSuma, pridaj);
			ManazerHotovosti.setStavHotovosti(result5); 
			break;
		default: System.out.println("CHYBA");
			
			
		}
		//return stavHotovosti;*/
		
	}

}
