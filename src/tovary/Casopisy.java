package tovary;

import Exceptions.ZleUdajeException;
import hotovost.ManageMoney;
import hotovost.ManazerHotovosti;
/**
 * Trieda èasopisy dedí z nadtriedy Tovary
 * @author Lucia Rapánová
 *
 */
public class Casopisy extends Tovary {

	private boolean isValid = false;
	private int flag = 0;
	/**
	 * Druh èasopisov, ktoré sa dajú vytvori
	 * @author Lucia Rapánová
	 */
	private enum DruhCasopisov {
		  Zahradkar("Zahradkar"),
		  Byvanie("Byvanie"),
		  Tyzden("Tyzden"),
		  Kreativ("Kreativ"),
		  Geo("Geo");
		
        private String nazovDruhu;
        
        private DruhCasopisov(String nazov) {
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
/**
 * Konštruktor èasopisov, v ktorom sa kontroluje, èi bol zadaný korektný druh tovaru
 * @param nazov je názov èasopisu
 * @param pocet ko¾ko tovaru chceme vytvori
 * @param druh je druh tovaru (enum)
 */
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
	}

	public boolean isValid() {
	    return isValid;
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
		
	}

}
