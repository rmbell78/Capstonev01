import java.util.ArrayList;
public class Display {

	public Display() {
	}

	static void draw(ArrayList<Object> map, int xWidth, int yHeight) {
		for (int i = 1; i <= xWidth; i++) {
			System.out.print("____");
		}
		System.out.print("_\n");
		for (int y = 1; y <= yHeight; y++) {
			System.out.print("|");
			for (int x = 1; x <= xWidth; x++) {
				Object objectAt = Map.objectAt(x, y);
				if (objectAt != null) {
					if (objectAt instanceof Pawn) {
						System.out.printf(" %c |", Pawn.DISPLAY_CHAR);
					} else if (objectAt instanceof Warehouse) {
						Warehouse wareHouse = (Warehouse) objectAt;
						System.out.printf(" %c |", Warehouse.DISPLAY_CHAR);
					}else if (objectAt instanceof Tree) {
						System.out.printf(" %c |", Tree.DISPLAY_CHAR);
					}else if (objectAt instanceof Bush) {
						System.out.printf(" %c |", Bush.DISPLAY_CHAR);
					}
				} else {
					System.out.print("   |");
				}
			}
			System.out.print("\n-");
			for (int i = 1; i <= xWidth; i++) {
				System.out.print("----");
			}
			System.out.print("\n");

		}
	}
}
