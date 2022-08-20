package main;

import java.io.*;
import java.util.*;

public class FileIO {
	private String[][] dataArray = new String [43][2];
	private int i = 0;
	public String[][] read() throws FileNotFoundException {
		
		File file = new File(Main.INSTRUCTIONS_FILE);
		Scanner reader = new Scanner(file);
		while(reader.hasNextLine()) {
			String data = reader.nextLine();
			this.dataArray[i]  = data.split(",");
			i++;
		}
		reader.close();	
		return this.dataArray;
		
	}
	
}
