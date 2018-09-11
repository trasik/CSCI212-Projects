import java.util.StringTokenizer;

public class Project1 {
	
	static Box[] raw_boxes = new Box[20];
	static Box[] sorted_boxes = new Box[20];
	public static int size;
	
	public static void readFile(String filename) {
		TextFileInput input = new TextFileInput(filename);
		String line = input.readLine();
		StringTokenizer myTokens;
		int index = 0;
		while(line != null && index < 100) {
			myTokens = new StringTokenizer(line, ",");
			try {
				Box newBox = new Box(Integer.parseInt(myTokens.nextToken()), Integer.parseInt(myTokens.nextToken()), Integer.parseInt(myTokens.nextToken()));
				raw_boxes[index] = newBox;
				sorted_boxes[index] = newBox;
				index++;
			} catch (IllegalArgumentException e) {
				System.out.println(e + ": "+ line);
			}
			line = input.readLine();
		}
		size = index;
	}
	
	public static void SelectionSortBox(Box[] sorted) {
		for (int i = 0; i < size - 1; i++) {
			int minIndex = 1;
			for (int j = i + 1; j < size; j++) {
				if (sorted[minIndex].compareTo(sorted[j]) > 0) {
					minIndex = j;
				}
			}
			Box temp = new Box();
			temp = sorted[minIndex];
			sorted[minIndex] = sorted[i];
			sorted[i] = temp;
		}
	}
	
	public static void main(String[] args) {
		readFile(args[0]);
		SelectionSortBox(sorted_boxes);
		String raw = "";
		String sorted = "";
		for (int i = 0; i < size; i++) {
			raw += raw_boxes[i].toString() + "\n";
			sorted += sorted_boxes[i].toString() + "\n";
		}
		BoxGUI.initialize();
		BoxGUI.rawBoxes.setText(raw);
		BoxGUI.sortedBoxes.setText(sorted);
		BoxGUI.myFrame.setVisible(true);
	}
}