import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestRandomPopulationGenerator {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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
		RandomPopulationGenerator randomGen = null;
		try {
			randomGen = new RandomPopulationGenerator("src/hordeNameSample.name", "src/zombieNameSample.name");
		} catch (FileNotFoundException e) {
			fail("File not found");
		}
		
		printPopulation(randomGen.generateRandom(4, 10));
		
	}

	private void printPopulation(AbstractPopulation p){
		for (AbstractHorde h : p.getHordes()){
			System.out.println("\n"+h.getName()+"\n-----------------------------");
			
			for (Zombie z : h.getZombies()){
				System.out.print("|"+z.getZombieID()+":"+z.getZombieName()+":"+z.getLimbCount()+"| ");
			}
			
			System.out.println("\n------------------------------------------------");
		}
	}
}
