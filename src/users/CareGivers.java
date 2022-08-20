package users;

import shelter.StorageArea;

public class CareGivers<T> {
	public CareGivers() {
		
	}
	public boolean feed (StorageArea<T> storageArea) {
		boolean checker = false;
		if(storageArea.getTotalFood() != 0) {
			checker = storageArea.takeFood();
			return checker;
		}
		return checker;
	}
}
