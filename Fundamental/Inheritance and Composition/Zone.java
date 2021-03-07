package main;

import java.util.ArrayList;

/**
 * Class Representing Structure of Zone in a Zoo
 * @author vishnu.jangid_metacu
 */
public class Zone {
	
	private final String animalCategory;
	private final int MAX_NUMBER_OF_CAGES;
	private ArrayList<Cage> cages = new ArrayList<Cage>();
	private int numberOfCages;
	public final boolean hasPark;
	public final boolean hasCanteen;
	
	/**
	 * Initialize Zoo Object
	 * @param animalCategory String, Category of Animal that can be added to Zones like mammals,bird etc.
	 * @param maxCages int, max number of cages supported by zone
	 * @param hasPark boolean, true if zone has a Park otherwise false
	 * @param hasCanteen boolean, true if zone has a Canteen otherwise false
	 */
	public Zone(String animalCategory, int maxCages, boolean hasPark, boolean hasCanteen) {
		this.animalCategory = animalCategory;
		this.MAX_NUMBER_OF_CAGES = maxCages;
		this.hasPark = hasPark;
		this.hasCanteen = hasCanteen;
		this.numberOfCages = 0;
	}
	
	/**
	 * Method to get Available Capcity of Cages
	 * @return int, available capacity
	 */
	public int getAvailableCapacityOfCages(){
		return MAX_NUMBER_OF_CAGES - numberOfCages;
	}
	
	/**
	 * Method to get Available Capacity for an animal Type
	 * @param type String, type of ANimal
	 * @return int, available capacity
	 */
	public int getAvailableCapcityForAnimalOfType(String type){
		int capacity = 0 ;
		for(Cage cage: this.cages){
			if(cage.getTypeOfAnimal().equals(type)){
				capacity += cage.getAvailableCapacity();
			}
		}
		return capacity;
	}
	
	/**
	 * Method to add Cage to Zone
	 * @param cage Cage, Cage Object to be added to Zone
	 * @return boolean, true if cage successfully addded
	 * @throws AssertionError if there is no capacity
	 */
	public boolean addCage(Cage cage) throws AssertionError{
		if(this.getAvailableCapacityOfCages()==0){
			throw new AssertionError("No new Cages can be Added");
		}
		else{
			this.cages.add(cage);
			this.numberOfCages ++;
			return true;
		}
	}
	
	/**
	 * Method to add ANimal to a Zone
	 * @param animal Animal, animal Object to be Added
	 * @return boolean, true if Animal successfully Added
	 * @throws AssertionError, if Animal Cannot be Added 
	 */
	public boolean addAnimal(Animal animal) throws AssertionError{
		if( !animal.getCategory().equals(this.animalCategory)){
			throw new AssertionError("This Catgeory of Animal cannot be added to this zone");
		}
		boolean flag = false;
		for(Cage cage : this.cages){
			if(cage.getTypeOfAnimal().equals(animal.getType()) && cage.getAvailableCapacity() > 0){
				flag =true;
				cage.addAnimal(animal);
				break;
			}
		}
		if(!flag){
			throw new AssertionError("Capacity of all Cages Are Full ");
		}
		return flag;
	}
	
	/**
	 * Method to remove animal from zone
	 * @param animal Animal, animal object to be removed
	 * @return boolean, if Animal is removed otherwise false
	 */
	public boolean removeAnimal(Animal animal) {
		if( !animal.getCategory().equals(this.animalCategory)){
			return false;
		}
		boolean isRemoved = false;
		for(Cage cage : this.cages){
			if(cage.getTypeOfAnimal().equals(animal.getType())){
				isRemoved = cage.removeAnimal(animal);
				if(isRemoved){
					break;
				}
			}
		}
		return isRemoved;
	}
	
	/**
	 * Method to get if Zone has a park
	 * @return boolean, true if has Park otherwise false
	 */
	public boolean getHasPark(){
		return this.hasPark;
	}
	
	/**
	 * Method to get if Zone has a Canteen
	 * @return boolean, true if has Canteen otherwise false
	 */
	public boolean getHasCanteen(){
		return this.hasCanteen;
	}
	
	/**
	 * Method to get Animal Category supported by Zone
	 * @return String, Category of Animal
	 */
	public String getAnimalCategory(){
		return this.animalCategory;
	}
	
	/**
	 * Get List of Cages in ZOne
	 * @return ArrayList<Cage>, list of Cages
	 */
	public ArrayList<Cage> getListOfCages(){
		return this.cages;
	}
	
}
