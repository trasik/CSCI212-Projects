public abstract class BoxList {

	protected BoxNode first;
	protected BoxNode last;
	protected int length;
	
	//Constructor to create a BoxList with a single Node
	public BoxList() {
		this.first = new BoxNode(null);
		this.last = this.first;
		this.length = 0;
	}
	
	public int getLength() {
		return length;
	}
	
	//Attaches a new Node to the list and extends the list
	public void append(Box b) {
		BoxNode temp = new BoxNode(b);
		this.last.next = temp;
		this.last = temp;
		this.length++;
	}
	
	public abstract void add(Box b);
	
	//Converts the BoxList objects to be able to print out to the GUI
	public String toString() {
		String result = "";
		BoxNode nNode = this.first.next;
		while (nNode != null) {
			result += nNode.data.toString() + "\n";
			nNode = nNode.next;
		}
		return result;
	}
}
