package zasielky;

/**
 * Trieda  Doporuèený List dedí z nadtriedy Zásielky
 * @author Lucia Rapánová
 *
 */
public class DoporucenyList extends Zasielky{

	private static final long serialVersionUID = 1L;

	/**
	 * Konštruktor doporuèeného listu
	 * @param meno je meno adresáta
	 * @param priezvisko je priezvisko adresáta
	 * @param ulica je ulica adresáta
	 * @param cislo je èíslo domu adresáta
	 * @param psc je PSÈ adresáta
	 * @param Mesto je mesto adresáta
	 */
	public DoporucenyList(String meno, String priezvisko, String ulica, int cislo, int psc, String Mesto) {
		super(meno, priezvisko, ulica, cislo, psc, Mesto);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean CheckPodacieCislo(String podacieCislo) {
		int i;
		if (podacieCislo.length() == 13) {
			if (podacieCislo.startsWith("RE") && podacieCislo.endsWith("SK"))  {
				for (i = 2; i <= 10; i++) {
					/**
					 * znamená to, že kontroluje, èi je to èíslo
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
