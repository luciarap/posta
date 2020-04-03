package tovary;

public abstract class Tovary { //abstract
	double cena;
	String nazov;
	int pocet;
	
	public Tovary(double cena, String nazov, int pocet) {
		this.cena = cena;
		this.nazov = nazov;
		this.pocet = pocet;
		
	}

}

//ked sa preda tovar zapisu sa peniaze vzdy ine - polymorfizmus?
//predatTovar
//pridaj tovar