package main;

/**
 * Class Representing Lion
 * @author vishnu.jangid_metacu
 *
 */
public class Lion extends Mammal {
	
	private final String sound; 
	private final String type;
	
	/**
	 * Initialize a Lion Object
	 * @param name String, Name of Lion
	 * @param weight int, Weight of Lion
	 * @param age int, Age of Lion
	 */
	public Lion(String name,int weight, int age) {
		super(name,weight,age);
		this.sound = "Roar";
		this.type = "Lion";
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
