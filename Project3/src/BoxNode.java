public class BoxNode extends Box {

	Box data;
	BoxNode next;
   
	//Constructor to initialize the node with a data and a pointer
	public BoxNode(Box data)  {
		this.data = data;
      	this.next = null;
	}

}