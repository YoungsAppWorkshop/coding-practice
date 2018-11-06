package javaTutorial;

public class BicycleDemo {

	public static void main(String[] args) {
		// Create two different
		// Bicycle objects
		Bicycle bike1 = new Bicycle();
		Bicycle bike2 = new Bicycle();
		MountainBike bike3 = new MountainBike();
		
		// Invoke methods on
		// those objects
		bike1.setCadence(50);
		bike1.speedUp(10);
		bike1.setGear(2);
		bike1.printStates();

		bike2.setCadence(50);
		bike2.speedUp(10);
		bike2.setGear(2);
		bike2.setCadence(40);
		bike2.speedUp(10);
		bike2.setGear(3);
		bike2.printStates();
		
		bike3.setCadence(50);
		bike3.speedUp(10);
		bike3.setGear(2);
		bike3.printStates();
		

	}

}
