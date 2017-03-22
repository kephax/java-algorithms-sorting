package createdata;

import java.io.File;
import java.io.IOException;

/**
 * Class for creating a number of arrays with incrementing sizes
 * 
 * @author Harm
 * 
 */
public class createData {

	public static void main(String[] args) {
		
		File f = new File("data/");
		f.mkdir();
		
		try {
			createArrays.createIntegerData(10, 10000);
			createArrays.createIntegerData(100, 10000);
			createArrays.createIntegerData(1000, 10000);
			createArrays.createIntegerData(10000, 10000);
			createArrays.createIntegerData(100000, 10000);
			createArrays.createIntegerData(1000000, 10000);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
