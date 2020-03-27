package zasielky;

public class PoistenyList extends Zasielky {
	
	double vyskaPoistneho;

	public PoistenyList(String meno, String priezvisko, String ulica, int cislo, int psc, String Mesto, double vyskaPoistneho) {
		super(meno, priezvisko, ulica, cislo, psc, Mesto);
		this.vyskaPoistneho = vyskaPoistneho; //overloading
		// TODO Auto-generated constructor stub
	}
	


}
