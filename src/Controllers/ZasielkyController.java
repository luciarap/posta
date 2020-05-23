package Controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import zasielky.Dobierka;
import zasielky.Zasielky;

/**
 * Trieda obsahuje ovl·dacie prvky pre scÈnu so z·sielkami
 * 
 * @author Lucia Rap·nov·
 *
 */
public class ZasielkyController {
	/**
	 * MetÛda naËÌta tovar do s˙boru
	 * 
	 * @param woi array list, v ktorom s˙ uloûenÈ z·sielky
	 * @return vr·ti upraven˝ arraylist
	 */
	public ArrayList<Zasielky> nacitajTovar(ArrayList<Zasielky> woi) {

		try {
			FileInputStream fis = new FileInputStream("serializacia\\doporucenyList.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			// Zasielky wo = null;
			// Zasielky[] woj = new Zasielky[5];
			woi = (ArrayList<Zasielky>) ois.readObject();
			fis.close();
			ois.close();

		} catch (IOException i) {
			System.out.println("chyba pri nacitavani suboru " + i);
		} catch (ClassNotFoundException e1) {
			System.out.println("CHYBA " + e1);
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return woi;
	}

	/**
	 * MetÛda na odstr·nenie z·sielky zo systÈmu (zo s˙boru aj zo zoznamu)
	 * 
	 * @param woi          array list z·sielok
	 * @param itemToRemove z·sielka, ktor· sa m· vymazaù
	 * @return vr·ti upraven˝ array list
	 */
	public ArrayList<Zasielky> dorucZasielku(ArrayList<Zasielky> woi, Zasielky itemToRemove) {
		Iterator<Zasielky> itr = woi.iterator();
		while (itr.hasNext()) {
			Zasielky element = (Zasielky) itr.next();
			if (element == itemToRemove) {
				System.out.println(element);
				System.out.println(itemToRemove);
				System.out.println(woi.size());
				itr.remove();
				FileOutputStream fileOut = null;
				try {
					fileOut = new FileOutputStream("serializacia\\doporucenyList.ser");
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ObjectOutputStream out = null;
				try {
					out = new ObjectOutputStream(fileOut);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					out.writeObject(woi);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;

			}
		}
		return woi;
	}

	/**
	 * MetÛda na uloûenie z·sielky do s˙boru
	 * 
	 * @param woi      array list z·sielok
	 * @param zasielka z·sielka, ktor· sa uklad·
	 * @return vr·ti upraven˝ array list
	 */
	public ArrayList<Zasielky> ulozZasielku(ArrayList<Zasielky> woi, Object zasielka) {
		try {

			FileOutputStream fileOut = new FileOutputStream("serializacia\\doporucenyList.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(woi);
			// out.writeObject(e);
			out.close();
			fileOut.close();
			System.out.printf("Data ulozene");
		} catch (IOException i) {
			i.printStackTrace();
		}
		return woi;
	}

}
