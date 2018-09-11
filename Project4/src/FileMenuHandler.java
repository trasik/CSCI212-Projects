import java.awt.event.*;
import java.io.File;
import javax.swing.*;

public class FileMenuHandler implements ActionListener {
	JFrame frame;
	
	public FileMenuHandler(JFrame newFrame) {
		frame = newFrame;
	}
	
	//Method to perform the actions held by the File Menu
	public void actionPerformed(ActionEvent event) {
		String menuName = event.getActionCommand();
		//When Open is clicked it lets the user search for a file to run in the program.
		if (menuName.equals("Open")) {
			final JFileChooser fileChooser = new JFileChooser();
			fileChooser.showOpenDialog(null);
			File file = fileChooser.getSelectedFile();
			String input = file.getPath();
			//Uses readNum method from Project 3 in order to read in the box objects and separate them.
			Project4.readNum(input);
			String left = "", right = "";
			left += Project4.unsorted_boxes.toString() + "\n";
			for (Box b : Project4.sorted_boxes.keySet()) {
				int rep = Project4.sorted_boxes.get(b);
				for(int i = 0; i < rep; i++) {
					right += Project4.sorted_boxes.get(b).toString() + "\n";
				}
			}
			((BoxGUI) this.frame).setTextArea(left, right);
			//If the Option Quit is clicked then end the program and close the frame.
		} else if (menuName.equals("Quit"))
			System.exit(0);
	}
}
