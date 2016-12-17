import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestZombie {

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
	public void testNumLimbs() {
		Zombie z1 = new Zombie(213,"yes", 0, false);
		Zombie z2 = new Zombie(213,"yes", 3, true);
		Zombie z3 = new Zombie(213,"yes", 4, true);
		
		assertTrue(z1.getLimbCount() == 0);
		assertTrue(z2.getLimbCount() == 3);
		assertTrue(z3.getLimbCount() == 4);

		
		try{
		Zombie z4 = new Zombie(213,"yes", -34, false);
		} catch(IllegalArgumentException e1){
			try{
			Zombie z5 = new Zombie(213,"yes", 5, true);
			} catch(IllegalArgumentException e2){
				try{
				Zombie z6 = new Zombie(213,"yes", 6324, false);
				} catch(IllegalArgumentException e3){
					return;
				}
			}
		}
		
		fail();
	}

}
