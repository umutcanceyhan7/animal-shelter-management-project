package users;

import main.Main;
import shelter.Shelter;

public class Rescuers<T> {
	public Rescuers() {
		
	}
	public boolean adoptAnimal(T decision, Shelter<T> shelter) {
		if(decision.equals(Main.DECISIONS[0])) {
			return shelter.dequeueCat();
		}
		else if(decision.equals(Main.DECISIONS[1])) {
			return shelter.dequeueDog();
		}
		else if(decision.equals(Main.DECISIONS[2])){
			return shelter.dequeueAny();
		}
		else {
			System.out.print("wrong decision");
			return false;
		}
	}
}
