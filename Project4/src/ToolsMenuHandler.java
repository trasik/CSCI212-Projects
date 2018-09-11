import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.StringTokenizer;

public class ToolsMenuHandler implements ActionListener {
	JFrame frame;
	
	public ToolsMenuHandler(JFrame newFrame) {
		frame = newFrame;
	}
	
	
	//Method to perform the actions handled in the Tools menu
	public void actionPerformed(ActionEvent event) {
		String menuName = event.getActionCommand();
		//If the Menu option = search then search for the specific box object
		if (menuName.equals("Search")) {
			if(Project4.sorted_boxes == null) {
				JOptionPane.showMessageDialog(null, "Please choose a file first");
				return;
			}
			
			String input = JOptionPane.showInputDialog(null, "Please input the dimensions of the box with the following format: x,y,z");
			//StringTokenizer to break up the input string to get each individual parameter for the Box object.
			StringTokenizer tokens = new StringTokenizer(input, ",");
			if (tokens.countTokens() != 3) {
				JOptionPane.showMessageDialog(null, "Please enter 3 dimensions of the box in order to search.");
				return;
			}
			
			int length, width, height;
			try {
				//change the numbers in the string into integers to be used.
				length = Integer.parseInt(tokens.nextToken());
				width = Integer.parseInt(tokens.nextToken());
				height = Integer.parseInt(tokens.nextToken());
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Please enter 3 valid dimensions of the box.");
				return;
			}
			
			if (length < 1 || width < 1 || height < 1) {
				JOptionPane.showMessageDialog(null, "The dimensions of the box cannot be less than 1.");
				return;
			}
			
			//Find the volume of the searched box
			int volume = length * width * height;
			//Create a new JFrame in order to display the result.
			JFrame result = new JFrame();
			result.setTitle("Boxes that are able to fit with the common volume of: " + volume);
			result.setSize(400, 400);
			result.setLocation(800, 200);
			TextArea resultArea = new TextArea();
			result.getContentPane().add(resultArea);
			for (Box b : Project4.sorted_boxes.keySet()) {
				int rep = Project4.sorted_boxes.get(b);
				for(int i = 0; i < rep; i++) {
					if (b.volume() >= volume) {
						resultArea.append(Project4.sorted_boxes.get(b).toString() + "\n");
					}
				}
			}
			result.setVisible(true);
		}
	}
}
