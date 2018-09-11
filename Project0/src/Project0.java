import javax.swing.JOptionPane;

/* Name: Torendra Rasik 
 * Lab Section: 11A
 */

public class Project0 {
	public static void main(String[] args) {
		//While loop to continuously ask the user for input until told to stop 
		while (true) {
			//Asks the user for input through JOptionPane
			String inputText = JOptionPane.showInputDialog(null, "Please type in a sentence:");
			//If the input is equal to any case of the word "stop", then exit the program.
			if (inputText.equalsIgnoreCase("stop"))
				System.exit(0);
			int uppercase = 0, lowercase = 0;
			//For loop to go through the inputText's length
			for (int i = 0; i <= inputText.length() - 1; i++) {
				//If the case of an uppercase e is found then add 1 to the counter.
				if (inputText.charAt(i) == 'E')
					uppercase++;
				//If the case of an lowercase e is found then add 1 to the counter.
				if (inputText.charAt(i) == 'e')
					lowercase++;
			}
			//Shows the final result of how many lowercase and uppercase e's there are in the input and displays it through JOptionPane.
			JOptionPane.showMessageDialog(null, "Number of lower case e's: " + lowercase + "\nNumber of upper case e's: " + uppercase);
		}
	}
}
