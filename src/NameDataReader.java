import java.util.Scanner;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;

/**
 * A class responsible for reading name data. Name data files end with
 * the ".data" extension.
 * 
 * @author Mathieu
 *
 */

public class NameDataReader{
	
	private final String EXTENSION = ".name";
	
	public List<String> readNameData(String filePath) throws FileNotFoundException{
		if (!filePath.endsWith(EXTENSION))
			throw new IllegalArgumentException();
		
		Scanner scanner = new Scanner(new File(filePath));
		List<String> names = new LinkedList<String>();
		
		while (scanner.hasNext()){
			names.add(scanner.next().trim());
		}
		return names;
	}
}
