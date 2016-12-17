/**
 * implementation of ZSMObserver that draws only with text.
 * @author Mathieu Belzile-Ha
 *
 */

public class ZSMTextObserver implements ZSMObserver{
	
	private final String NOT_FOUND = "Zombie not found.";

	/**
	 * reads a given notification, in this case a Zombie
	 */
	@Override
	public void notify(Zombie zombie) {
		if (zombie == null){
			System.out.println(NOT_FOUND);
		} else {
			System.out.println(format(zombie));
		}
	}
	
	/**
	 * formats Zombie data and returns the appropriate string representation.
	 * @param zombie
	 * @return
	 */
	private String format(Zombie zombie){
		return "Zombie Found: " + zombie.getZombieName() + ":"
				+ "\n------------------\n"
				+"ID: " + zombie.getZombieID() + "\n"
				+"Limb Count: " + zombie.getLimbCount() + "\n------------------";
	}
}
