import java.util.Random;
/**
 * 
 * a type of population controller that manipulates the population at random.
 * 
 */

public class PopulationRandomController implements PopulationController{

	private AbstractPopulation model;
	private Random random;
	
	public PopulationRandomController(AbstractPopulation model){
		assignModel(model);
	}
	
	/**
	 * Assigns population to control.
	 */
	
	@Override
	public void assignModel(AbstractPopulation model) {
		this.model = model;
		this.random = new Random();
		
	}

	/**
	 * The run method chooses at random between two ways a zombie may be removed
	 * from a horde
	 * 
	 * one is where the zombie is removed from the horde,
	 * the other is where the zombie leaves the horde.
	 */
	
	@Override
	public void run() {
		
		AbstractHorde horde = model.getHordes().get(random.nextInt(model.getHordes().size()));
		Zombie zombie = horde.getZombies().get(random.nextInt(horde.size()));
		
		switch(random.nextInt(2)){
		case 0:
			horde.remove(zombie);
			break;
		case 1:
			zombie.leaveHorde(horde);
			break;
		}
	}

}
