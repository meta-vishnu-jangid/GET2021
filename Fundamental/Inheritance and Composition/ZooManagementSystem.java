package main;

import java.util.ArrayList;

/**
 * Class for Zoo Management System
 * @author vishnu.jangid_metacu
 */
public class ZooManagementSystem {
	
	private ArrayList<Zone> zones = new ArrayList<Zone>(); 
	private final int MAX_ZONE_LIMIT;
	private int numberOfZones;
	private int default_cage_capacity = 5 ;
	private int default_zone_capacity = 5;
	private boolean hasParkDefault = false;
	private boolean hasCanteenDefault = false;
	
	/**
	 * Initialize ZooMAnagemetSystem Object
	 * @param maxZoneLimit int, maximum number of Zones can be added to Zoo
	 */
	public ZooManagementSystem(int maxZoneLimit) {
		this.MAX_ZONE_LIMIT = maxZoneLimit;
		this.numberOfZones = 0;
	}
	
	/**
	 * Method to add ZOne to zoo
	 * @param zone Zone, zone object to be added
	 * @return boolean, true if successfully added zone 
	 * @throws AssertionError if no more zones can be added
	 */
	public boolean addZone(Zone zone) throws AssertionError{
		if( this.numberOfZones == MAX_ZONE_LIMIT ){
			throw new AssertionError("No more Zones can be Added");
		}
		zones.add(zone);
		this.numberOfZones += 1;
		return true;
	}
	
	/**
	 * Get Available Capacity for Zones
	 * @return int, available capacity
	 */
	public int getAvailableZoneCapacity(){
		return this.MAX_ZONE_LIMIT - this.numberOfZones;
	}
	
	/**
	 * Method to add Animal to Zoo
	 * @param animal Animal, animal object to be added
	 * @return boolean, true in case of successfully Added
	 * @throws AssertionError if Animal cannot be added to Zoo
	 */
	public boolean addAnimal (Animal animal) throws AssertionError{
		
		boolean isAnimalAdded = false;
		
		for(Zone zone: this.zones){
			if(zone.getAnimalCategory().equals(animal.getCategory())){
				if(zone.getAvailableCapcityForAnimalOfType(animal.getType()) > 0){
					isAnimalAdded = zone.addAnimal(animal);
					break;
				}
				else if(zone.getAvailableCapacityOfCages() > 0){
					Cage newCage = new Cage(this.default_cage_capacity, animal.getType());
					zone.addCage(newCage);
					isAnimalAdded = newCage.addAnimal(animal);
					break;
				}
			}
		}
		if(!isAnimalAdded && this.getAvailableZoneCapacity() > 0){
			Zone newZone = new Zone(animal.getCategory(),this.default_zone_capacity ,this.hasParkDefault, this.hasCanteenDefault);
			this.addZone(newZone);
			Cage newCage = new Cage(this.default_cage_capacity, animal.getType());
			newZone.addCage(newCage);
			isAnimalAdded = newCage.addAnimal(animal);
			
		}
		else if(!isAnimalAdded){
			throw new AssertionError("No more Animal Can be Added");
		}
		
		return isAnimalAdded;
	}
	
	/**
	 * Method to remove animal from Zoo
	 * @param animal Animal, animal object to be removed
	 * @return boolean, if Animal is removed otherwise false
	 *  @throws AssertionError if Animal not found
	 */
	public boolean removeAnimal(Animal animal) throws AssertionError{
		boolean flag = false;
		for(Zone zone : this.zones){
			flag = zone.removeAnimal(animal);
			if(flag){
				break;
			}
		}
		if(!flag){
			throw new AssertionError("No Animal Found");
		}
		return flag;
	}
	
	/**
	 * Method to Show Zoo Structure
	 */
	public void showZooStructure(){
		for(Zone zone: this.zones){
			System.out.println("Zone Type : " + zone.getAnimalCategory());
			for(Cage cage : zone.getListOfCages()){
				System.out.println("         Cage Type : " + cage.getTypeOfAnimal());
				for(Animal animal : cage.getListOfAnimals() ){
					System.out.println("                  Animal  : " + animal.getName());
				}
			}
		}
	}
	
}
