package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LoadData {

	public static Integer[] loadIntegerData(int amount,String type) {
		String filename = "data/int" + amount + type + ".txt";
		File file = new File(filename);
		if (!file.exists()) {
			System.out.println("No file with amount=" + amount);
			return null;
		}

		Integer[] data = new Integer[amount];

		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));

			for (int i = 0; i < amount; i++) {
				data[i] = Integer.parseInt(reader.readLine());
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

		return data;

	}

}
