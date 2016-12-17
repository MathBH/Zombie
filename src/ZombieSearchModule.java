import java.util.List;

/**
 * 
 * Important module of the Zombie Tracking System.
 * The Zombie Search Module provides all methods necessary for carrying out searches on a given list of Zombies
 * in such a way that they are easy of access to controllers, and is observable such that its findings can be
 * depicted by observers.
 * @author Mathieu Belzile-Ha
 *
 */

public class ZombieSearchModule extends Observable<Zombie, ZSMObserver>{
	
	private CriterionSearch<Zombie> searchEngine;
	private AbstractPopulation populationAssigned;

	public ZombieSearchModule(){
		this.searchEngine = new CriterionSearch<Zombie>();
	}
	
	public ZombieSearchModule(AbstractPopulation population){
		this.searchEngine = new CriterionSearch<Zombie>();
		assignPopulation(population);
	}
	
	public void assignPopulation(AbstractPopulation population){
		this.populationAssigned = population;
	}
	
	public void searchByName(String name){
		if (this.populationAssigned == null)
			return;
		updatePopulationData();
		this.searchEngine.setCriterion(new ZombieNameCriterion(name));
		this.notifyObservers(this.searchEngine.performSearch());
	}
	
	public void searchByID(int id){
		if (this.populationAssigned == null)
			return;
		updatePopulationData();
		this.searchEngine.setCriterion(new ZombieIDCriterion(id));
		this.notifyObservers(this.searchEngine.performSearch());
	}
	
	public void updatePopulationData(){
		if (this.populationAssigned == null)
			return;
		this.searchEngine.setSearchList(this.populationAssigned.getAllZombies());
	}

}
