/**
 * 
 * A general controller class
 * @author Mathieu Belzile-Ha
 *
 * @param <M> Model type
 */
public interface Controller<M> extends Runnable{
	public void assignModel(M model);

}
