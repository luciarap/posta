package tovary;

import Exceptions.ZleUdajeException;
import hotovost.ManageMoney;
import hotovost.ManazerHotovosti;
/**
 * Trieda noviny dedí z nadtriedy Tovary
 * @author Lucia Rapánová
 *
 */
public class Noviny extends Tovary {
	
	private boolean isValid = false;
	private int flag = 0;
	/**
	 * Druh novín, ktoré sa dajú vytvori
	 * @author Lucia Rapánová
	 */
	private enum DruhNovin {
		  NovyCas("Novy cas"),
		  Sme("Sme"),
		  Pravda("Pravda"),
		  Hospodarske("Hospodarske noviny"),
		  Dnes("Dnes");
		  
	        private String nazovDruhu;
        
	        private DruhNovin(String nazov) {
	            this.nazovDruhu = nazov;
	        }
	        /**
	         * Slúži na porovananie, èi zadaný druh existuje - èi sa rovná nejakému existujúcemu druhu
	         * @param otherName je názov druhu, s ktorým sa porovnáva, èi je druh korektný
	         * @return true, ak sa názvy rovnajú, false, ak nie sú rovnaké
	         */
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
	/**
	 * Konštruktor novín, v ktorom sa kontroluje, èi bol zadaný korektný druh tovaru
	 * @param nazov je názov novín
	 * @param pocet ko¾ko tovaru chceme vytvori
	 * @param druh je druh tovaru (enum)
	 */
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

	}


	@Override
	public void predatTovar(Tovary tovar, int pocet) {
		double celkovaSuma;
		
		ManazerHotovosti manazer = new ManazerHotovosti();
		ManageMoney pridaj = (double stavHotovosti, double suma) -> stavHotovosti = stavHotovosti + suma; 
		/**
		 * lambda výraz na matematickú operáciu, ktorá aktualizuje stav hotovosti
		 */
		
		if (pocet > tovar.getPocet()) {
			System.out.println("Nekorektne mnozstvo tovaru.");
			return;
		}
		
		int aktualnyPocet = tovar.getPocet();
		tovar.setPocet(aktualnyPocet - pocet);
		
		/**
		 * polymorfizmus
		 */
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
		
	}

}
