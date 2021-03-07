package main;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test Class For testing ZooManagementSystem Class
 * @author vishnu.jangid_metacu
 *
 */
public class ZooManagementSystemTest {

	/**
	 * Method For testing addZone method of ZooManagementSystem Class
	 */
	@Test
	public void addZoneTest() {
        ZooManagementSystem zooManagementSystem = new ZooManagementSystem(2);
		Zone zone1 = new Zone("Mammal",2,false,false);
		Zone zone2 = new Zone("Mammal",2,false,false);
		
		assertEquals(true, zooManagementSystem.addZone(zone1));
		assertEquals(true, zooManagementSystem.addZone(zone2));
	}
	
	/**
	 * Method For testing Exception in addZone method of ZooManagementSystem Class
	 */
	@Test(expected = AssertionError.class)
	public void addZoneExceptionTest(){
		ZooManagementSystem zooManagementSystem = new ZooManagementSystem(2);
		Zone zone1 = new Zone("Mammal",2,false,false);
		Zone zone2 = new Zone("Mammal",2,false,false);
		Zone zone3 = new Zone("Mammal",2,false,false);
		
		zooManagementSystem.addZone(zone1);
		zooManagementSystem.addZone(zone2);
		zooManagementSystem.addZone(zone3);
	}
	
	/**
	 * Method For testing getAvailableZoneCapacity method of ZooManagementSystem Class
	 */
	@Test
	public void getAvailableZoneCapacityTest(){
		ZooManagementSystem zooManagementSystem = new ZooManagementSystem(2);
		Zone zone1 = new Zone("Mammal",2,false,false);
		zooManagementSystem.addZone(zone1);
		
		assertEquals(1,zooManagementSystem.getAvailableZoneCapacity());
	}
	
	/**
	 * Method For testing addAnimal method of ZooManagementSystem Class
	 */
	@Test
	public void addAnimalTest() {
		
		ZooManagementSystem zooManagementSystem = new ZooManagementSystem(2);
		
		Animal sheruTheLion = new Lion("Sheru", 45, 3);
		Animal shankyThePeacock = new Peacock("Shanky", 22, 3);
		Animal crookTheCrocodile = new Crocodile("Crrok", 23, 1);
		
		assertEquals(true,zooManagementSystem.addAnimal(sheruTheLion));
		assertEquals(true,zooManagementSystem.addAnimal(shankyThePeacock));
	}
	
	/**
	 * Method For testing Exception in addAnimal method of ZooManagementSystem Class
	 */
	@Test(expected = AssertionError.class)
	public void addAnimalExceptionTest() {
		
		ZooManagementSystem zooManagementSystem = new ZooManagementSystem(2);
		
		Animal sheruTheLion = new Lion("Sheru", 45, 3);
		Animal shankyThePeacock = new Peacock("Shanky", 22, 3);
		Animal crookTheCrocodile = new Crocodile("Crrok", 23, 1);
		
		zooManagementSystem.addAnimal(sheruTheLion);
		zooManagementSystem.addAnimal(shankyThePeacock);
		zooManagementSystem.addAnimal(crookTheCrocodile);
	}
	
	/**
	 * Method For testing removeAnimal method of ZooManagementSystem Class
	 */
	@Test
	public void removeAnimalTest() {
		
		ZooManagementSystem zooManagementSystem = new ZooManagementSystem(2);
		
		Animal sheruTheLion = new Lion("Sheru", 45, 3);
		Animal shankyThePeacock = new Peacock("Shanky", 22, 3);
		Animal crookTheCrocodile = new Crocodile("Crrok", 23, 1);
		
		assertEquals(true,zooManagementSystem.addAnimal(sheruTheLion));
		assertEquals(true,zooManagementSystem.addAnimal(shankyThePeacock));
		
		assertEquals(true,zooManagementSystem.removeAnimal(sheruTheLion));
	}
	
	
	/**
	 * Method For testing exception  in removeAnimal method of ZooManagementSystem Class
	 */
	@Test(expected = AssertionError.class)
	public void removeAnimalExceptionTest() {
		
		ZooManagementSystem zooManagementSystem = new ZooManagementSystem(2);
		
		Animal sheruTheLion = new Lion("Sheru", 45, 3);
		Animal shankyThePeacock = new Peacock("Shanky", 22, 3);
		Animal crookTheCrocodile = new Crocodile("Crrok", 23, 1);
		
		assertEquals(true,zooManagementSystem.addAnimal(sheruTheLion));
		assertEquals(true,zooManagementSystem.addAnimal(shankyThePeacock));
		
		assertEquals(true,zooManagementSystem.removeAnimal(crookTheCrocodile));
	}

}
