/**
 * 
 * Listenable holds a single Listener of type L which it can send and message of type M to.
 * 
 * @author Mathieu Belzile-Ha
 *
 * @param <A> argument
 * @param <L> Listener
 */

public class Listenable<M, L extends Listener<M>> {

	private L listener;
	
	/**
	 * Sets the listener it will be communicating with
	 * @param listener
	 */
	public void setListener(L listener){
		this.listener = listener;
	}
	
	/**
	 * removes the assigned listener, if there was one
	 */
	public void dismissListener(){
		this.listener = null;
	}
	
	/**
	 * sends a message of type M to the listener
	 * @param message
	 */
	public void notifyListener(M message){
		if (listener == null){
			return;
		}
		this.listener.notify(message);
	}
}
