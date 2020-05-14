package tovary;

import java.util.ArrayList;

public class Zoznamy<T> {
	private Element<T> head;
	private Element<T> tail;
	
	public void tailInsert(T e) {
		Element<T> sll_e = new Element<T>(e);
		if (head == null) {
			head = sll_e;
			tail = head;
		}
		else {
			tail.setNext(sll_e);
			tail = sll_e;
		}
		tail.setNext(null);
	}
	
	public void print() {
		Element<T> sll_e = head;

		while (sll_e != null) {
			System.out.println(sll_e);
			sll_e = sll_e.getNext();
		}
	}
}
