import javax.swing.*;
import java.awt.*;
 
public class BoxGUI extends JFrame {
	
	static JFrame myFrame;
	static Container cPane;
	static TextArea rawBoxes, sortedBoxes;

	public static void initialize() {
		rawBoxes = new TextArea();
		sortedBoxes = new TextArea();
		myFrame = new JFrame();
		myFrame.setSize(400, 400);
		myFrame.setLocation(200, 200);
		myFrame.setTitle("Project 1");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		myFrame.setLayout(new GridLayout(1, 2));
		cPane = myFrame.getContentPane();
		cPane.add(rawBoxes);
		cPane.add(sortedBoxes);
		myFrame.setVisible(true);
	}
}