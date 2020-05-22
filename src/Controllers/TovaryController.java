package Controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import tovary.Tovary;
import tovary.Znamky;
import zasielky.Zasielky;

/**
 * 
 * @author lucia
 *
 */
public class TovaryController {
	/**
	 * 
	 * @param woi
	 * @return
	 */
	public ArrayList<Tovary> nacitajTovar(ArrayList<Tovary> woi) {

		try {
			FileInputStream fis = new FileInputStream("serializacia\\tovary.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Tovary wo = null;
			Tovary[] woj = new Tovary[5];
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
	 * 
	 * @param woi
	 * @param itemToRemove
	 * @return
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
	 * 
	 * @param woi
	 * @param itemToSell
	 * @return
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
	 * 
	 * @param woi
	 * @param tovar
	 * @return
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
