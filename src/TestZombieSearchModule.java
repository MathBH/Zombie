import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestZombieSearchModule {
	private static ZombieSearchModule searchModule;
	private static Population p;
	private static int numHordes;
	private static int numZs;
	private static TestObserver tO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		numHordes = 5;
		numZs = 50;
		ZombieFactory zFactory = new ZombieFactory();
		p = new Population();
		searchModule = new ZombieSearchModule(p);
		
		for (int i = 0; i < numHordes; i++){
			Horde h = new Horde("h"+i);
			for (int j = 0; j < numZs; j++){
				h.add(zFactory.buildZombie("h"+i+"z"+j,j%5));
			}
			p.addHorde(h);
		}
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		tO = new TestObserver();
		searchModule.addObserver(tO);
	}

	@After
	public void tearDown() throws Exception {
		searchModule.removeObserver(tO);
	}

	@Test
	public void testIdSearch() {
		for (int i = 0; i < numHordes*numZs; i++){
			searchModule.searchByID(i);
			assertTrue(tO.getZombie().getZombieID() == i);
		}
	}
	
	@Test
	public void testNameSearch() {
		for (int i = 0; i < numHordes; i++){
			for (int j = 0; j < numZs; j++){
				searchModule.searchByName("h"+i+"z"+j);
				assertTrue(tO.getZombie().getZombieName().equals("h"+i+"z"+j));
				assertTrue(tO.getZombie().getZombieID() == i*numZs + j);
			}
		}
	}
	
	private class TestObserver implements ZSMObserver{

		private Zombie zombie;
		
		@Override
		public void notify(Zombie arg) {
			this.zombie = arg;
			
		}
		
		public Zombie getZombie(){
			return this.zombie;
		}
		
	}

}
