import java.util.List;
/**
 * 
 * Holds about a change in a given Horde. Holds the zombie that left or joined and the Horde affected.
 * 
 * TODO: Make a ReadOnly thing for Horde.
 * 
 * @author Mathieu Belzile-Ha
 *
 */
public class HordeNotification {
	
	private AbstractHorde horde;
	private Zombie changedZombie;
	
	public HordeNotification(Horde horde, Zombie changedZombie){
		this.horde = horde;
		this.changedZombie = changedZombie;
	}
	
	/**
	 * gets the horde that was changed
	 * 
	 * @return changed horde
	 */
	public AbstractHorde getHorde(){
		return this.horde;
	}
	
	/**
	 * gets the zombie affected by the change
	 * 
	 * @return zombie affected by change
	 */
	public Zombie getZombie(){
		return this.changedZombie;
	}
}
