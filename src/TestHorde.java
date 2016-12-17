import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestHorde {

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
	public void testName() {
		Horde horde = new Horde("John");
		assertTrue(horde.getName().equals("John"));
	}
	
	@Test
	public void testInit() {
		Horde horde = new Horde("Yes");
		assertTrue(horde.size() == 0);
		assertTrue(horde.getZombies().isEmpty());
	}

	@Test
	public void testAdd() {
		Horde horde = new Horde("John");
		Zombie myZombie = new Zombie(12,"Carrot", 2, false);
		assertFalse(myZombie.getHordeStatus());
		assertFalse(horde.contains(myZombie));
		assertFalse(horde.getZombies().contains(myZombie));
		
		horde.add(myZombie);
		assertTrue(myZombie.getHordeStatus());
		assertTrue(horde.contains(myZombie));
		assertTrue(horde.getZombies().contains(myZombie));
	}

	@Test
	public void testRemove() {
		Horde horde = new Horde("John");
		Zombie myZombie = new Zombie(12,"Carrot", 2, false);
		
		horde.remove(new Zombie(10, "who are you", 2, false));
		
		horde.add(myZombie);
		assertTrue(myZombie.getHordeStatus());
		assertTrue(horde.contains(myZombie));
		assertTrue(horde.getZombies().contains(myZombie));
		
		horde.remove(myZombie);
		assertFalse(myZombie.getHordeStatus());
		assertFalse(horde.contains(myZombie));
		assertFalse(horde.getZombies().contains(myZombie));
		
		horde.remove(myZombie);
		
	}
	
	@Test
	public void testContains() {
		Horde horde = new Horde("Soleil");
		Zombie z1 = new Zombie(1432,"Bobo", 2, false);
		Zombie z2= new Zombie(132,"Lobo", 3, false);
		
		assertFalse(horde.contains(z1));
		assertFalse(horde.contains(z2));
		
		horde.add(z1);
		assertTrue(horde.contains(z1));
		assertFalse(horde.contains(z2));
		
		horde.add(z2);
		assertTrue(horde.contains(z1));
		assertTrue(horde.contains(z2));
		
		horde.remove(z1);
		assertFalse(horde.contains(z1));
		assertTrue(horde.contains(z2));
		
		horde.remove(z2);
		assertFalse(horde.contains(z1));
		assertFalse(horde.contains(z2));
	}

	@Test
	public void testSize() {
		Horde horde = new Horde("Bub");
		assertTrue(horde.size() == 0);
		horde.add(new Zombie(12, "Chub", 3, false));
		assertTrue(horde.size() == 1);
		horde.add(new Zombie(43, "Leslie", 2, false));
		assertTrue(horde.size() == 2);
	}
	
	@Test
	public void stressTest() {
		Horde horde = new Horde("BlindWater");
		assertTrue(horde.getName().equals("BlindWater"));
		assertTrue(horde.size() == 0);
		assertTrue(horde.getZombies().isEmpty());
		
		horde.remove(new Zombie(32,"sadas",2, false));
		
		horde.add(new Zombie(42,"Gabby",3, false));
		assertTrue(horde.getName().equals("BlindWater"));
		assertTrue(horde.size() == 1);
		assertFalse(horde.getZombies().isEmpty());
		
		Zombie myZombie = new Zombie(21,"Rachel",2, false);
		
		assertFalse(horde.contains(myZombie));
		
		horde.add(myZombie);
		assertTrue(horde.size() == 2);
		
		assertTrue(horde.contains(myZombie));
		
		List<Zombie> zombieList = horde.getZombies();
		
		assertTrue(horde.contains(zombieList.get(0)));
		assertTrue(zombieList.get(0).getZombieName().equals("Gabby"));
		assertTrue(zombieList.get(0).getZombieID() == 42);
		assertTrue(zombieList.get(0).getLimbCount() == 3);
		
		assertTrue(zombieList.get(1) == myZombie);
		
		horde.remove(zombieList.get(0));
		assertFalse(horde.contains(zombieList.get(0)));
		assertFalse(horde.getZombies().get(0) == zombieList.get(0));
		assertTrue(horde.getZombies().get(0) == myZombie);
		assertTrue(horde.contains(myZombie));
		
		horde.remove(myZombie);
		assertFalse(horde.contains(myZombie));
		assertTrue(horde.size() == 0);
		
	}
	
	@Test
	public void testListeneable(){
		ZombieFactory zFactory = new ZombieFactory();
		Horde horde = new Horde("Mariam st Graham");
		TestPopulation protoP = new TestPopulation();
		

		for(int i=0; i < 500; i++){
			horde.add(zFactory.buildZombie("hey", i%10));
			assertTrue(protoP.getNotification() == null);
		}
		
		horde.setListener(protoP);
		
		for(int i=0; i < 500; i++){
			horde.add(zFactory.buildZombie("hey", i%10));
			assertTrue(horde.getName().equals(protoP.getNotification().getHorde().getName()));
			assertTrue(horde.getZombies().equals(protoP.getNotification().getHorde().getZombies()));
		}
	}
	
	private class TestPopulation extends Population{

		private HordeNotification note;
		
		@Override
		public void notify(HordeNotification note) {
			this.note = note;
		}
		
		public HordeNotification getNotification(){
			return this.note;
		}
		
	}

}
