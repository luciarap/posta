package zasielky;

public class Dobierka extends Zasielky {
	double suma;
	double hmotnost;

	public Dobierka(String meno, String priezvisko, String ulica, int cislo, int psc, String Mesto, double suma, double hmotnost) {
		super(meno, priezvisko, ulica, cislo, psc, Mesto);
		this.suma = suma;
		this.hmotnost = hmotnost;
		// TODO Auto-generated constructor stub
	}


}
