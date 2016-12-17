/**
 * 
 * A criterion is responsible for telling if an object of type T matches the criterion it represents.
 * 
 * @author Mathieu Belzile-Ha
 *
 * @param <T> type of object this relates to.
 */
public interface Criterion<T> {
	public boolean match(T candidate);
}
