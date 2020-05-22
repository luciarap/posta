package Zamestnanci;

import java.util.ArrayList;

import zasielky.Zasielky;
/**
 * 
 * @author lucia
 *
 */
public interface Zamestnanec { //COMPONENT
	public int getID();
	public double getMzda();
	public void add(Zamestnanec zamestnanec);
	public void odstranZamestnanca(Zamestnanec zamestnanec);
	public void dostanVyplatu();
	static ArrayList<Zasielky> ar = new ArrayList<Zasielky>();
	public String getMeno();
	public String getPriezvisko();
	public String getPohlavie();
	public void info();
}
