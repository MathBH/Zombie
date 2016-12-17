/**
 * 
 * Criterion type for Zombies. Specifies a required name.
 * @author Mathieu Belzile-Ha
 *
 */
public class ZombieNameCriterion implements Criterion<Zombie>{

	private String nameExpected;
	
	public ZombieNameCriterion(String nameExpected){
		this.nameExpected = nameExpected;
	}
	
	public boolean match(Zombie zombie) {
		return zombie.getZombieName().equals(this.nameExpected);
	}
	
}
