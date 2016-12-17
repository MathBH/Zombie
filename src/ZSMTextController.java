import java.util.Scanner;
import java.util.regex.*;

/**
 * Implementation of ZSMController.
 * This controller functions entirely by text entry.
 * 
 * @author Mathieu Belzile-Ha
 *
 */

public class ZSMTextController implements ZSMController{

	private final String INPUT_FORMAT = "search(.*):(.*)";
	private final String ID_TOKEN = "id";
	private final String NAME_TOKEN = "name";
	private final String EXIT = "exit";
	
	private Pattern pattern;
	
	private ZombieSearchModule model;
	private Scanner scanner;
	
	public ZSMTextController(ZombieSearchModule model){
		assignModel(model);
		this.scanner = new Scanner(System.in);
	}
	
	/**
	 * Assigns the Zombie Search Module to control
	 */
	@Override
	public void assignModel(ZombieSearchModule model) {
		this.model = model;
	}

	/**
	 * waits for user input and then parses it
	 */
	@Override
	public void run() {
		parse(scanner.nextLine());
	}
	

	/**
	 * parses a given String
	 */
	private void parse(String line){
		if(line.trim().equals(EXIT)){
			System.exit(0);
		}
		
		String token;
		
		Matcher matcher = Pattern.compile(INPUT_FORMAT).matcher(line);
		
		if (matcher.find()){
			token = matcher.group(1).trim();
			
			if (token.equals(ID_TOKEN))
				interpretIDSearch(matcher.group(2).trim());
			else if(token.endsWith(NAME_TOKEN))
				interpretNameSearch(matcher.group(2).trim());
		}
		
	}
	
	/**
	 * Interprets an ID search request.
	 * 
	 * @param input - text input representing the user requested ID number
	 */
	private void interpretIDSearch(String input){
		try{
			int id = Integer.parseInt(input);
			this.model.searchByID(id);
		} catch(NumberFormatException e){
			return;
		}
	}
	
	/**
	 * Interprets a name search request.
	 * 
	 * @param input - text input representing the user requested name
	 */
	private void interpretNameSearch(String input){
		this.model.searchByName(input);
	}
}
