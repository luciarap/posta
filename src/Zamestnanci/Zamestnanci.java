package Zamestnanci;

public abstract class Zamestnanci {
	private String meno;
	private String priezvisko;
	private int ID;
	private double mzda;
	
	public Zamestnanci(String meno, String priezvisko) {
		this.meno = meno;
		this.priezvisko = priezvisko;
		this.ID = generovatID();
		System.out.println("Novy zamestnanec: " + meno + " " + priezvisko + " s ID: " + ID);
	}
	
	public String generujPodacieCislo() {
		return "RE" + generovatCislo() + "SK";
	}
	
	public static long generovatCislo() {
	    final long leftLimit = 000000000 ; //final
	    final long rightLimit = 999999999;
	    long cislo = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
	    return cislo;
	}
	
	public static int generovatID() {
	    final int leftLimit = 1111 ; //final
	    final int rightLimit = 9999;
		int cislo = (int) (leftLimit + (Math.random() * (rightLimit - leftLimit)));
		return cislo;
	}

	public abstract void pridelVyplatu();


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
