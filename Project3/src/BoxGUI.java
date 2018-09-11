import java.awt.*;
import javax.swing.*;
 
public class BoxGUI extends JFrame {
	
	TextArea unsortedBoxes, sortedBoxes;

	public BoxGUI(String title, int height, int width) {
		setTitle(title);
		setSize(height, width);
		setLocation(400, 200);
		createMenu();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(1, 2));
		this.unsortedBoxes = new TextArea();
		this.sortedBoxes = new TextArea();
		this.getContentPane().add(unsortedBoxes);
		this.getContentPane().add(sortedBoxes);
		setVisible(true);
	}
	
	//Method to create the menu of the GUI
	private void createMenu() {
		JMenuItem item;
		JMenuBar menuBar = new JMenuBar();
		//Create a new option in the menu called File
		JMenu fileMenu = new JMenu("File");
		FileMenuHandler fileHandler = new FileMenuHandler(this);
		ToolsMenuHandler toolsHandler = new ToolsMenuHandler(this);

		//Create a new option in File called Open 
		item = new JMenuItem("Open");
		item.addActionListener(fileHandler);
		fileMenu.add(item);
		
		fileMenu.addSeparator();
		
		//Create a new option in File called Quit
		item = new JMenuItem("Quit");
		item.addActionListener(fileHandler);
		fileMenu.add(item);
		
		menuBar.add(fileMenu);
		
		//Create a new option in the menu called Tools next to File
		JMenu toolsMenu = new JMenu("Tools");
		
		//Create a new option in Tools called Search
		item = new JMenuItem("Search");
		item.addActionListener(toolsHandler);
		toolsMenu.add(item);
		
		setJMenuBar(menuBar);
		menuBar.add(toolsMenu);
	}
	
	public void setTextArea(BoxList unsorted, BoxList sorted) {
		this.unsortedBoxes.setText(unsorted.toString());
		this.sortedBoxes.setText(sorted.toString());
	}
}