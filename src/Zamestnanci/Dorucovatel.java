package Zamestnanci;

import java.util.ArrayList;

import zasielky.Zasielky;

public class Dorucovatel extends Zamestnanci {
	
	private double stavHotovosti = 0;

	public double getStavHotovosti() {
		return stavHotovosti;
	}

	public void setStavHotovosti(double stavHotovosti) {
		this.stavHotovosti = stavHotovosti;
	}

	public Dorucovatel(String meno, String priezvisko) {
		super(meno, priezvisko);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pridelVyplatu() {
		setMzda(700);
	}
	
	public void odpisZasielky(ArrayList<Zasielky> ar, Zasielky zasielka) {
		ar.remove(zasielka);
		System.out.println("Zasielka bola dorucena.");
	}
	
	public void Dorucit(Zasielky zasielka, ArrayList<Zasielky> ar) {
		zasielka.jeDorucena = true;
		odpisZasielky(ar, zasielka);
	}
	

}
