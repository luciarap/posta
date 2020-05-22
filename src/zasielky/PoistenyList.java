package zasielky;
/**
 * Trieda Poisten� lisr ded� z nadtriedy Z�sielky
 * @author Lucia Rap�nov�
 *
 */
public class PoistenyList extends Zasielky {

	private static final long serialVersionUID = 1L;
	double vyskaPoistneho;
	/**
	 * Kon�truktor poisten�ho listu
	 * @param meno je meno adres�ta
	 * @param priezvisko je priezvisko adres�ta
	 * @param ulica je ulica adres�ta
	 * @param cislo je ��slo domu adres�ta
	 * @param psc je PS� adres�ta
	 * @param Mesto je mesto adres�ta
	 * @param vyskaPoistneho je suma v��ky poistenia
	 */
	public PoistenyList(String meno, String priezvisko, String ulica, int cislo, int psc, String Mesto, double vyskaPoistneho) {
		super(meno, priezvisko, ulica, cislo, psc, Mesto);
		this.vyskaPoistneho = vyskaPoistneho; 
		/**
		 * pre�a�enie kon�truktora
		 */
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean CheckPodacieCislo(String podacieCislo) {
		int i;
		if (podacieCislo.length() == 13) {
			if (podacieCislo.startsWith("VC") && podacieCislo.endsWith("SK"))  {
				for (i = 2; i <= 10; i++) {
					/**
					 * znamen� to, �e kontroluje, �i je to ��slo
					 */
					if (podacieCislo.matches(".*\\d.*")) continue; 
					else return false;
				}
				
				return true;
			}

		}
		return false;
		
	}
	


}
