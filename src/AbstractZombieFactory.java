/**
 * Zombie factory interface.
 * Defines that a Zombie Factory which will build a Zombie based on a given
 * name and limb count.
 * @author Mathieu
 *
 */
public interface AbstractZombieFactory {
	public Zombie buildZombie(String name, int numLimbs);

}
