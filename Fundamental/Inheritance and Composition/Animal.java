package main;

/**
 * 
 * @author vishnu.jangid_metacu
 *
 */
public abstract class Animal {
	
	private final String name;
	private final int id ;
	private int age;
	private int weight;
	
	
	private static int idCount = 1;
	
	/**
	 * Initialize Animal passing name, weight and age
	 * @param name String, name of Animal
	 * @param weight int, Weight of Animal
	 * @param age int, Age of Animal
	 */
	public Animal(String name,int weight, int age) {
		this.name = name;
		this.id = idCount;
		Animal.idCount ++;
		this.age = age;
		this.weight = weight;
	}
	
	/**
	 * get Weight of Animal
	 * @return int, Weight of Animal
	 */
	public int getWeight(){
		return this.weight;
	}
	
	/**
	 * get Age of Animal
	 * @return int, Age of ANimal
	 */
	public int getAge(){
		return this.age;
	}
	
	/**
	 * Get Name of Animal
	 * @return String, Name of Animal
	 */
	public String getName(){
		return this.name;
	}
	
	
	/**
	 * Get Id of Animal
	 * @return int, Id Of Animal
	 */
	public int getId(){
		return this.id;
	}
	
	/**
	 * Get Catgeory of Animal like mammal, bird, reptile etc.
	 * @return String, Catehory of Animal
	 */
	abstract String getCategory();
	
	
	/**
	 * Get if Animal canFly or not
	 * @return boolean, true if it can fly or false otherwise
	 */
	abstract boolean canFly();
	
	/**
	 * Get type of Animal like Lion, Peacock etc.
	 * @return String, type of Animal 
	 */
	abstract String getType();
	
	
	/**
	 * Get Sound of Animal e.g. Roar, Hiss etc.
	 * @return String, sound of Animal
	 */
	abstract String getSound();
	
}
