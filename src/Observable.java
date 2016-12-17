import java.util.LinkedList;
import java.util.List;

/**
 * 
 * Observable holds a List of observers of type O to which it sends arguments of type A.
 * 
 * @author Mathieu
 *
 * @param <A>
 * @param <O>
 */

public abstract class Observable<A, O extends Observer<A>> {
	private List<O> observers;
	
	public Observable(){
		this.observers = new LinkedList<O>();
	}
	
	/**
	 * Add an observer to the list.
	 * @param observer
	 */
	public void addObserver(O observer){
		this.observers.add(observer);
	}

	/**
	 * remove the given observer from the list.
	 * @param observer
	 */
	public void removeObserver(O observer){
		this.observers.remove(observer);
	}
	
	/**
	 * notify all observers of the given argument
	 * @param arg argument to send
	 */
	public void notifyObservers(A arg){
		for (O observer: this.observers)
			observer.notify(arg);
	}

}
