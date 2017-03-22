package createdata;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Class for creating arrays of integers and writing them to files
 * 
 * @author Harm
 * 
 */

public class createArrays {

	private static Random random = new Random();
	/**
	 * Create an array of integers and write them to a file
	 * 
	 * creates best case (sorted) normal (random * 3) and worst case (reverse
	 * sorted) arrays
	 * 
	 * @param length
	 *            of array
	 * @param range
	 *            of integers (0 - range)
	 * @throws IOException
	 */

	public static void createIntegerData(int length, int range) throws IOException {
		String filename1 = "data/int" + length + "sorted.txt";
		String filename2 = "data/int" + length + "normal1.txt";
		String filename4 = "data/int" + length + "normal2.txt";
		String filename5 = "data/int" + length + "normal3.txt";
		String filename3 = "data/int" + length + "reversesorted.txt";

		File file1 = new File(filename1);
		File file2 = new File(filename2);
		File file3 = new File(filename3);
		File file4 = new File(filename4);
		File file5 = new File(filename5);

		file1.delete();
		file2.delete();
		file3.delete();
		file4.delete();
		file5.delete();

		BufferedWriter out1 = new BufferedWriter(new FileWriter(file1));
		BufferedWriter out2 = new BufferedWriter(new FileWriter(file2));
		BufferedWriter out3 = new BufferedWriter(new FileWriter(file3));
		BufferedWriter out4 = new BufferedWriter(new FileWriter(file4));
		BufferedWriter out5 = new BufferedWriter(new FileWriter(file5));

		for (int i = 0; i < length; i++) {
			out1.write(i + "\r\n");
			out2.write(Integer.toString(random.nextInt(range)) + "\r\n");
			out4.write(Integer.toString(random.nextInt(range)) + "\r\n");
			out5.write(Integer.toString(random.nextInt(range)) + "\r\n");
			out3.write(length - i + "\r\n");
		}

		out1.flush();
		out1.close();

		out2.flush();
		out2.close();

		out3.flush();
		out3.close();

		out4.flush();
		out4.close();

		out5.flush();
		out5.close();
	}

	public static void createStringData(int length, int range) {

	}

}
