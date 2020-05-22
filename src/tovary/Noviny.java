package tovary;

import Exceptions.ZleUdajeException;
import hotovost.ManageMoney;
import hotovost.ManazerHotovosti;
/**
 * Trieda noviny ded� z nadtriedy Tovary
 * @author Lucia Rap�nov�
 *
 */
public class Noviny extends Tovary {
	
	private boolean isValid = false;
	private int flag = 0;
	/**
	 * Druh nov�n, ktor� sa daj� vytvori�
	 * @author Lucia Rap�nov�
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
	         * Sl��i na porovananie, �i zadan� druh existuje - �i sa rovn� nejak�mu existuj�cemu druhu
	         * @param otherName je n�zov druhu, s ktor�m sa porovn�va, �i je druh korektn�
	         * @return true, ak sa n�zvy rovnaj�, false, ak nie s� rovnak�
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
	 * Kon�truktor nov�n, v ktorom sa kontroluje, �i bol zadan� korektn� druh tovaru
	 * @param nazov je n�zov nov�n
	 * @param pocet ko�ko tovaru chceme vytvori�
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
		 * lambda v�raz na matematick� oper�ciu, ktor� aktualizuje stav hotovosti
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
