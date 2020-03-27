package Zamestnanci;

public abstract class Zamestnanci {
	private String meno;
	private String priezvisko;
	private int ID;
	private double mzda;
	
	public Zamestnanci(String meno, String priezvisko) {
		this.meno = meno;
		this.priezvisko = priezvisko;
		//id nahodne cislo
		System.out.println("Novy zamestnanec: " + meno + " " + priezvisko);
	}
	

	public abstract void pridelVyplatu(double suma);


	public String getMeno() {
		return meno;
	}


	public void setMeno(String meno) {
		this.meno = meno;
	}


	public String getPriezvisko() {
		return priezvisko;
	}


	public void setPriezvisko(String priezvisko) {
		this.priezvisko = priezvisko;
	}


	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public double getMzda() {
		return mzda;
	}


	public void setMzda(double mzda) {
		this.mzda = mzda;
	}
	
	

}
