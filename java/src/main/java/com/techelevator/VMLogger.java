package com.techelevator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public abstract class VMLogger {
	
	public static void log(String message) throws FileNotFoundException {

		try {
			PrintWriter dataOutput = 
					new PrintWriter(
					new FileOutputStream("Log.txt", true)); //sets file to append
						
			dataOutput.println(message);
			dataOutput.flush();
			dataOutput.close();
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException(e.getMessage());
		}
	}
} 