import java.util.List;

/**
 * A notification depicting a recent change to the Population.
 * 
 * Holds the Zombie affected, the Horde it was in, and data on the rest of the population.
 * 
 * @author Mathieu Belzile-Ha
 *
 */

public class PopulationNotification {
	
	private AbstractPopulation population;
	private HordeNotification hordeNotification;
	
	public PopulationNotification(Population changedPopulation, HordeNotification hordeNotification){
		this.population = changedPopulation;
		this.hordeNotification = hordeNotification;
	}
	
	/**
	 * @return population data
	 */
	public AbstractPopulation getPopulation(){
		return this.population;
	}
	
	/**
	 * 
	 * @return Horde affected
	 */
	public AbstractHorde getHorde(){
		return this.hordeNotification.getHorde();
	}
	
	/**
	 * 
	 * @return zombie affected
	 */
	public Zombie getZombie(){
		return this.hordeNotification.getZombie();
	}
}
