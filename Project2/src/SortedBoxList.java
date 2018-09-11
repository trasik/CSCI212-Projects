public class SortedBoxList extends BoxList {
	
	//Constructor to call the parent class BoxList
	public SortedBoxList() {
		super();
	}
	
	//Constructor to call the parent class BoxList
	@Override
	public void add(Box b) {
		//Creates a temp BoxNode for comparison
		BoxNode temp = new BoxNode(b);
		BoxNode first = this.first;
		//if the data in the BoxNode already there is less than the new comparison then the data becomes the next node data
		while (first.next != null && first.next.data.compareTo(b) < 0) {
			first = first.next;
		}
		//store the new node into the temporary node
		temp.next = first.next;
		first.next = temp;
		this.length++;
	}
}
