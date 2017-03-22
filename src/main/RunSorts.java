package main;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import sort.BaseSort;
import sort.InsertionSort;
import sort.MergeSort;
import sort.QuickSort;
import sort.SlowSort;


public class RunSorts {

	public static void run() {
		runTest("normal1");
		runTest("normal2");
		runTest("normal3");
		runTest("sorted");
		runTest("reversesorted");
	}

	public static void runTest(String type) {
		// Create arrayList to store arrays
		ArrayList<Integer[]> sortArrays = new ArrayList<Integer[]>();

		// add arrays from files to arraylist
		sortArrays.add(LoadData.loadIntegerData(10, type));
		sortArrays.add(LoadData.loadIntegerData(1000, type));
		sortArrays.add(LoadData.loadIntegerData(10000, type));
		sortArrays.add(LoadData.loadIntegerData(100000, type));
		sortArrays.add(LoadData.loadIntegerData(1000000, type));

		// Create arraylist to store Sort methods
		ArrayList<BaseSort> sortMethods = new ArrayList<BaseSort>();

		// store methods
		sortMethods.add(new SlowSort());
		sortMethods.add(new InsertionSort());
		sortMethods.add(new MergeSort());
		sortMethods.add(new QuickSort());

		Integer[] tempList;
		CSV csv = new CSV();

		// run sort of every method, on every array
		for (BaseSort b : sortMethods) {
			csv.newRow();
			csv.newRow();
			csv.newRow();
			System.out.println(b.getName());
			csv.addObject(b.getName());
			csv.newRow();
			csv.newRow();
			csv.addObject("n");
			csv.addObject("Time (ms)");
			csv.addObject("Steps");
			csv.addObject("Swaps");
			csv.newRow();
			
			for (Integer[] array : sortArrays) {
				if (b.getName() == "SlowSort" && array.length >= 100000)
					break;
				if (b.getName() == "InsertionSort" && array.length >= 100000)
					break;
				csv.newRow();
				csv.addObject(array.length);
				System.out.print(array.length + " n  ");
				tempList = array.clone();
				try {
					b.sort(tempList);
					csv.addObject(b.getTimeToRun());
					csv.addObject(b.getSteps());
					csv.addObject(b.getSwaps());
				} catch (StackOverflowError e) {
					csv.addObject("Stack overflow");
					csv.addObject("Stack overflow");
					csv.addObject("Stack overflow");
				}
				System.out.println();

			}
			System.out.println();
		}
		try {
			csv.saveToFile("output" + type + ".csv");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
