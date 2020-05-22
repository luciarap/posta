package tovary;
/**
 * @deprecated Generický zoznam napokon nebol v programe použitý
 * @author Lucia Rapánová
 * @param <T> generický element
 */
public class Element<T> {
	private T data;
	private Element<T> next;

	public Element() { }	
	public Element(T d) {
		data = d;
	}
	public T getData() {
		return data;
	}
	public Element<T> getNext() {
		return next;
	}
	public void setData(T d) {
		data = d;
	}
	public void setNext(Element<T> e) {
		next = e;
	}
	public String toString() {
		return data.toString();
	}

}
