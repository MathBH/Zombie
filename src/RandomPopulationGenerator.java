import java.util.List;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Random;

/**
 * A specific type of Population generator that can generate random populations.
 * 
 * 
 * This class interacts with .name files. These files contain a set of names which it uses to
 * pick names at random for either Zombies or Hordes.
 * 
 * @author Mathieu Belzile-Ha
 *
 */

public class RandomPopulationGenerator extends PopulationGenerator{

	private List<String> zombieNames;
	private List<String> hordeNames;
	private Random random;
	private ZombieFactory zombieFactory;
	
	/**
	 * Construtor
	 * 
	 * For a Random Population Generator, two .name file paths must be specified, one for Zombie names and one for Horde names.
	 * @param hordeNamesFilePath
	 * @param zombieNamesFilePath
	 * @throws FileNotFoundException
	 */
	public RandomPopulationGenerator(String hordeNamesFilePath, String zombieNamesFilePath) throws FileNotFoundException{
		NameDataReader nameDataReader = new NameDataReader();
		zombieNames = nameDataReader.readNameData(zombieNamesFilePath);
		hordeNames = nameDataReader.readNameData(hordeNamesFilePath);
		random = new Random();
	}
	
	/**
	 * generates a random population of a given horde count and size
	 */
	public AbstractPopulation generateRandom(int numHordes, int hordeSize){
		zombieFactory = new ZombieFactory();
		
		Population population = new Population();
		
		for (int i =0; i < numHordes; i++)
			population.addHorde(randomHorde(hordeSize));
		
		return population;
	}
	
	/**
	 * helper method that generates a random horde of a given size
	 * @param hordeSize
	 * @return
	 */
	private Horde randomHorde(int hordeSize){
		Horde horde = new Horde(randomHordeName());
		for (int i = 0; i < hordeSize; i++)
			horde.add(zombieFactory.buildZombie(randomZombieName(), randomLimbCount()));
		return horde;
	}
	
	/**
	 * helper method, just a short hand for picking a random zombie name
	 * @return
	 */
	private String randomZombieName(){
		return zombieNames.get(random.nextInt(zombieNames.size()));
	}
	
	/**
	 * helper method, just a short hand for picking a random horde name
	 * @return
	 */
	private String randomHordeName(){
		return hordeNames.get(random.nextInt(hordeNames.size()));
	}
	
	/**
	 * helper method for generating a random limb count
	 * @return
	 */
	private int randomLimbCount(){
		return random.nextInt(5);
	}
}
