package Zamestnanci;

public class Zamestnanci {
	String meno;
	String priezvisko;
	int ID;
	double mzda;
	
	public Zamestnanci(String meno, String priezvisko) {
		this.meno = meno;
		this.priezvisko = priezvisko;
		//id nahodne cislo
		System.out.println("Novy zamestnanec: " + meno + " " + priezvisko);
	}

}
