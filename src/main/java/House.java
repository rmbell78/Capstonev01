import java.util.ArrayList;

public class House implements Placeable{
	public static int numHouses;
	private final int HOUSE_CAPACITY = 3;
	private int[] location = new int[2];
	private ArrayList<Object> houseOccupants = new ArrayList<Object>();
	static final char DISPLAY_CHAR = 'A';
	
	public House(int x, int y){
		location[0] = x;
		location[1] = y;
		numHouses++;
	}

	public boolean addOcuppants(Object newOccupant){
		if (houseOccupants.size() >= HOUSE_CAPACITY){
			return true;
		}
		houseOccupants.add(newOccupant);
		return false;
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