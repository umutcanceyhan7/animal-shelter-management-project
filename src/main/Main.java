package main;

import shelter.Shelter;
import shelter.StorageArea;
import shelter.Stack;
import shelter.Queue;

import users.AnimalControl;
import users.CareGivers;
import users.Donors;
import users.Rescuers;

import java.io.FileNotFoundException;

public class Main {
	public static final String INSTRUCTIONS_FILE = "./instructions.txt";
	public static final String[] DECISIONS = {"cat","dog","any"};
	public static void main(String[] args) throws FileNotFoundException {
	// shelter that keeps cat and dog
	Shelter<String> animalShelter = new Shelter<String>(10);
	// storageArea that keeps foods
	StorageArea<String> storageArea = new StorageArea<String>(10);
	// users
	AnimalControl<String> animalcontrol = new AnimalControl<String>();
	CareGivers<String> caregiver = new CareGivers<String>();
	Donors<String> donor = new Donors<String>();
	Rescuers<String> rescuer = new Rescuers<String>();
	// Execute of instructions text file
	Simulate<String> simulate = new Simulate<String>();
	simulate.start(caregiver,donor,animalcontrol,rescuer,storageArea,animalShelter);
	}
}
