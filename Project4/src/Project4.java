/*
 * Torendra Rasik
 * April 26, 2018
 * Project 3
 */

import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Project4 {
	public static StringTokenizer Tokens;
	public static HashMap<Integer, Box> unsorted_boxes;
	public static TreeMap<Box, Integer> sorted_boxes;
	public static BoxGUI gui;
	
	public static void readNum(String fileName) {
		//Creates two new Objects of Sorted and Unsorted Lists
		sorted_boxes = new TreeMap<Box, Integer>();
		unsorted_boxes = new HashMap<Integer, Box>();
		//Reads in the file and uses String tokenizer to break up the strings to individual strings to get the values
		TextFileInput input = new TextFileInput(fileName);
		String line = input.readLine();
		StringTokenizer Tokens;
		int index = 0;
		while (line != null) {
			Tokens = new StringTokenizer (line, ",");
			try {
				//Store the values of the new strings into a Box object
				Box temp = new Box(Integer.parseInt(Tokens.nextToken()), Integer.parseInt(Tokens.nextToken()), Integer.parseInt(Tokens.nextToken()));
				unsorted_boxes.put(index++, temp);
				if(sorted_boxes.containsKey(temp)) {
					sorted_boxes.put(temp, sorted_boxes.get(index) + 1);
				} else {
					sorted_boxes.put(temp, index);
				}
			} catch (IllegalBoxException e) {
				System.err.println(e + ": " + line);
			}
			//Move to the next input line of the configuration file
			line = input.readLine();
		}
	}
	
	public static void main(String[] args) {
		BoxGUI project3 = new BoxGUI("Project 4", 400, 400);
	}
}
