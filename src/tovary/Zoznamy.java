package tovary;

import java.util.ArrayList;

public class Zoznamy<T> {
	ArrayList<T> zoznam = new ArrayList<T>();
	
	public void add(T t) {
		zoznam.add(t);
	}
	
	public void remove(T t) {
		zoznam.remove(t);
	}
	
	public void print() {
		for (T t: zoznam) {
			System.out.println(t);
		}
	}
}
