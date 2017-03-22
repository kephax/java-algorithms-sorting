package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class CSV {

	private ArrayList<Object> data = new ArrayList<Object>();

	public CSV() {

	}

	public void newRow() {
		data.add(null);
	}

	public void addObject(Object o) {
		data.add(o);
	}

	public void saveToFile(String filename) throws IOException {
		File file = new File(filename);
		BufferedWriter out = new BufferedWriter(new FileWriter(file));
		Object prev = null;
		for (Object o : data) {
			if (o == null) {
				out.write("\n");
			} else {
				if (prev != null)
					out.write(";");
				out.write(o.toString());
			}
			prev = o;
		}
		out.flush();
		out.close();
	}

}
