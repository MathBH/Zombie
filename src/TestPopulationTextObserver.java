import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestPopulationTextObserver {
	
	private static AbstractPopulation population;
	private static PopulationTextObserver observer;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		RandomPopulationGenerator randomGen = null;
		observer = new PopulationTextObserver();
		try {
			randomGen = new RandomPopulationGenerator("src/hordeNameSample.name", "src/zombieNameSample.name");
			population = randomGen.generateRandom(4, 20);
			population.addObserver(observer);
		} catch (FileNotFoundException e) {
		}
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		for (AbstractHorde h: population.getHordes()){
			h.remove(h.getZombies().get(0));
		}
	}

}
