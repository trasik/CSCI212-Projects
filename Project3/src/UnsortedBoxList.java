public class UnsortedBoxList extends BoxList {
	
	//Constructor to call the parent class BoxList
	public UnsortedBoxList() {
		super();
	}
	
	//calls the append method from BoxList in order to add a UnsortedBoxList object
	public void add(Box b) {
		this.append(b);
	}
}
