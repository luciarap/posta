package zasielky;

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

	public Dobierka(String meno, String priezvisko, String ulica, int cislo, int psc, String Mesto, double suma, double hmotnost) {
		super(meno, priezvisko, ulica, cislo, psc, Mesto);
		this.suma = suma;
		this.hmotnost = hmotnost;
		// TODO Auto-generated constructor stub
	}


}
