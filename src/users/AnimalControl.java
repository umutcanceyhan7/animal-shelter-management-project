package users;

import shelter.Shelter;

public class AnimalControl<T> {

	public AnimalControl() {
		
	}
	public boolean bringAnimal(T animal, Shelter<T> shelter) {
		if(animal.equals("dog")) {
			return shelter.enqueueDog(animal);
		}
		else if(animal.equals("cat")) {
			return shelter.enqueueCat(animal);
		}
		else {
			System.out.println("Invalid animal");
			return false;
		}
	}
}
