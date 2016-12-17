import java.io.FileNotFoundException;
import java.lang.Thread;
import java.util.concurrent.TimeUnit;

/**
 * Just a main method with a random population controller to demonstrate the Zombie Tracking System.
 * 
 * @author Mathieu Belzile-Ha
 *
 */

public class DemoTool {
	
	private final static String SRC = "src/";
	private final static String ZOMBIENAMEDATA = SRC+"zombieNameSample.name";
	private final static String HORDENAMEDATA = SRC+"hordeNameSample.name";
	
	private final static int HORDE_COUNT = 5;
	private final static int HORDE_SIZE = 25;
	
	public static void main(String[] args){
		
		RandomPopulationGenerator generator = null;
		
		try{
		generator = new RandomPopulationGenerator(HORDENAMEDATA,ZOMBIENAMEDATA);
		}catch (FileNotFoundException e){
			System.err.println("AAAH THE NAME FILES WERE NOT FOUND");
			System.exit(1);
		}
		
		AbstractPopulation population = generator.generateRandom(HORDE_COUNT, HORDE_SIZE);
		ZTSModel ztsModel = new ZTSModel(population);
		ZTSTextView view = new ZTSTextView();
		ztsModel.assignView(view);
		
		ZTSController controller = new ZTSTextController(ztsModel);
		PopulationController pControl = new PopulationRandomController(population);
		
		while(true){
			pControl.run();
			controller.run();
		}
	}
}