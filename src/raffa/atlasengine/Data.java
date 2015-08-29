package raffa.atlasengine;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Data {
	
	/*
	 * Create a high level instrument to write 
	 * the game data into a file
	 */
	
	String path; // The file path
	File saves;
	FileWriter writeFile;
	FileReader readFile;
	BufferedReader reader; // The string reader
	BufferedWriter writer; // The string writer
	public static final int A = 69069;
	public static final int C = 1234567;
	public static final long M = (long)Math.pow(2, 32);

	public Data(String filePath) {
		
		path = filePath;
		saves = new File(path);
		
		try {
			if (!saves.exists())
				saves.createNewFile(); // Verify if the file is already existing
		
		} catch (IOException e) {
			System.out.println("IOError in Data constructor");
			e.printStackTrace();
		}
	}
	
	/*
	 * Open the file where you can write/read strings
	 */
	
	public void open(String mod) throws IOException {
		
		if (mod.equals("WRITE")) {
			writeFile = new FileWriter(saves);
			writer = new BufferedWriter(writeFile);
		} else if (mod.equals("READ")) {
			readFile = new FileReader(saves);
			reader = new BufferedReader(readFile);
		} else {
			throw new NullPointerException(mod + " is not a valid modality");
		}	
	}
	
	/*
	 * Write strings in the file
	 */
	
	public void write(String text, int position) throws IOException {
		
			writer.write(text, position, text.length());
	}
	
	public void write(String text, int newLines, int position) throws IOException {
		
			for (int i = 0; i < newLines; i++)
				writer.newLine();
			writer.write(text, position, text.length());
	}
	
	/*
	 * Read a string from the file
	 */
	
	public String read(int position, int length) throws IOException {
		
		char[] input = new char[length];
		reader.read(input, position, length);
		String text = String.valueOf(input);
		
		return text;
	}
	
	/*
	 * Close the writing/reading process
	 */
	
	public void close(String mod) throws IOException {
		
		if (mod.equals("WRITE"))
			writer.close();
		else if (mod.equals("READ"))
			reader.close();
		else
			throw new NullPointerException(mod + "is not a valid modality");
	}
	
	/*
	 * Returns the current time in hour, minutes and
	 * seconds
	 */
	
	public static int[] getTime() {
		
		long t = System.currentTimeMillis() / 1000;
		int[] time = new int[3];
		
		time[2] = (int)(t % 60); // current seconds
		time[1] = (int)((t / 60) % 60); // current minutes
		time[0] = (int)((t / 3600) % 24); // current hour
		
		return time;
	}
	
	/**
	 * A KISS random number generator
	 */
	
	public static long random(long seed) {
		
		seed = (A * seed + C) % M; // The linear congruential
		return seed;
	}
}
