package zasielky;
/**
 * Trieda Poistenı lisr dedí z nadtriedy Zásielky
 * @author Lucia Rapánová
 *
 */
public class PoistenyList extends Zasielky {
	
	double vyskaPoistneho;
	/**
	 * Konštruktor poisteného listu
	 * @param meno je meno adresáta
	 * @param priezvisko je priezvisko adresáta
	 * @param ulica je ulica adresáta
	 * @param cislo je èíslo domu adresáta
	 * @param psc je PSÈ adresáta
	 * @param Mesto je mesto adresáta
	 * @param vyskaPoistneho je suma vıšky poistenia
	 */
	public PoistenyList(String meno, String priezvisko, String ulica, int cislo, int psc, String Mesto, double vyskaPoistneho) {
		super(meno, priezvisko, ulica, cislo, psc, Mesto);
		this.vyskaPoistneho = vyskaPoistneho; 
		/**
		 * preaenie konštruktora
		 */
		// TODO Auto-generated constructor stub
	}
	


}
