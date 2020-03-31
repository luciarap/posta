package zasielky;

import java.util.Date;

public class Zasielky {
	public Date datum;
	public String podacieCislo;
	public boolean jeDorucena;
	
	public class Adresa {
		String meno;
		String priezvisko;
		String ulica;
		int cislo;
		int psc;
		String mesto;
	}
	
	public Zasielky(String meno, String priezvisko, String ulica, int cislo, int psc, String Mesto) {
		Date date = new Date();
		this.datum = date;
		Zasielky.Adresa adresa = new Zasielky.Adresa();
		adresa.meno = meno;
		adresa.priezvisko = priezvisko;
		adresa.ulica = ulica;
		adresa.cislo = cislo;
		adresa.psc = psc;
		adresa.mesto = Mesto;
		this.jeDorucena = false;
		
		System.out.println(adresa.meno +" "+ adresa.priezvisko +"\n"+ adresa.ulica +" "+ adresa.cislo +"\n"+ adresa.psc +" "+ adresa.mesto);
	}
	
	/*public String toString() {
		return Adresa.meno +" "+ Adresa.priezvisko +" "+ Adresa.ulica +" "+ Adresa.cislo +" "+ Adresa.psc +" "+ Adresa.mesto ;
	}*/



}


