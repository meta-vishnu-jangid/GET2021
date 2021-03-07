package main;

import java.util.ArrayList;

/**
 * Class for structure of a Cage
 * @author vishnu.jangid_metacu
 *
 */
public class Cage {
	
	private final String typeOfAnimal;
	private final int MAX_NUMBER_OF_ANIMAL;
	private int numberOAnimals;
	private ArrayList<Animal> animals = new ArrayList<Animal>();
	
	/**
	 * Initialize Cage Object 
	 * @param maxNumberOfAnimal int, Maximum number of Animals supported by Cage
	 * @param typeOfAnimal String, type of Animal that can be added to Cage
	 */
	public Cage(int maxNumberOfAnimal, String typeOfAnimal) {
		this.MAX_NUMBER_OF_ANIMAL = maxNumberOfAnimal;
		this.numberOAnimals = 0;
		this.typeOfAnimal= typeOfAnimal;
	}
	
	/**
	 * Get Available Capacity for Animals in Cage
	 * @return int, available capacity 
	 */
	public int getAvailableCapacity(){
		return MAX_NUMBER_OF_ANIMAL - numberOAnimals;
	}
	
	/**
	 * Method to add animal to cage
	 * @param animal Animal, animal to be added
	 * @return boolean, true if successfully added otherwise false
	 * @throws AssertionError if type of Animal is not supported
	 */
	public boolean addAnimal(Animal animal) throws AssertionError{
		if(this.getAvailableCapacity()==0){
			return false;
		}
		if( animal.getType().equals(typeOfAnimal)){
			animals.add(animal);
			return true;
		}
		else{
			throw new AssertionError("Type of Animal is not supported");
		}
	}
	
	/**
	 * Method to remove Animal form Cage
	 * @param animal Animal, animal to be removed
	 * @return boolean, true if successfully removed Animal otherwise false
	 */
	public boolean removeAnimal(Animal animal){
		boolean isRemoved = animals.remove(animal);
		if(isRemoved){
			this.numberOAnimals--;
		}
		return isRemoved;
	}
	
	/**
	 * Method to get Type of Animal supported by Cage
	 * @return String, category of Animal
	 */
	public String getTypeOfAnimal(){
		return this.typeOfAnimal;
	}
	
	/**
	 * Method to get list Of Animals in Cage
	 * @return ArrayList<Animal>, ArrayList of Animals
	 */
	public ArrayList<Animal> getListOfAnimals(){
		return this.animals;
	}
}
