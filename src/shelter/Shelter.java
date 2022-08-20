package shelter;

public class Shelter<T> implements IRoom<T>{
	Queue<T> shelterDog;
	Queue<T> shelterCat;
	int shelterSize;
	int capacity;
	public Shelter(int capacity) {
		shelterDog = new Queue<T>(capacity);
		shelterCat = new Queue<T>(capacity);
		this.capacity = capacity;
		shelterSize = 0;
	}
	
	public boolean enqueueDog(T animal) {
		if(shelterSize < this.capacity) {
			int queueIndex = getShelterSize()+1;
			shelterDog.enqueue(animal + " " + queueIndex);
			updateShelterSize();
			return true;
		}
		return false;
	}
	public boolean enqueueCat(T cat) {
		if(shelterSize < this.capacity) {
			int queueIndex = getShelterSize()+1;
			shelterCat.enqueue(cat+" "+ queueIndex);
			updateShelterSize();
			return true;
		}
		return false;
	}
	public boolean dequeueAny() {
		if(shelterDog.peek() != null && shelterCat.peek() != null) {
			String dogPriority = ((String) shelterDog.peek()).substring(4);
			String catPriority = ((String) shelterCat.peek()).substring(4);
			// if dog arrival time is bigger than cat
			if(Integer.parseInt(dogPriority) < Integer.parseInt(catPriority)) {
				return dequeueDog();
			}else {
				return dequeueCat();
			}
		}
		else if(shelterDog.peek() != null && shelterCat.peek() == null) {
			return dequeueDog();
		}
		else if(shelterDog.peek() == null && shelterCat.peek() != null){
			return dequeueCat();
		}
		return false;
	}
	public boolean dequeueDog() {
		if(shelterDog.getSize() != 0) {
			shelterDog.dequeue();
			updateShelterSize();
			return true;
		}
		return false;
		
	}
	public boolean dequeueCat() {
		if(shelterCat.getSize() != 0) {
			shelterCat.dequeue();
			updateShelterSize();
			return true;
		}
		return false;
		
	}
	public int getShelterSize() {
		this.shelterSize = shelterDog.getSize() + shelterCat.getSize();
		return this.shelterSize;
	}
	public void updateShelterSize() {
		shelterSize = shelterDog.getSize() + shelterCat.getSize();
	}
}

