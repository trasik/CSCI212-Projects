import java.util.StringTokenizer;

public class Project2 {
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
			} catch (IllegalArgumentException e) {
				System.out.println(e + ": " + line);
			}
			//Move to the next input line of the configuration file
			line = input.readLine();
		}
	}
	
	//Method to display the GUI and add to the sorted and unsorted objects
	public static void display() {
		String unsorted = "";
		String sorted = "";
		BoxNode uNode = unsorted_boxes.first.next;
		BoxNode sNode = sorted_boxes.first.next;
		while (uNode != null) {
			unsorted += uNode.data.toString() + "\n";
			sorted += sNode.data.toString() + "\n";
			uNode = uNode.next;
			sNode = sNode.next;
		}
		BoxGUI.initialize();
		BoxGUI.rawBoxes.setText(unsorted);
		BoxGUI.sortedBoxes.setText(sorted);
		BoxGUI.myFrame.setVisible(true);
	} 
	
	public static void main(String[] args) {
		readNum(args[0]);
		display();
	}
}
