package main;

/**
 * Class For representing Crocodile
 * @author vishnu.jangid_metacu
 *
 */
public class Crocodile extends Reptile {
	
	private final String sound; 
	private final String type;
	
	/**
	 * Initialize a Crocodile Object
	 * @param name String, Name of Crocodile
	 * @param weight int, Weight of Crocodile
	 * @param age int, Age of Crocodile
	 */
	public Crocodile(String name,int weight, int age) {
		super(name,weight,age);
		this.sound = "Hiss";
		this.type = "Crocodile";
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
