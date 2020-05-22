package zasielky;
/**
 * Trieda Dobierka dedÌ z nadtriedy Zasielky
 * @author Lucia Rap·nov·
 *
 */
public class Dobierka extends Zasielky {
	private double suma;
	private double hmotnost;

	public double getSuma() {
		return suma;
	}

	public void setSuma(double suma) {
		this.suma = suma;
	}

	public double getHmotnost() {
		return hmotnost;
	}

	public void setHmotnost(double hmotnost) {
		this.hmotnost = hmotnost;
	}
/**
 * Konötruktor dobierky
	 * @param meno je meno adres·ta
	 * @param priezvisko je priezvisko adres·ta
	 * @param ulica je ulica adres·ta
	 * @param cislo je ËÌslo domu adres·ta
	 * @param psc je PS» adres·ta
	 * @param Mesto je mesto adres·ta
	 * @param suma je suma dobierky
	 * @param hmotnost je hmotnosù dobierky
 */
	public Dobierka(String meno, String priezvisko, String ulica, int cislo, int psc, String Mesto, double suma, double hmotnost) {
		super(meno, priezvisko, ulica, cislo, psc, Mesto);
		this.suma = suma;
		this.hmotnost = hmotnost;
	}


}
