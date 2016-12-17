/**
 * 
 * Criterion type for Zombies. Specifies a required ID number.
 * @author Mathieu Belzile-Ha
 *
 */

public class ZombieIDCriterion implements Criterion<Zombie>{
	
	private int expectedID;
	
	public ZombieIDCriterion(int expectedID){
		this.expectedID = expectedID;
	}
	
	public boolean match(Zombie zombie){
		return zombie.getZombieID() == this.expectedID;
	}

}
