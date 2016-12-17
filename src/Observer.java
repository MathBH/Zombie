/**
 * 
 * Observer reacts to given arguments of type A.
 * @author Mathieu Belzile-Ha
 *
 * @param <A>
 */
public interface Observer<A> {
	public void notify(A arg);
}
