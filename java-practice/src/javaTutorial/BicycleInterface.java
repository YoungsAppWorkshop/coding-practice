package javaTutorial;

public interface BicycleInterface {
	
	// wheel revolutions per minute
	void changeCadence(int newValue);
	
	void changeGear(int newValue);
	
	void speedUp(int increment);
	
	void applyBrakes(int decrement);

}
