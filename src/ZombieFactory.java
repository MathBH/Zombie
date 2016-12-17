
/**
 * Basic Zombie Factory implementation.
 * 
 * Responsible for managing illegal limb count and setting Zombie Horde
 * status to false by default.
 * 
 * @author Mathieu
 *
 */

public class ZombieFactory implements AbstractZombieFactory{
	
	private int id;
	
	public ZombieFactory(){
		this.id = 0;
	}
	
	public Zombie buildZombie(String name, int numLimbs){
		if(numLimbs < 0)
			return new Zombie(id++, name, 0, false);
		else if (numLimbs > 4)
			return new Zombie(id++, name, 4, false);
		return new Zombie(id++, name, numLimbs, false);
	}

}
