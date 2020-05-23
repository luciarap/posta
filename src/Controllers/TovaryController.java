package Controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import javafx.stage.Stage;
import tovary.Tovary;
import tovary.Znamky;
import zasielky.Zasielky;

/**
 * Trieda obsahuje ovl�dacie prvky pre sc�nu s tovarmi
 * 
 * @author Lucia Rap�nov�
 *
 */
public class TovaryController {
	/**
	 * Met�da na��ta tovar zo s�boru do arraylistu
	 * 
	 * @param woi je arraylist, do ktor�ho sa uklad� zoznam tovarov
	 * @return woi aktualizovan� arraylist tovarov
	 */
	public ArrayList<Tovary> nacitajTovar(ArrayList<Tovary> woi) {

		try {
			FileInputStream fis = new FileInputStream("serializacia\\tovary.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
		//	Tovary wo = null;
		//	Tovary[] woj = new Tovary[5];
		//	fis.close();
		//	ois.close();
			/**
			 * Zoznam tovarov je ulo�en� v Arrayliste, ktor� je ulo�en� v s�bore
			 */
			woi = (ArrayList<Tovary>) ois.readObject();

		} catch (IOException i) {
			System.out.println("chyba pri nacitani suboru" + i);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return woi;
	}

	/**
	 * Met�da odstr�ni tovar zo s�boru
	 * 
	 * @param woi          je arraylist, do ktor�ho sa uklad� zoznam tovarov
	 * @param itemToRemove je tovar, ktor� sa odstra�uje
	 * @return woi aktualizovan� arraylist tovarov
	 */
	public ArrayList<Tovary> odstranTovar(ArrayList<Tovary> woi, Tovary itemToRemove) {

		Iterator<Tovary> itr = woi.iterator();
		while (itr.hasNext()) {
			Tovary element = (Tovary) itr.next();
			if (element == itemToRemove) {
				System.out.println(element);
				System.out.println(itemToRemove);
				System.out.println(woi.size());
				itr.remove();
				FileOutputStream fileOut = null;
				try {
					fileOut = new FileOutputStream("serializacia\\tovary.ser");
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

		System.out.println(itemToRemove);
		System.out.println(woi.size());
		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream("serializacia\\tovary.ser");
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

		return woi;

	}

	/**
	 * Met�da aktualizuje inform�cie o tovare v s�bore
	 * 
	 * @param woi        je arraylist, do ktor�ho sa uklad� zoznam tovarov
	 * @param itemToSell je tovar, ktor� sa pred�va
	 * @return woi aktualizovan� arraylist tovarov
	 */
	public ArrayList<Tovary> predatTovar(ArrayList<Tovary> woi, Tovary itemToSell) {

		System.out.println(itemToSell);
		System.out.println(woi.size());
		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream("serializacia\\tovary.ser");
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

		return woi;

	}

	/**
	 * Met�da ulo�� tovar do s�boru
	 * 
	 * @param woi   je arraylist, do ktor�ho sa uklad� zoznam tovarov
	 * @param tovar je tovar, ktor� sa uklad� do s�boru
	 * @return woi aktualizovan� arraylist tovarov
	 */
	public ArrayList<Tovary> ulozTovar(ArrayList<Tovary> woi, Tovary tovar) {

		woi.add(tovar);
		try {

			FileOutputStream fileOut = new FileOutputStream("serializacia\\tovary.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(woi);
			out.close();
			fileOut.close();
			System.out.printf("Data ulozene");
		} catch (IOException i) {
			i.printStackTrace();
		}

		return woi;

	}

}
