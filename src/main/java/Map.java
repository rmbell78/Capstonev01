import java.util.ArrayList;
import java.lang.Math;

public class Map extends Display {
	static ArrayList<Object> mapObjects = new ArrayList<Object>();
	private int xWidth, yHeight;
	final int MAX_TREE = 2;
	final int MAX_BUSH = 2;

	public Map(int xWidth, int yHeight) throws MapParametersException {
		super();
		if (xWidth > 50 | xWidth < 0) {
			throw new MapParametersException("X Parameters out of bounds 0 < x < 50");
		} else if (yHeight > 50 | yHeight < 0) {
			throw new MapParametersException("Y Parameters out of bounds 0 < x < 50");
		} else {
			this.xWidth = xWidth;
			this.yHeight = yHeight;
		}
	}

	public void createPawn(int x, int y) {
		mapObjects.add(new Pawn(x, y));
	}

	public void createWarehouse(int x, int y) throws MapParametersException {
		if (x > xWidth | x <= 0 && y > yHeight | y <= 0) {
			throw new MapParametersException("Warehouse is not on map");
		} else {
			mapObjects.add(new Warehouse(x, y));
		}
	}

	static Object objectAt(int x, int y) {
		Object returnObject = null;
		for (int i = 0; i < mapObjects.size(); i++) {
			if (mapObjects.get(i) instanceof Pawn) {
				Pawn pawn = (Pawn) mapObjects.get(i);
				if (pawn.getX() == x && pawn.getY() == y) {
					returnObject = pawn;
				}
				// wareHouse stores pattern variable from instanceof if true
			} else if (mapObjects.get(i) instanceof Warehouse) {
				Warehouse wareHouse = (Warehouse) mapObjects.get(i);
				if (wareHouse.getX() == x && wareHouse.getY() == y) {
					returnObject = wareHouse;
				}
				} else if (mapObjects.get(i) instanceof Tree) {
				Tree tree = (Tree) mapObjects.get(i);
				if (tree.getX() == x && tree.getY() == y) {
					returnObject = tree;
				}
				} else if (mapObjects.get(i) instanceof Bush) {
				Bush bush = (Bush) mapObjects.get(i);
					if (bush.getX() == x && bush.getY() == y) {
						returnObject = bush;
					}
				}
			}
		return returnObject;
	}

	public void generateResources() {
		for (int i = 1; i <= MAX_BUSH; i++) {
			boolean goodGen = false;
			int x, y;
			do{
				x = (int) (Math.random() * xWidth);
				y = (int) (Math.random() * yHeight);
				if(x != 0 && y != 0 && objectAt(x, y) == null){
					goodGen = true;
				}
			} while(!goodGen);
			mapObjects.add(new Bush(x, y));
		}
		for (int i = 1; i <= MAX_TREE; i++) {
			boolean goodGen = false;
			int x, y;
			do{
				x = (int) (Math.random() * xWidth);
				y = (int) (Math.random() * yHeight);
				if(x != 0 && y != 0 && objectAt(x, y) == null){
					goodGen = true;
				}
			} while(!goodGen);
			mapObjects.add(new Tree(x, y));

		}

	}

	public int getxWidth() {
		return xWidth;
	}

	public int getyHeight() {
		return yHeight;
	}

	public void draw() {
		Display.draw(mapObjects, xWidth, yHeight);
	}

	
}
