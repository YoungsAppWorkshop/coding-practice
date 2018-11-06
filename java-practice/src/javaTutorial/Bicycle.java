package javaTutorial;

public class Bicycle {
	private int cadence;
	private int gear;
	private int speed;
	private int id;
	private static int numberOfBicycles = 0;
	
	public Bicycle() {
		gear = 1;
		cadence = 0;
		speed = 0;
		id = ++numberOfBicycles;
	}

	public Bicycle(int startCadence, int startSpeed, int startGear) {
		gear = startGear;
		cadence = startCadence;
		speed = startSpeed;

		// increment number of Bicycles
		// and assign ID number
		id = ++numberOfBicycles;
	}

	public static int getNumberOfBicycles() {
		return numberOfBicycles;
	}
	
	public int getCadence(){
		return cadence;
	}

	public void setCadence(int newValue) {
		cadence = newValue;
	}

	public int getGear(){
		return gear;
	}
	
	public void setGear(int newValue) {
		gear = newValue;
	}

	public int getSpeed() {
		return speed;
	}
	
	public void speedUp(int increment) {
		speed += increment;
	}

	public void applyBrakes(int decrement) {
		speed -= decrement;
	}

	public int gedID() {
		return id;
	}

	void printStates() {
		System.out.println("======= Bicycle ID :" + id + " =======");
		System.out.println("cadence:" + cadence + "  speed:" + speed + "  gear:" + gear);
		System.out.println();
	}
}
