package zasielky;

/**
 * Trieda Dobierka ded� z nadtriedy Zasielky
 * 
 * @author Lucia Rap�nov�
 *
 */
public class Dobierka extends Zasielky {

	private static final long serialVersionUID = 1L;
	private double suma;
	private double hmotnost;

	/**
	 * 
	 * @return vr�ti sumu dobierky
	 */
	public double getSuma() {
		return suma;
	}

	/**
	 * 
	 * @param suma je suma dobierky
	 */
	public void setSuma(double suma) {
		this.suma = suma;
	}

	/**
	 * 
	 * @return hmotnos� dobierky
	 */
	public double getHmotnost() {
		return hmotnost;
	}

	/**
	 * 
	 * @param hmotnost je hmotnos� dobierky
	 */
	public void setHmotnost(double hmotnost) {
		this.hmotnost = hmotnost;
	}

	/**
	 * Kon�truktor dobierky
	 * 
	 * @param meno       je meno adres�ta
	 * @param priezvisko je priezvisko adres�ta
	 * @param ulica      je ulica adres�ta
	 * @param cislo      je ��slo domu adres�ta
	 * @param psc        je PS� adres�ta
	 * @param Mesto      je mesto adres�ta
	 * @param suma       je suma dobierky
	 * @param hmotnost   je hmotnos� dobierky
	 */
	public Dobierka(String meno, String priezvisko, String ulica, int cislo, int psc, String Mesto, double suma,
			double hmotnost) {
		super(meno, priezvisko, ulica, cislo, psc, Mesto);
		this.suma = suma;
		this.hmotnost = hmotnost;
	}

	@Override
	public boolean CheckPodacieCislo(String podacieCislo) {
		int i;
		if (podacieCislo.length() == 13) {
			if (podacieCislo.startsWith("RE") && podacieCislo.endsWith("SK")) {
				for (i = 2; i <= 10; i++) {
					/**
					 * znamen� to, �e kontroluje, �i je to ��slo
					 */
					if (podacieCislo.matches(".*\\d.*"))
						continue;
					else
						return false;
				}

				return true;
			}

		}
		return false;

	}

}
