package main;

public class MainApp {

	public static void main(String[] args) {
		ZooManagementSystem zooManagementSystem = new ZooManagementSystem(2);
		
		Animal sheruTheLion = new Lion("Sheru", 45, 3);
		Animal shankyThePeacock = new Peacock("Shanky", 22, 3);
		Animal crookTheCrocodile = new Crocodile("Crrok", 23, 1);
		
		System.out.println("\n Step 1:");
		zooManagementSystem.showZooStructure();
		
		zooManagementSystem.addAnimal(sheruTheLion);
		
		System.out.println("\n Step 2:");
		zooManagementSystem.showZooStructure();
		
		zooManagementSystem.addAnimal(shankyThePeacock);
		
		System.out.println("\n Step 3:");
		zooManagementSystem.showZooStructure();
		
		System.out.println("\n Step 4:");
		zooManagementSystem.removeAnimal(shankyThePeacock);
		zooManagementSystem.showZooStructure();
		
		System.out.println("\n IDs");
		System.out.println(sheruTheLion.getId());
		System.out.println(shankyThePeacock.getId());
		System.out.println(crookTheCrocodile.getId());
		
	}
}
