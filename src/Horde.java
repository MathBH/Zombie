import java.util.LinkedList;
import java.util.List;
/**
 * 
 * An implementation of AbstractHorde
 * 
 * @author Mathieu Belzile-Ha
 *
 */

public class Horde extends AbstractHorde{

	private List<Zombie> zombies;
	private String name;
	
	public Horde(String name){
		this.zombies = new LinkedList<Zombie>();
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void add(Zombie zombie) {
		this.zombies.add(zombie);
		zombie.setHordeStatus(true);
		this.notifyListener(new HordeNotification(this, zombie));
		
	}

	public void remove(Zombie zombie) {
		this.zombies.remove(zombie);
		zombie.setHordeStatus(false);
		this.notifyListener(new HordeNotification(this, zombie));
		
	}

	public boolean contains(Zombie zombie) {
		return zombies.contains(zombie);
	}
	
	public int size(){
		return zombies.size();
	}

	public List<Zombie> getZombies() {
		LinkedList<Zombie> output = new LinkedList<Zombie>();
		for (Zombie zombie: this.zombies)
			output.add(zombie);
		return output;
	}
}
