import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestZombieCriterionSearch {
	
	private static CriterionSearch<Zombie> searcher;
	private static List<Zombie> zombieList;
	private static int listSize;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		listSize = 300;
		
		searcher = new CriterionSearch<Zombie>();
		zombieList = new LinkedList<Zombie>();
		
		ZombieFactory zFactory = new ZombieFactory();
		
		for (int i = 0; i < listSize; i++){
			zombieList.add(zFactory.buildZombie("zombie"+i, i%5));
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
	public void testNameCriterion() {
		Zombie zt = new Zombie(1, "Ellen", 4, false);
		Zombie zf = new Zombie(1, "Ellenn", 4, false);
		ZombieNameCriterion c = nameCrit("Ellen");
		
		assertTrue(c.match(zt));
		assertFalse(c.match(zf));		
	}
	
	@Test
	public void testIDCriterion() {
		Zombie zt = new Zombie(2, "Ellen", 4, false);
		Zombie zf = new Zombie(1, "Bub", 4, false);
		ZombieIDCriterion c = idCrit(2);
		
		assertTrue(c.match(zt));
		assertFalse(c.match(zf));		
	}

	@Test
	public void testSearchByName() {
		searcher.setSearchList(zombieList);
		
		for (int i = 0; i < listSize; i++){
			searcher.setCriterion(nameCrit("zombie"+i));
			assertTrue(searcher.performSearch().equals(zombieList.get(i)));
		}	
	}

	@Test
	public void testSearchByID() {
		searcher.setSearchList(zombieList);
		
		for (int i = 0; i < listSize; i++){
			searcher.setCriterion(idCrit(i));
			assertTrue(searcher.performSearch().equals(zombieList.get(i)));
		}	
	}

	private ZombieNameCriterion nameCrit(String name){
		return new ZombieNameCriterion(name);
	}
	
	private ZombieIDCriterion idCrit(int id){
		return new ZombieIDCriterion(id);
	}
}
