/**
 * I guess this is a factory but I don't like caling it that.
 * 
 * Can build an empty, hordless population or a population with
 * a set of empty hordes from the input name arguments.
 * 
 * @author Mathieu
 *
 */
public interface AbstractPopulationGenerator {
	public AbstractPopulation generatePopulation(String... names);
}
