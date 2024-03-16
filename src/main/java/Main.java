import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Map map = null;
		Scanner input = new Scanner(System.in);
		/*
		 * Map map1 = new Map(15, 5);
		 * 
		 * map1.draw();
		 * 
		 * map1.createPawn(5, 5);
		 * 
		 * map1.draw();
		 */

		testMapResourceGeneration(input, map);
	}

	static void mainMenu(Scanner input, Map map) {
		int mainMenuChoice = 0;
		String usrInput;
		System.out.println(
				"Welcome to my simple game for cs112.\n\nYour goal is to survive for as long as possible and grow your population to the max possible. Eventually you will reach a point where the resources provided cannot support the population.\n");
		System.out.println("Main Menu: ");
		System.out.println(
				"1 to begin game\n2 for game controls\n3 for more information about the game\n4 to exit. You can type exit at any time to exit the game");
		do {
			mainMenuChoice = input.nextInt();
			switch (mainMenuChoice) {
				case (1):
					System.out.println("\nstart:\n");
					map = startGame(input, map);
					map.draw();
					break;

				case (2):
					System.out.println("controls");
					break;

				case (3):
					System.out.println("Info");
					break;

				case (4):
					System.out.println("exit");
					break;
			}
		} while (mainMenuChoice != 4);
		System.out.println("Thanks for playing!");
	}

	static Map startGame(Scanner input, Map map) {
		int x, y;
		boolean goodMapGen = false;

		System.out.println(
				"First enter an x and a y value for the map size you wish, resources will be automatically placed across the map.");

		while (!goodMapGen) {
			try {
				System.out.print("\nX: ");
				x = input.nextInt();
				System.out.print("\nY: ");
				y = input.nextInt();
				map = new Map(x, y);
				goodMapGen = true;
			} catch (MapParametersException mpe) {
				System.out.println(mpe.getMessage());
			}
		}

		System.out.println("Good, now place your first Warehouse somewhere on the map");
		map.draw();
		goodMapGen = false;

		while (!goodMapGen) {
			try {
				System.out.print("\nX: ");
				x = input.nextInt();
				System.out.print("\nY: ");
				y = input.nextInt();
				map.createWarehouse(x, y);
				goodMapGen = true;
			} catch (MapParametersException mpe) {
				System.out.println(mpe.getMessage());
			}
		}
		return map;
	}

	static void testMapResourceGeneration(Scanner input, Map map) {
		int x, y;
		boolean goodMapGen = false;
		while (!goodMapGen) {
			try {
				System.out.print("\nX: ");
				x = input.nextInt();
				System.out.print("\nY: ");
				y = input.nextInt();
				map = new Map(x, y);
				goodMapGen = true;
			} catch (MapParametersException mpe) {
				System.out.println(mpe.getMessage());
				}
		}
		map.draw();
		map.generateResources();
		map.draw();
	}
}
