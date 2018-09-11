/*
 * Torendra Rasik
 * April 26, 2018
 * Project 3
 */

import java.util.StringTokenizer;

public class Project3 {
	public static StringTokenizer Tokens;
	public static BoxList sorted_boxes, unsorted_boxes;
	public static BoxGUI gui;
	
	public static void readNum(String fileName) {
		//Creates two new Objects of Sorted and Unsorted Lists
		sorted_boxes = new SortedBoxList();
		unsorted_boxes = new UnsortedBoxList();
		//Reads in the file and uses String tokenizer to break up the strings to individual strings to get the values
		TextFileInput input = new TextFileInput(fileName);
		String line = input.readLine();
		StringTokenizer Tokens;
		while (line != null) {
			Tokens = new StringTokenizer (line, ",");
			try {
				//Store the values of the new strings into a Box object
				Box temp = new Box(Integer.parseInt(Tokens.nextToken()), Integer.parseInt(Tokens.nextToken()), Integer.parseInt(Tokens.nextToken()));
				//Add to the new Sorted and Unsorted List objects the Box temp object
				sorted_boxes.add(temp);
				unsorted_boxes.add(temp);
			} catch (IllegalBoxException e) {
				System.err.println(e + ": " + line);
			}
			//Move to the next input line of the configuration file
			line = input.readLine();
		}
	}
	
	public static void main(String[] args) {
		BoxGUI project3 = new BoxGUI("Project 3", 400, 400);
	}
}
