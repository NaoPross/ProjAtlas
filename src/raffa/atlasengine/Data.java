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
	
	/**
	 * Constants for the pseudo number generation
	 */
	
	public static final int CONG_A = 69069;
	public static final int CONG_C = 1234567;
	public static final int CONG_M = (int)(Math.pow(2, 32) - 1);
	public static final int[] SHR3_TAP = {17, 13, 5};
	public static final int Z_NEW_A = 36969;
	public static final int W_NEW_A = 18000;
	public static final int NEW_B = 65535;
	public static final int NEW_C = 16;

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
	 * A similar to KISS random number generator
	 */
	
	private static int CONG(int seed) {
		
		seed = (CONG_A * seed + CONG_C) % CONG_M; // The linear congruential
		return seed;
	}
	
	private static int SHR3(int seed) {
		
		seed ^= (seed << SHR3_TAP[0]);
		seed ^= (seed >>> SHR3_TAP[1]);
		seed ^= (seed << SHR3_TAP[2]);
		
		return seed;
	}
	
	private static int zNew(int seed) {
		
		seed = Z_NEW_A ^ (seed & NEW_B) + (seed >>> NEW_C);
		return seed;
	}
	
	private static int wNew(int seed) {
		
		seed = W_NEW_A ^ (seed & NEW_B) + (seed >>> NEW_C);
		return seed;
	}
	
	private static int MWC(int seed) {
		
		seed = (zNew(seed) << 16) + wNew(seed);
		return seed;
	}
	
	public static int KISS(int seed) {
		
		seed = (MWC(seed) ^ CONG(seed)) + SHR3(seed);
		return seed;
	}
}
