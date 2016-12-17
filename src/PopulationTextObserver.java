import java.util.List;

/**
 * A population observer that depicts the population entirely by text.
 * @author Mathieu Belzile-Ha
 *
 */

public class PopulationTextObserver implements PopulationObserver{

	@Override
	public void notify(PopulationNotification notification) {
		System.out.println(parsePopulation(notification.getPopulation()));
		System.out.println("-------------------------------------------------------");
		System.out.println(parseNotification(notification)); 
	}
	
	/**
	 * reads the notification and returns appropriate string to be displayed
	 * @param notification
	 * @return string to be displayed
	 */
	private String parseNotification(PopulationNotification notification){
		if (!notification.getHorde().contains(notification.getZombie()))
			return parseRemoval(notification.getHorde(), notification.getZombie());
		else
			return parseAddition(notification.getHorde(), notification.getZombie());
	}
	
	/**
	 * formats a String representation for a given Horde and Zombie it knows was removed it.
	 * @param horde
	 * @param zombie
	 * @return formated string
	 */
	private String parseRemoval(AbstractHorde horde, Zombie zombie){
		return "Zombie " + zombie.getZombieName() + " [" + zombie.getZombieID() +"] has been removed from Horde: " + horde.getName() + "."; 
	}

	/**
	 * formats a String representation for a given Horde and Zombie it knows was added to.
	 * @param horde
	 * @param zombie
	 * @return formated string
	 */
	private String parseAddition(AbstractHorde horde, Zombie zombie){
		return "Zombie " + zombie.getZombieName() + " [" + zombie.getZombieID() +"] has joined Horde: " + horde.getName() + ".";
	}
	
	/**
	 * formats a String representation for a population
	 * @param population
	 * @return
	 */
	private String parsePopulation(AbstractPopulation population){
		String output = "\n-----------\nPopulation:\n-----------";
		
		for (AbstractHorde h : population.getHordes()){
			output += "\n\n  Horde" + h.getName() + ":" + "\n  -----------\n    Zombies:";
			for (Zombie z : h.getZombies()){
				output += " [" + z.getZombieID() + "]" + z.getZombieName();
			}
		}
		
		return output+"\n";
		
		}
}
