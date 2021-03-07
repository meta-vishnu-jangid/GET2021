package main;

/**
 * Class for representing Birds
 * @author vishnu.jangid_metacu
 *
 */
abstract class Bird extends Animal{
	
	private final String animalCatrgory;
	private final boolean canMammalFly;

	/**
	 * Initialize Bird
	 * @param name String, name of Bird
	 * @param weight int, Weight of Bird
	 * @param age int, Age of Bird
	 */
	public Bird(String name,int weight, int age) {
		super(name,weight,age);
		this.animalCatrgory = "Bird";
		this.canMammalFly = true;
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

