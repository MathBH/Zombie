import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestPopulation {

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
	public void testInit() {
		Population p1 = new Population();
		Horde h1 = new Horde("bub");
		Zombie z1 = new Zombie(12,"hi",2, false);
		
		assertTrue(p1.getHordes().isEmpty());
		assertTrue(p1.getAllZombies().isEmpty());
		assertFalse(p1.containsHorde(h1));
		assertFalse(p1.containsZombie(z1));
		assertFalse(p1.containsHorde(null));
		assertFalse(p1.containsZombie(null));
	}
	
	@Test
	public void testContainsHorde() {
		Population p1 = new Population();
		Horde h1 = new Horde("bub");
		
		assertFalse(p1.containsHorde(h1));
		
		p1.addHorde(h1);
		
		assertTrue(p1.containsHorde(h1));
		
		p1.removeHorde(h1);
		
		assertFalse(p1.containsHorde(h1));
	}
	
	@Test
	public void testGetHordes() {
		Population p1 = new Population();
		Horde h1 = new Horde("bub");
		Horde h2 = new Horde("yis");
		Horde h3 = new Horde("lol");
		
		assertTrue(p1.getHordes().isEmpty());
		
		p1.addHorde(h1);
		
		assertFalse(p1.getHordes().isEmpty());
		assertTrue(p1.getHordes().size() == 1);
		assertTrue(p1.getHordes().get(0) == h1);
		
		p1.addHorde(h2);
		p1.addHorde(h3);
		
		assertFalse(p1.getHordes().isEmpty());
		assertTrue(p1.getHordes().size() == 3);
		assertTrue(p1.getHordes().get(0) == h1);
		assertTrue(p1.getHordes().get(1) == h2);
		assertTrue(p1.getHordes().get(2) == h3);
	}
	
	@Test
	public void testGetAllZombies() {
		Population p1 = new Population();
		Horde h1 = new Horde("bub");
		Horde h2 = new Horde("yis");
		Horde h3 = new Horde("lol");
		ZombieFactory zFactory = new ZombieFactory();
		
		/**
		 * before filling the hordes, only one is added to the population to
		 * make sure that this will make no difference if zombies are added to a
		 * horde before the horde is added to the population or before it is
		 */
		
		p1.addHorde(h1);
		
		for (int i = 0; i <300; i++){
			h1.add(zFactory.buildZombie("1", i%10));
			h2.add(zFactory.buildZombie("2", i%21));
			h3.add(zFactory.buildZombie("3", i%3));
		}
		
		p1.addHorde(h2);
		p1.addHorde(h3);
		
		for (Zombie z : h1.getZombies()){
			assertTrue(p1.getAllZombies().contains(z));
		}
		for (Zombie z : h2.getZombies()){
			assertTrue(p1.getAllZombies().contains(z));
		}
		for (Zombie z : h3.getZombies()){
			assertTrue(p1.getAllZombies().contains(z));
		}
		
		for (Zombie z : p1.getAllZombies()){
			assertTrue( h1.getZombies().contains(z)
					|| h2.getZombies().contains(z)
					|| h3.getZombies().contains(z));
		}
	}
	
	@Test
	public void testContainsZombie() {
		Population p1 = new Population();
		Horde h1 = new Horde("bub");
		Horde h2 = new Horde("yis");
		Horde h3 = new Horde("lol");
		
		Zombie z1 = new Zombie(12,"hi",4, false);
		
		p1.addHorde(h1);
		
		assertFalse(p1.containsZombie(z1));
		
		h1.add(z1);
		
		assertTrue(p1.containsZombie(z1));
		
		h1.remove(z1);
		
		assertFalse(p1.containsZombie(z1));
		
		ZombieFactory zFactory = new ZombieFactory();
		
		/**
		 * No other horde is added before filling the hordes, thhis is to
		 * make sure that it will make no difference if zombies are added to a
		 * horde before the horde is added to the population or before it is
		 */
		
		for (int i = 0; i <300; i++){
			h1.add(zFactory.buildZombie("1", i%10));
			h2.add(zFactory.buildZombie("2", i%21));
			h3.add(zFactory.buildZombie("3", i%3));
		}
		
		p1.addHorde(h2);
		p1.addHorde(h3);
		
		for (Zombie z : h1.getZombies()){
			assertTrue(p1.containsZombie(z));
		}
		for (Zombie z : h2.getZombies()){
			assertTrue(p1.containsZombie(z));
		}
		for (Zombie z : h3.getZombies()){
			assertTrue(p1.containsZombie(z));
		}
		
	}
	
	@Test
	public void testAddHordde() {
		Population p1 = new Population();
		Horde h1 = new Horde("bub");
		Horde h2 = new Horde("yis");
		Horde h3 = new Horde("lol");

		assertFalse(p1.containsHorde(h1));
		assertFalse(p1.containsHorde(h2));
		assertFalse(p1.containsHorde(h3));
		assertTrue(p1.getHordes().isEmpty());
		assertTrue(p1.getHordes().size() == 0);
		
		p1.addHorde(h1);
		
		assertTrue(p1.containsHorde(h1));
		assertFalse(p1.containsHorde(h2));
		assertFalse(p1.containsHorde(h3));
		assertFalse(p1.getHordes().isEmpty());
		assertTrue(p1.getHordes().size() == 1);
		
		p1.addHorde(h2);
		
		assertTrue(p1.containsHorde(h1));
		assertTrue(p1.containsHorde(h2));
		assertFalse(p1.containsHorde(h3));
		assertFalse(p1.getHordes().isEmpty());
		assertTrue(p1.getHordes().size() == 2);
		
		p1.addHorde(h3);
		
		assertTrue(p1.containsHorde(h1));
		assertTrue(p1.containsHorde(h2));
		assertTrue(p1.containsHorde(h3));
		assertFalse(p1.getHordes().isEmpty());
		assertTrue(p1.getHordes().size() == 3);
	}
	
	@Test
	public void testRemoveHorde() {
		Population p1 = new Population();
		Horde h1 = new Horde("bub");
		Horde h2 = new Horde("yis");
		Horde h3 = new Horde("lol");
		
		p1.addHorde(h1);
		p1.addHorde(h2);
		p1.addHorde(h3);
		
		assertTrue(p1.containsHorde(h1));
		assertTrue(p1.containsHorde(h2));
		assertTrue(p1.containsHorde(h3));
		assertFalse(p1.getHordes().isEmpty());
		assertTrue(p1.getHordes().size() == 3);
		
		p1.removeHorde(h2);
		
		assertTrue(p1.containsHorde(h1));
		assertFalse(p1.containsHorde(h2));
		assertTrue(p1.containsHorde(h3));
		assertFalse(p1.getHordes().isEmpty());
		assertTrue(p1.getHordes().size() == 2);
		
		p1.removeHorde(h3);
		
		assertTrue(p1.containsHorde(h1));
		assertFalse(p1.containsHorde(h2));
		assertFalse(p1.containsHorde(h3));
		assertFalse(p1.getHordes().isEmpty());
		assertTrue(p1.getHordes().size() == 1);
		
		p1.removeHorde(h1);
		
		assertFalse(p1.containsHorde(h1));
		assertFalse(p1.containsHorde(h2));
		assertFalse(p1.containsHorde(h3));
		assertTrue(p1.getHordes().isEmpty());
		assertTrue(p1.getHordes().size() == 0);
	}
	
	@Test
	public void testAlternateAddRemove(){
		Population p1 = new Population();
		Horde h1 = new Horde("bub");
		Horde h2 = new Horde("yis");
		Horde h3 = new Horde("lol");
		
		assertFalse(p1.containsHorde(h1));
		assertFalse(p1.containsHorde(h2));
		assertFalse(p1.containsHorde(h3));
		assertTrue(p1.getHordes().isEmpty());
		assertTrue(p1.getHordes().size() == 0);
		
		p1.addHorde(h1);
		
		assertTrue(p1.containsHorde(h1));
		assertFalse(p1.containsHorde(h2));
		assertFalse(p1.containsHorde(h3));
		assertFalse(p1.getHordes().isEmpty());
		assertTrue(p1.getHordes().size() == 1);
		
		p1.addHorde(h2);
		
		assertTrue(p1.containsHorde(h1));
		assertTrue(p1.containsHorde(h2));
		assertFalse(p1.containsHorde(h3));
		assertFalse(p1.getHordes().isEmpty());
		assertTrue(p1.getHordes().size() == 2);
		
		p1.removeHorde(h1);
		
		assertFalse(p1.containsHorde(h1));
		assertTrue(p1.containsHorde(h2));
		assertFalse(p1.containsHorde(h3));
		assertFalse(p1.getHordes().isEmpty());
		assertTrue(p1.getHordes().size() == 1);
		
		p1.addHorde(h3);
		
		assertFalse(p1.containsHorde(h1));
		assertTrue(p1.containsHorde(h2));
		assertTrue(p1.containsHorde(h3));
		assertFalse(p1.getHordes().isEmpty());
		assertTrue(p1.getHordes().size() == 2);
		
		p1.removeHorde(h2);
		
		assertFalse(p1.containsHorde(h1));
		assertFalse(p1.containsHorde(h2));
		assertTrue(p1.containsHorde(h3));
		assertFalse(p1.getHordes().isEmpty());
		assertTrue(p1.getHordes().size() == 1);
		
		p1.addHorde(h1);
		
		assertTrue(p1.containsHorde(h1));
		assertFalse(p1.containsHorde(h2));
		assertTrue(p1.containsHorde(h3));
		assertFalse(p1.getHordes().isEmpty());
		assertTrue(p1.getHordes().size() == 2);
		
		p1.removeHorde(h1);
		p1.removeHorde(h3);
		
		assertFalse(p1.containsHorde(h1));
		assertFalse(p1.containsHorde(h2));
		assertFalse(p1.containsHorde(h3));
		assertTrue(p1.getHordes().isEmpty());
		assertTrue(p1.getHordes().size() == 0);
		
		//Added this in case that reducing it to empty would cause later adding/removing problems
		
		p1.addHorde(h3);
		
		assertFalse(p1.containsHorde(h1));
		assertFalse(p1.containsHorde(h2));
		assertTrue(p1.containsHorde(h3));
		assertFalse(p1.getHordes().isEmpty());
		assertTrue(p1.getHordes().size() == 1);
		
		p1.addHorde(h2);
		
		assertFalse(p1.containsHorde(h1));
		assertTrue(p1.containsHorde(h2));
		assertTrue(p1.containsHorde(h3));
		assertFalse(p1.getHordes().isEmpty());
		assertTrue(p1.getHordes().size() == 2);
		
		p1.removeHorde(h2);
		
		assertFalse(p1.containsHorde(h1));
		assertFalse(p1.containsHorde(h2));
		assertTrue(p1.containsHorde(h3));
		assertFalse(p1.getHordes().isEmpty());
		assertTrue(p1.getHordes().size() == 1);
		
		p1.addHorde(h1);
		
		assertTrue(p1.containsHorde(h1));
		assertFalse(p1.containsHorde(h2));
		assertTrue(p1.containsHorde(h3));
		assertFalse(p1.getHordes().isEmpty());
		assertTrue(p1.getHordes().size() == 2);
	}

	@Test
	public void testObservable() {
		ZombieFactory zFactory = new ZombieFactory();
		
		Population p1 = new Population();
		TestObserver observer = new TestObserver();
		p1.addObserver(observer);
		
		Horde h1 = new Horde("Horde1");
		Horde h2 = new Horde("Horde2");
		
		for (int i = 0; i < 500; i++){
			h1.add(zFactory.buildZombie("yes", i%6));
			h2.add(zFactory.buildZombie("sophos", i%3));
			assertTrue(observer.getNotification() == null);
		}
		
		p1.addHorde(h1);
		
		assertTrue(observer.getNotification() == null);
		
		p1.addHorde(h2);
		
		assertTrue(observer.getNotification() == null);
		
		p1.removeHorde(h2);
		
		assertTrue(observer.getNotification() == null);
		
		p1.removeHorde(h1);
		
		assertTrue(observer.getNotification() == null);
		
		p1.addHorde(h1);
		p1.addHorde(h2);

		for (int i = 0; i < 500; i++){
			
			Zombie z1 = zFactory.buildZombie("yes", i%6);
			Zombie z2 = zFactory.buildZombie("ok", i%7);
			
			h1.add(z1);
			assertTrue(observer.getNotification().getZombie().equals(z1));
			assertTrue(observer.getNotification().getHorde().getZombies().equals(h1.getZombies()));
			assertTrue(observer.getNotification().getPopulation().getAllZombies().equals(p1.getAllZombies()));
			
			h2.add(z2);
			assertTrue(observer.getNotification().getZombie().equals(z2));
			assertTrue(observer.getNotification().getHorde().getZombies().equals(h2.getZombies()));
			assertTrue(observer.getNotification().getPopulation().getAllZombies().equals(p1.getAllZombies()));
		}
		
	}
	
	private class TestObserver implements PopulationObserver{
		
		private PopulationNotification note;

		@Override
		public void notify(PopulationNotification note) {
			this.note = note;
		}
		
		public PopulationNotification getNotification(){
			return this.note;
		}
	}

}
