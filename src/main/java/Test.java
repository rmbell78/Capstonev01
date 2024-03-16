public class Test{
	public Test(){
	}

	static void testMapResourceGeneration(Scanner input, Map map){
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
}