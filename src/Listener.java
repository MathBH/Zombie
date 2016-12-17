/**
 * 
 * The Listener can be assigned to any compatible Listenable object.
 * The Listener can be notified of a message of type M.
 * 
 * @author Mathieu Belzile-Ha
 *
 * @param <A>
 */


public interface Listener<M> {
	
	public void notify(M message);
}
