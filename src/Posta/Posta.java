package Posta;
//import javafx.application.Application;

import java.util.ArrayList;

import Zamestnanci.VeduciPosty;
import zasielky.DoporucenyList;
import zasielky.Zasielky;

public class Posta {
	static ArrayList<Zasielky> ar = new ArrayList<Zasielky>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VeduciPosty veduci1 = new VeduciPosty("Jana", "Horvathova");
		DoporucenyList doplist1 = new DoporucenyList();
		veduci1.zapisZasielky(ar, doplist1);
	}

}
