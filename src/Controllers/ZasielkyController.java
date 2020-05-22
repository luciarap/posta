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


public class ZasielkyController {
	
	public ArrayList<Zasielky> nacitajTovar(ArrayList<Zasielky> woi) {
		
		try {
			FileInputStream fis = new FileInputStream("serializacia\\doporucenyList.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Zasielky wo = null;
			Zasielky[] woj = new Zasielky[5];

			// ArrayList<Zasielky> woi=new ArrayList<>();
			woi = (ArrayList<Zasielky>) ois.readObject();
		//	fis.close();
		//	ois.close();

		} catch (IOException i) {
			System.out.println("chyba pri nacitavani suboru " + i);
		} catch (ClassNotFoundException e1) {
			System.out.println("CHYBA " + e1);
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return woi;
		
	}
	

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


	public ArrayList<Zasielky> ulozZasielku(ArrayList<Zasielky> woi, Object zasielka) {
		try {

			FileOutputStream fileOut = new FileOutputStream(
					"serializacia\\doporucenyList.ser");
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
