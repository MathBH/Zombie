import java.util.List;
import java.util.LinkedList;

/**
 * (Side info)
 * Zombie Tracking System.
 * 
 * This is the core class of this program. It allows the assigning of views that allow the user to get feedback from the
 * search module, and from changes in the zombie population.
 * 
 */

/**
 * Zombie Tracking System Model
 * 
 * The model aspect of the Zombie Tracking System. Holds population data and provides access to the search module.
 * 
 * @author Mathieu
 *
 */

public class ZTSModel{
	
	private AbstractPopulation zombiePopulation;
	private ZombieSearchModule searchModule;
	
	public ZTSModel(AbstractPopulation zombiePopulation){
		this.searchModule = new ZombieSearchModule();
		this.zombiePopulation = zombiePopulation;
	}
	
	/**
	 * Assign View to the ZTS
	 * @param view
	 */
	public void assignView(ZTSView view){
		this.searchModule.addObserver(view.getZSMObserver());
		this.zombiePopulation.addObserver(view.getPopulationObserver());
	}
	
	/**
	 * provides access to the ZTS' search module
	 * @return
	 */
	public ZombieSearchModule getSearchModule(){
		this.searchModule.assignPopulation(this.zombiePopulation);
		return this.searchModule;
	}
}