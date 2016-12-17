import java.util.List;
/**
 * 
 * Interface for the Horde class.
 * 
 * Responsible for adding, removing and providing information about its zombies.
 * A horde is a part of a Population and is thus listenable by it.
 * 
 * @author Mathieu Belzile-Ha
 *
 */
public abstract class AbstractHorde extends Listenable<HordeNotification, Population>{
	
	public abstract void add(Zombie zombie);
	public abstract void remove(Zombie zombie);
	public abstract boolean contains(Zombie zombie);
	public abstract List<Zombie> getZombies();
	public abstract String getName();
	public abstract int size();

}
