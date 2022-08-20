package users;

import shelter.StorageArea;

public class Donors<T> {
	public Donors() {
		
	}
	public boolean donateFood(String food, StorageArea<T> storageArea) {
		if(food.equals("dryfood") || food.equals("cannedfood")) {
			return storageArea.donateFood(food);
		}
		else {
			System.out.println("Invalid food");
			return false;
		}
	}
}
