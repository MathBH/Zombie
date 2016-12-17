/**
 * Refactoring exercise for Solo Assignment COMP 3721: due 16 Dec. at midnight
 */
public class Zombie {
	private int UNIQUE_ID;
	private String NAME;
	private int LIMB_COUNT;
	private boolean HORDE_MEMBER;

	Zombie(int ID, String name, int numLimbs, boolean hordeStatus){
		setZombieID(ID);
		setZombieName(name);
		setLimbCount(numLimbs);
		setHordeStatus(hordeStatus);
	}

	/**
	 * Retrieves a zombie's ID Number
	 * @return Zombie's Unique ID number
	 */
	public int getZombieID(){
		return UNIQUE_ID;
	}

	/**
	 * Assigns a specified ID number to a zombie.
	 * @param id ID number to assign.
	 */
	public void setZombieID(int id){
		UNIQUE_ID = id;
	}

	/**
	 * Retrieves a zombie's name.
	 * @return A zombie's name.
	 */
	public String getZombieName(){
		return NAME;
	}

	/**
	 * Assigns specified name to a zombie.
	 * @param name Name to be assigned.
	 */
	public void setZombieName(String name){
		NAME = name;
	}

	/**
	 * Retrieves the limb count of a specified zombie.
	 * throws an IllegalArgumentException if a number less 
	 * than 0 or more than 4 is attempted to be assigned.
	 * @return The number of limbs.
	 */
	public int getLimbCount(){
		return LIMB_COUNT;
	}

	/**
	 * Assigns the number of limbs to a zombie.
	 * @param limbs The number of limbs of the zombie.
	 */
	public void setLimbCount(int limbs){
		if(limbs < 0 || limbs > 4){
			throw new IllegalArgumentException();
		}
		LIMB_COUNT = limbs;
	}

	/**
	 * Gets the horde status of a specified zombie.
	 * @return true if zombie is a member of the horde, false if it is not.
	 */
	public boolean getHordeStatus(){
		return HORDE_MEMBER;
	}

	/**
	 * Method to change the horde status of a zombie.
	 * @param hordeStatus
	 */
	
	public void setHordeStatus(boolean hordeStatus){
		HORDE_MEMBER = hordeStatus;
	}
	
	public void leaveHorde(AbstractHorde horde){
		if (horde.contains(this))
			horde.remove(this);
	}
}