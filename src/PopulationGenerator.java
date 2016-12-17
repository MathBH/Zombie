/**
 * Implementation of PopulationFactory
 * @author Mathieu
 *
 */
public class PopulationGenerator implements AbstractPopulationGenerator{

	@Override
	public AbstractPopulation generatePopulation(String... names) {
		Population population = new Population();
		
		for (String name : names){
			population.addHorde(new Horde(name));
		}
		
		return population;
	}

}
