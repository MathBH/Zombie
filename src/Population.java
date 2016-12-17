import java.util.LinkedList;
import java.util.List;

/**
 * 
 * Implementation of AbstractPopulation
 * 
 * @author Mathieu
 *
 */

public class Population extends AbstractPopulation{

	private List<AbstractHorde> hordes;
	
	public Population(){
		super();
		hordes = new LinkedList<AbstractHorde>();
	}
	
	/**
	 * Add a horde to the population
	 */
	public void addHorde(AbstractHorde horde){
		horde.setListener(this);
		hordes.add(horde);
	}
	
	/**
	 * Remove a horde from the population
	 */
	public void removeHorde(AbstractHorde horde){
		if (this.hordes.contains(horde)){
			horde.dismissListener();
			hordes.remove(horde);
		}
	}
	
	/**
	 * return whether or not the given horde is a part of the population
	 */
	public boolean containsHorde(AbstractHorde horde){
		return this.hordes.contains(horde);
	}
	
	/**
	 * return whether or not the given zombie is part of the population
	 */
	public boolean containsZombie(Zombie zombie){
		return this.getAllZombies().contains(zombie);
	}
	
	/**
	 * return a list of hordes
	 */
	public List<AbstractHorde> getHordes(){
		LinkedList<AbstractHorde> output = new LinkedList<AbstractHorde>();
		for (AbstractHorde horde : hordes)
			output.add(horde);
		return output;
	}
	
	/**
	 * return a list of all zombies in population
	 */
	public List<Zombie> getAllZombies(){
		LinkedList<Zombie> output = new LinkedList<Zombie>();
		for (AbstractHorde horde: this.hordes)
			output.addAll(horde.getZombies());
		return output;
	}

	/**
	 * method by which Hordes may notify the Population
	 */
	public void notify(HordeNotification hordeNotification) {
		this.notifyObservers(new PopulationNotification(this, hordeNotification));
	}
}