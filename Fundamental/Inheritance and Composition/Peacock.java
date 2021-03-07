package main;

/**
 * Class Representing Peacock
 * @author vishnu.jangid_metacu
 *
 */
public class Peacock extends Bird {
	
	private final String sound; 
	private final String type;
	
	/**
	 * Initialize a Lion Object
	 * @param name String, Name of Peacock
	 * @param weight int, Weight of Peacock
	 * @param age int, Age of Peacock
	 */
	public Peacock(String name,int weight, int age) {
		super(name,weight,age);
		this.sound = "Squawk";
		this.type = "Peacock";
	}

	@Override
	public String getSound(){
		return this.sound;
	}
	
	@Override
	public String getType(){
		return this.type;
	}
}
