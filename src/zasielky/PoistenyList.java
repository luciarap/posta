package zasielky;
/**
 * Trieda Poisten� lisr ded� z nadtriedy Z�sielky
 * @author Lucia Rap�nov�
 *
 */
public class PoistenyList extends Zasielky {
	
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
	


}
