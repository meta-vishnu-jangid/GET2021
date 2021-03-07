package main;

/**
 * Class for representing Mammals
 * @author vishnu.jangid_metacu
 *
 */
abstract class Mammal extends Animal{
	
	private final String animalCatrgory;
	private final boolean canMammalFly;

	/**
	 * Initialize Mammal
	 * @param name String, name of Mammal
	 * @param weight int, Weight of Mammal
	 * @param age int, Age of Mammal
	 */
	public Mammal(String name,int weight, int age) {
		super(name,weight,age);
		this.animalCatrgory = "Mammal";
		this.canMammalFly = false;
	}
	
	@Override
	public String getCategory(){
		return this.animalCatrgory;
	}
	
	@Override
	public boolean canFly(){
		return this.canMammalFly;
	}
	
}

