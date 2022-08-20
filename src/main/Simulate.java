package main;

import java.io.FileNotFoundException;

import shelter.Shelter;
import shelter.StorageArea;
import users.AnimalControl;
import users.CareGivers;
import users.Donors;
import users.Rescuers;

public class Simulate<T> {
	private String[][] stepsArray;
	public Simulate() {
		}
	@SuppressWarnings("unchecked")
	public void start(CareGivers<T> caregiver, Donors<T> donor, AnimalControl<T> animalcontrol, Rescuers<T> rescuer,StorageArea<T> storageArea,Shelter<T> animalShelter) throws FileNotFoundException {
		// reads file and splits it according to comma then, copies it into stepsArray. 
		// Array executes step by step. 
		FileIO instructions = new FileIO();
		this.stepsArray = instructions.read();
		for(int i=0; i < stepsArray.length;i++) {
			String status = "FAIL";
			if(stepsArray[i][0].equals("caregiver")) {
				if(caregiver.feed(storageArea)) {
					status = "SUCCESS";
				}
				System.out.println("Caregiver wants to feed animals: " + status);
			}
			else if(stepsArray[i][0].equals("donor")) {
				if(donor.donateFood(stepsArray[i][1], storageArea)) {
					status = "SUCCESS";
				}
				System.out.println("Donor wants to donate a food: "+ status);
			}
			else if(stepsArray[i][0].equals("animalcontrol")) {
				if(animalcontrol.bringAnimal((T) stepsArray[i][1], animalShelter)) {
					status = "SUCCESS";
				}
				System.out.println("Animal Control wants to bring a " + stepsArray[i][1] + " to shelter: "+ status);
			}
			else {
				if(rescuer.adoptAnimal((T) stepsArray[i][1], animalShelter)) {
					status = "SUCCESS";
				}
				if(stepsArray[i][1].equals("any")) {
					System.out.println("Rescuer wants to adopt the oldest animal from the shelter: "+ status);
				}
				else if(stepsArray[i][1].equals("cat")) {
					System.out.println("Rescuer wants to adopt the oldest cat from the shelter: "+ status);
				}
				else{
					System.out.println("Rescuer wants to adopt the oldest dog from the shelter:" + status);
				}
				
			}
		}
		
		}
	}

