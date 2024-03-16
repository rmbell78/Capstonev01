public class Warehouse extends Inventory {
	private int[] location = new int[2];
	// [x][y] base 1
	static final char DISPLAY_CHAR = 'x';

	public Warehouse(int x, int y) {
		location[0] = x;
		location[1] = y;
	}

	public int[] getLocation() {
		return location;
	}

	public int getX() {
		return location[0];
	}

	public int getY() {
		return location[1];
	}


}
