package tovary;

import Exceptions.ZleUdajeException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
/**
 * 
 * @author lucia
 *
 */
public abstract class Tovary implements java.io.Serializable { //abstract
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
/**
 * 
 * @param nazov
 * @param pocet
 * @param druh
 */
	public Tovary(String nazov, int pocet, String druh) {
		this.nazov = nazov;
		this.pocet = pocet;
		this.druh = druh;
		
	}
	
	
	
	//public abstract int predatTovar(Tovary tovar, int pocet);
	/**
	 * 
	 * @param tovar
	 */
	public abstract void odpisatTovar(Tovary tovar);
/**
 * 
 * @param tovar
 * @param pocet
 * @throws ZleUdajeException
 */
	public abstract void predatTovar(Tovary tovar, int pocet) throws ZleUdajeException;

	@Override
	public String toString() {
		return "Tovary:  nazov=" + nazov + ", pocet=" + pocet;
	}


	
	

}

//ked sa preda tovar zapisu sa peniaze vzdy ine - polymorfizmus?
//predatTovar
//pridaj tovar