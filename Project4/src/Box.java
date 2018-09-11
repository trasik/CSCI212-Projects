public class Box implements Comparable<Box> {
	
	private int length , width, height = 0;
	
	public Box() {
		length = 1;
		width = 1;
		height = 1;
	}
	
	public Box(int length, int width, int height) {
		if (length < 1 || width < 1 || height < 1)
			throw new IllegalBoxException("Parameters for creating a Box cannot be less than one.");
		this.length = length;
		this.width = width;
		this.height = height;
	}
	
	public void setLength(int length) {
		if (length < 1)
			throw new IllegalBoxException("Parameters for length cannot be less than one.");
		this.length = length;
	}
	
	public void setWidth(int width) {
		if (width < 1)
			throw new IllegalBoxException("Parameters for width cannot be less than one.");
		this.width = width;
	}
	
	public void setHeight(int height) {
		if (height < 1)
			throw new IllegalBoxException("Parameters for height cannot be less than one.");
		this.height = height;
	}
	
	public int getLength() {
		return length;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int volume() {
		return this.length * this.width * this.height;
	}
	
	public boolean equals (Object other) {
		if (this == other)
			return true;
		if(other != null && this.getClass().equals(other.getClass())) {
			return this.length == ((Box) other).getLength() &&
				   this.width == ((Box) other).getWidth() &&
				   this.height == ((Box) other).getHeight();
		}
		return false;
	}
	
	public String toString() {
		return "L:" + this.length + " W:" + this.width + " H:" + this.height + " (V:" + this.volume() + ")";
	}
	
	public int compareTo(Box other) {
		return this.volume() - other.volume();
	}
}
