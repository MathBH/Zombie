import java.util.List;

/**
 * A set of Hordes. The population is a Listener that recieves HordeNotifications.
 * 
 * It is responsible for providing information and access to its hordes and can add or remove hordes.
 * 
 * @author Mathieu Belzile-Ha
 *
 */

public abstract class AbstractPopulation extends Observable<PopulationNotification, PopulationObserver> implements Listener<HordeNotification>{
	public abstract void addHorde(AbstractHorde horde);
	public abstract void removeHorde(AbstractHorde horde);
	public abstract boolean containsHorde(AbstractHorde horde);
	public abstract boolean containsZombie(Zombie zombie);
	public abstract List<AbstractHorde> getHordes();
	public abstract List<Zombie> getAllZombies();

}
