package zasielky;
/**
 * 
 * @author lucia
 *
 */
public class PoistenyList extends Zasielky {
	
	double vyskaPoistneho;
/**
 * 
 * @param meno
 * @param priezvisko
 * @param ulica
 * @param cislo
 * @param psc
 * @param Mesto
 * @param vyskaPoistneho
 */
	public PoistenyList(String meno, String priezvisko, String ulica, int cislo, int psc, String Mesto, double vyskaPoistneho) {
		super(meno, priezvisko, ulica, cislo, psc, Mesto);
		this.vyskaPoistneho = vyskaPoistneho; //pretazenie konstruktora
		// TODO Auto-generated constructor stub
	}
	


}
