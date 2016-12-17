import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestPopulationGenerator {

	private static AbstractPopulationGenerator generator;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		generator = new PopulationGenerator();
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
	public void testNoArguments() {
		AbstractPopulation p = generator.generatePopulation();
		assertTrue(p.getHordes().isEmpty());
	}

	@Test
	public void testNameArguments() {
		AbstractPopulation p = generator.generatePopulation("Ottawa", "NewRaisin", "ChestNut", "Turkey", "yes", "hurray");
		assertTrue(p.getHordes().size() == 6);
		assertTrue(p.getHordes().get(0).getName().equals("Ottawa"));
		assertTrue(p.getHordes().get(1).getName().equals("NewRaisin"));
		assertTrue(p.getHordes().get(2).getName().equals("ChestNut"));
		assertTrue(p.getHordes().get(3).getName().equals("Turkey"));
		assertTrue(p.getHordes().get(4).getName().equals("yes"));
		assertTrue(p.getHordes().get(5).getName().equals("hurray"));
	}
}
