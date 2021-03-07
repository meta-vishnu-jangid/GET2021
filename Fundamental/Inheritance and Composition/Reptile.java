package main;

/**
 * Class for representing Reptiles
 * @author vishnu.jangid_metacu
 *
 */
abstract class Reptile extends Animal{
	
	private final String animalCatrgory;
	private final boolean canMammalFly;

	/**
	 * Initialize Reptile
	 * @param name String, name of Reptile
	 * @param weight int, Weight of Reptile
	 * @param age int, Age of Reptile
	 */
	public Reptile(String name,int weight, int age) {
		super(name,weight,age);
		this.animalCatrgory = "Reptile";
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

