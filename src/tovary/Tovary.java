package tovary;

public abstract class Tovary { //abstract
	private double cena;
	private String nazov;
	private int pocet;
	private String druh;
	
	public String getDruh() {
		return druh;
	}

	public void setDruh(String druh) {
		this.druh = druh;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public String getNazov() {
		return nazov;
	}

	public void setNazov(String nazov) {
		this.nazov = nazov;
	}

	public int getPocet() {
		return pocet;
	}

	public void setPocet(int pocet) {
		this.pocet = pocet;
	}

	public Tovary(String nazov, int pocet, String druh) {
		this.nazov = nazov;
		this.pocet = pocet;
		
	}
	
	//public abstract int predatTovar(Tovary tovar, int pocet);
	public abstract void objednatTovar(Tovary tovar, int pocet);//ked bude pocet < 2 or sth

	public abstract double predatTovar(Tovary tovar, int pocet, double stavHotovosti);

	@Override
	public String toString() {
		return "Tovary [cena=" + cena + ", nazov=" + nazov + ", pocet=" + pocet + "]";
	}
	
	

}

//ked sa preda tovar zapisu sa peniaze vzdy ine - polymorfizmus?
//predatTovar
//pridaj tovar