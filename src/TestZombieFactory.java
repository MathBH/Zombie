import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestZombieFactory {

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
		Zombie myZombie = null;
		ZombieFactory zFactory = new ZombieFactory();
		
		myZombie = zFactory.buildZombie("Harold", 3);
		assertTrue(myZombie.getZombieName().equals("Harold"));
		assertTrue(myZombie.getLimbCount() == 3);
		assertTrue(myZombie.getZombieID() == 0);
		
		myZombie = zFactory.buildZombie("Jake", -4);
		assertTrue(myZombie.getZombieName().equals("Jake"));
		assertTrue(myZombie.getLimbCount() == 0);
		assertTrue(myZombie.getZombieID() == 1);
		
		myZombie = zFactory.buildZombie("Chelsey", 4324);
		assertTrue(myZombie.getZombieName().equals("Chelsey"));
		assertTrue(myZombie.getLimbCount() == 4);
		assertTrue(myZombie.getZombieID() == 2);
		
		myZombie = zFactory.buildZombie("Marge", 0);
		assertTrue(myZombie.getZombieName().equals("Marge"));
		assertTrue(myZombie.getLimbCount() == 0);
		assertTrue(myZombie.getZombieID() == 3);
		
		myZombie = zFactory.buildZombie("Maggy", -1);
		assertTrue(myZombie.getZombieName().equals("Maggy"));
		assertTrue(myZombie.getLimbCount() == 0);
		assertTrue(myZombie.getZombieID() == 4);
		
		myZombie = zFactory.buildZombie("Magnum", 4);
		assertTrue(myZombie.getZombieName().equals("Magnum"));
		assertTrue(myZombie.getLimbCount() == 4);
		assertTrue(myZombie.getZombieID() == 5);
		
		myZombie = zFactory.buildZombie("Yis", 5);
		assertTrue(myZombie.getZombieName().equals("Yis"));
		assertTrue(myZombie.getLimbCount() == 4);
		assertTrue(myZombie.getZombieID() == 6);
	}

}
