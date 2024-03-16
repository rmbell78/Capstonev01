public class Warehouse extends Inventory implements Placeable {
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

	@Override
	public int getX() {
		return location[0];
	}

	@Override
	public int getY() {
		return location[1];
	}


}
