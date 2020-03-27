package zasielky;

import java.util.Date;

public abstract class Zasielky {
	public Date datum;
	public String podacieCislo;
	boolean jeDorucena = false;
	
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
		
		System.out.println(adresa.meno +" "+ adresa.priezvisko +"\n"+ adresa.ulica +" "+ adresa.cislo +"\n"+ adresa.psc +" "+ adresa.mesto);
	}
	
	public void Dorucit(Zasielky zasielka) {
		zasielka.jeDorucena = true;
		
	}


}


